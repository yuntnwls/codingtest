package com.study.ch09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T1260 {
	private static int n;
	private static int m;
	private static int[][] nodes;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		nodes = new int[n+1][n+1];
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			nodes[node1][node2] = 1;
			nodes[node2][node1] = 1;
		}
		
		boolean[] isVisited = new boolean[n+1];
		dfs(s, isVisited);
		
		System.out.println();
		Arrays.fill(isVisited, false);
		
		bfs(s, isVisited);
	}

	private static void bfs(int s, boolean[] isVisited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		isVisited[s] = true;
		queue.add(s);
		
		int now = -1;
		while (!queue.isEmpty()) {
			now = queue.poll();
			System.out.print(now + " ");
			
			for (int i=1; i<=n; i++) {
				if (nodes[now][i] == 1 && !isVisited[i]) {
					isVisited[i] = true;
					queue.add(i);
				}
			}
		}
	}

	private static void dfs(int s, boolean[] isVisited) {
		isVisited[s] = true;
		System.out.print(s + " ");
		
		for (int i=1; i<=n; i++) {
			if (nodes[s][i] == 1 && !isVisited[i]) {
				dfs(i, isVisited);
			}
		}
	}
}
