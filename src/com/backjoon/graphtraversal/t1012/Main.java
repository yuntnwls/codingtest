package com.backjoon.graphtraversal.t1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1012
public class Main {
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for (int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] map = new int[m][n];
			for (int s=0; s<k; s++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			
			solution(m, n, map);
		}
	}

	private static void solution(int m, int n, int[][] map) {
		int answer = 0;
		boolean[][] isVisited = new boolean[m][n];
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (!isVisited[i][j] && map[i][j] == 1) {
					dfs(map, isVisited, i, j);
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}

	private static void dfs(int[][] map, boolean[][] isVisited, int x, int y) {
		isVisited[x][y] = true;
		
		for (int i=0; i<dx.length; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length) {
				if (!isVisited[newX][newY] && map[newX][newY] == 1) {
					dfs(map, isVisited, newX, newY);
				}
			}
		}
	}
}
