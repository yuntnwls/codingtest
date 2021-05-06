package com.backjoon.greedy.t19939;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int answer= solution(n, k);
		System.out.println(answer);
	}

	private static int solution(int n, int k) {
		int total = n;
		int minimum = 0;
		for (int i=1; i<=k; i++) {
			minimum += i;
		}
		total -= minimum;
		if (total < 0) {
			return -1;
		}
		total %= k;
		if (total > 0) {
			return k;
		}
		return (k-1);
	}
}
