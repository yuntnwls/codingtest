package com.study.ch09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T1012 {
	
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {-1, 0, 1, 0};
	
	private static int m;
	private static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for (int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[m][n];
			boolean[][] isVisited = new boolean[m][n];
			int x = 0, y = 0;
			for (int j=0; j<k; j++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			
			int count = 0;
			for (int s=0; s<m; s++) {
				for (int j=0; j<n; j++) {
					if (map[s][j] == 1 && !isVisited[s][j]) {
						dfs(map, s, j, isVisited);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	private static void dfs(int[][] map, int x, int y, boolean[][] isVisited) {
		isVisited[x][y] = true;
		
		int newX=0, newY=0;
		for (int i=0; i<dx.length; i++) {
			newX = x+dx[i];
			newY = y+dy[i];
			if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
				if (map[newX][newY] == 1 && !isVisited[newX][newY]) {
					dfs(map, newX, newY, isVisited);
				}
			}
		}
	}
}
