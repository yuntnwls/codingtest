package com.backjoon.greedy.t11508;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] c = new Integer[n];
		for (int i=0; i<n; i++) {
			c[i] = Integer.parseInt(br.readLine());
		}
		int answer = solution(n, c);
		System.out.println(answer);
	}

	private static int solution(int n, Integer[] c) {
		int answer = 0;
		
		Arrays.sort(c, Collections.reverseOrder());
		
		for (int i=0; i<c.length; i++) {
			if (i%3 != 2) {
				answer += c[i];
			}
		}
		return answer;
	}
}
