package com.backjoon.greedy.t11399;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] p = new int[n];
		for (int i=0; i<n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		int answer = solution(n, p);
		System.out.println(answer);
	}

	private static int solution(int n, int[] p) {
		int answer = 0;
		// 오름차순 정렬 
		Arrays.sort(p);
		int sum = 0;
		for (int i=0; i<n; i++) {
			sum += p[i];
			answer += sum;;
		}
		return answer;
	}
}
