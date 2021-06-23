package com.backjoon.graphtraversal.t2606;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int computer[][] = new int[n+1][n+1];
		boolean visited[] = new boolean[n+1];
		StringTokenizer st = null;
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			computer[front][back] = 1;
			computer[back][front] = 1;
		}
		
		dfs(1, computer, visited);
		
		System.out.println(count-1);
	}

	private static void dfs(int i, int[][] computer, boolean[] visited) {
		visited[i] = true;
		count++;
		
		for (int t=0; t<computer[i].length; t++) {
			if (computer[i][t] == 1 && !visited[t]) {
				dfs(t, computer, visited);
			}
		}
	}
}
