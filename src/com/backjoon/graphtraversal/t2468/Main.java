package com.backjoon.graphtraversal.t2468;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int dx[] = {-1, 0, 1, 0};
	private static int dy[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int minHeight = 100;
		int maxHeight = 1;
		StringTokenizer st = null;
		int[][] area = new int[n][n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()); 
			for (int j=0; j<n; j++) {
				int height = Integer.parseInt(st.nextToken());
				minHeight = Math.min(minHeight, height);
				maxHeight = Math.max(maxHeight, height);
				area[i][j] = height;
			}
		}
		
		int maxCount = 1;
		for (int i=minHeight; i<=maxHeight; i++) {
			int count = getCount(n, area, i);
			maxCount = Math.max(maxCount, count);
		}
		
		System.out.println(maxCount);
	}

	private static int getCount(int n, int[][] area, int rain) {
		boolean[][] isVisited = new boolean[n][n];
		
		int count = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (area[i][j] > rain && !isVisited[i][j]) {
					count++;
					dfs(i, j, area, isVisited, rain);
				}
			}
		}
		return count;
	}

	private static void dfs(int x, int y, int[][] area, boolean[][] isVisited, int rain) {
		isVisited[x][y] = true;
		
		int n = area.length;
		for (int i=0; i<dx.length; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
				if (area[newX][newY] > rain && !isVisited[newX][newY]) {
					dfs(newX, newY, area, isVisited, rain);
				}
			}
		}
	}
}
