package com.backjoon.dp.t2167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2167
// 누적합을 미리 구해두는 방식 
// DP[i] = i 까지의 합 
// i부터 j까지의 합은 DP[i] - DP[j-1] => j-1까지 더한 합들에서 i까지 더한 합들을 빼준다 
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] array = new int[n][m];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[n+1][m+1];
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				// 이차원 배열의 누적합 구하기 
				// 위쪽 + 왼쪽 - 대각선데이터
				// 1 2 
				// 8 16 => (1,1)까지의 합은 (0,1)까지의 합 + (1,0)까지의 합 - (0,0)의 합 + array본인의 값 
				//      => (0,1),(1,0)까지의 합을 만들때 (0,0)이 두번 들어갔으므로 한번 빼주기 
				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + array[i-1][j-1];
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		for (int t=0; t<k; t++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			//i,j 부터 x,j까지의 합 
			// 1,1  
			//      i,j    i-1,y 
			//     x,j-1    x,y
			// (x,y]까지의 합 - (i-1,y)까지의 합 - (x,j-1)까지의 합 + (i-1,j-1)까지의 합 
			// (i-1,j-1)까지의 합을 더하는 이유는 (i-1,y)까지의 합과 (x,j-1)까지의 합에서 해당부분을 두번 뺴줬기때문에 한번은 더해줘야함 
			int answer = dp[x][y] - dp[i-1][y] - dp[x][j-1] + dp[i-1][j-1];
			System.out.println(answer);
		}
	}
}
