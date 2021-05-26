package com.backjoon.greedy.t20044;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] w = new int[n*2];
		for (int i=0; i<n*2; i++) {
			w[i] = Integer.parseInt(st.nextToken());
		}
		int answer = solution(n, w);
		System.out.println(answer);
	}

	private static int solution(int n, int[] w) {
		Arrays.sort(w);
		
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int i=0; i<n; i++) {
			sum = w[i] + w[2*n-i-1];
			min = Math.min(min, sum);
		}
		return min;
	}
}
