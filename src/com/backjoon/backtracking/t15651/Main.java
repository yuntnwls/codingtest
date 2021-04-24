package com.backjoon.backtracking.t15651;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] answer = new int[m];
		StringBuffer sb = new StringBuffer();
		
		dfs(n, m, 0, answer, sb);
		System.out.println(sb);
	}

	private static void dfs(int n, int m, int depth, int[] answer, StringBuffer sb) {
		if (depth == m) {
			for (int val : answer) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=0; i<n; i++) {
			answer[depth] = i+1;
			dfs(n, m, depth+1, answer, sb);
		}
	}
}
