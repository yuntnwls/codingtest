package com.study.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T1053 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] data = new int[n];
		int[] dp = new int [n];
		for (int i=0; i<n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		solution(data, dp);
	}

	private static void solution(int[] data, int[] dp) {
		int max = 1;
		for (int i=1; i<data.length; i++) {
			for (int j=0; j<i; j++) {
				if (data[j] < data[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
					max = Math.max(max, dp[i]);
				}
			}
		}
		System.out.println(max);
	}
}
