package com.backjoon.graphtraversal.t2644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int m;
	private static int p1, p2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		
		int[][] family = new int[n+1][n+1];
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			family[x][y] = 1;
			family[y][x] = 1;
		}
		
		boolean[] isVisited = new boolean[n+1];
		int[] depth = new int[n+1];
		bfs(family, isVisited, depth);
		
		int answer = -1;
		if (depth[p2] != 0) {
			answer = depth[p2];
		}
		System.out.println(answer);
	}

	private static void bfs(int[][] family, boolean[] isVisited, int[] depth) {
		Queue<Integer> queue = new LinkedList<>();
		isVisited[p1] = true;
		queue.add(p1);
		
		int temp;
		while(!queue.isEmpty()) {
			temp = queue.poll();
			
			for (int i=0; i<n; i++) {
				if (family[temp][i] == 1 && !isVisited[i]) {
					isVisited[i] = true;
					depth[i] = depth[temp] + 1;
					queue.add(i);
				}
			}
		}
	}
}

// https://kiung9085.tistory.com/9
