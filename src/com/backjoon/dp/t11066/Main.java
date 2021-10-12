package com.backjoon.dp.t11066;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11066
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i=0; i<t; i++) {
			int k = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] times = new int[k+1];
			// 누적합에 대한 베열 
			// sums[i] : 1번부터 i번지의 누적값 
			int[] sums = new int[k+1];
			for (int j=1; j<=k; j++) {
				times[j] = Integer.parseInt(st.nextToken());
				sums[j] = sums[j-1] + times[j];
			}
			
			int answer = solution(k, times, sums);
			System.out.println(answer);
		}
	}

	private static int solution(int k, int[] times, int[] sums) {
		// DP[i][j] : i에서 j까 합하는데 필요한 최소 비용 
		// DP[i][k] + DP[k+1][j] + sum(A[i] ~ A[j])
		int[][] DP = new int[k+1][k+1];
		for (int i=2; i<=k; i++) { // 부분파일의 길이 
			for (int j=1; j<=k+1-i; j++) {	// 시적점 
				DP[j][j+i-1] = getMinValue(DP, i, j) + (sums[j+i-1] - sums[j-1]);
			}
		}
		
		return DP[1][k];
	} 
	
	private static int getMinValue(int[][] DP, int i, int j) {
		int min = Integer.MAX_VALUE;
		for (int n=0; n<i-1; n++) {
			// j에서 n만큼 떨어진 지점의 합과 그 다음 지점까지의 합 
			min = Math.min(min, (DP[j][j+n] + DP[j+n+1][j+i-1]));
		}
		return min;
	}
}
