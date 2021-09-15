package com.study.ch11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class T2012 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] rank = new int[n];
		for (int i=0; i<n; i++) {
			rank[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(rank);
		
		int answer = 0;
		for (int i=1; i<=n; i++) {
			answer += Math.abs(rank[i-1] - i);
		}
		System.out.println(answer);
	}
}
