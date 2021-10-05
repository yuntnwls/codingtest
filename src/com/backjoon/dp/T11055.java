package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11055
public class T11055 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] dp = new int[n];
		int[] reverse = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			dp[i] = a[i];
		}
		
		int idx = 0;
		// DP[i] : i까지 왔을 때 합의 최대 
		for (int i=1; i<n; i++) {
			for (int j=0; j<i; j++) {
				if (a[i] > a[j]) {
					dp[i] = Math.max(a[i] + dp[j], dp[i]);
					reverse[i] = j;
				}
			}
			
			if (dp[idx] < dp[i]) {
				idx = i;
			}
		}
		
		int max = dp[0];
		for (int i=1; i<n; i++) {
			max = Math.max(dp[i], max);
		}
		// 최대합 출력 
		System.out.println(max);
	
		// 증가하는 수열 출력 
		List<Integer> answerList = new ArrayList<>();
		answerList.add(dp[idx]);
		while (reverse[idx] != idx) {
			answerList.add(a[idx]);
			idx = reverse[idx];
		}
		answerList.add(a[idx]);
		for (int i=answerList.size()-1; i>=0; i--) {
			System.out.print(answerList.get(i) + " ");
		}
	}
}
