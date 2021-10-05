package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1915
public class T1915 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for (int i=0; i<n; i++) {
			String line = br.readLine();
			String[] split = line.split("");
			for (int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}
		
		// DP[i][j] = i, j까지 왔을 때, 가장 큰 정사각형의 한 변의 길이 
		// DP[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1
		int[][] dp = new int[n+1][m+1];
		int max = 0;
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				if (map[i-1][j-1] == 1) {
					dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]);
					dp[i][j] = Math.min(dp[i][j], dp[i][j-1]) + 1;
					max = Math.max(dp[i][j], max);
				}
			}
		}
		
		System.out.println(max*max);
	}
}
