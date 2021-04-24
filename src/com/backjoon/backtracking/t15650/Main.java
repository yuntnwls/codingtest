package com.backjoon.backtracking.t15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] answer = new int[m];
		StringBuffer sb = new StringBuffer();
		
		dfs(n, m, 0, 0, answer, sb);
		System.out.println(sb);
	}

	private static void dfs(int n, int m, int at, int depth, int[] answer, StringBuffer sb) {
		if (depth == m) {
			for (int val : answer) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=at; i<n; i++) {
			answer[depth] = i+1;
			dfs(n, m, i+1, depth+1, answer, sb);
		}
	}
}

//https://st-lab.tistory.com/115