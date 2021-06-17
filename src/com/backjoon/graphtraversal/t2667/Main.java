package com.backjoon.graphtraversal.t2667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int cnt = 0;
	private static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for (int i=0; i<n; i++) {
			String temp = br.readLine();
			String[] array = temp.split("");
			for (int j=0; j<array.length; j++) { 
				map[i][j] = Integer.parseInt(array[j]);
			}
		}
		
		boolean[][] visited = new boolean[n][n];
		List<Integer> homeCntList = new ArrayList<Integer>();
		
		// 모든 지점 모두 확인 
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt = 0;
					dfs(i, j, map, visited);
					homeCntList.add(cnt);
				}
			}
		}
		
		Collections.sort(homeCntList);
	
		System.out.println(homeCntList.size());
		for (int i=0; i<homeCntList.size(); i++) {
			System.out.println(homeCntList.get(i));
		}
	}

	private static void dfs(int x, int y, int[][] map, boolean[][] visited) {
		visited[x][y] = true;
		cnt++;
		
		for (int i=0; i<dx.length; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
				if (map[newX][newY] == 1 && !visited[newX][newY]) {
					dfs(newX, newY, map, visited);
				}
			}
		}
	}
}
