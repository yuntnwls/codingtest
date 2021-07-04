package com.backjoon.graphtraversal.t2583;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int m;
	private static int n;
	private static int count;
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] area = new int[m][n];
		for (int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int yCount = Integer.parseInt(st.nextToken());
			int xCount = Integer.parseInt(st.nextToken());
			
			for (int w = x; w < xCount; w++) {
				for (int h = y; h < yCount; h++) {
					area[w][h] = area[w][h]+1;
				}
			}
		}
		
		List<Integer> countList = new ArrayList<Integer>();
		boolean[][] isVisited = new boolean[m][n];
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (area[i][j] == 0 && !isVisited[i][j]) {
					count = 0;
					dfs(i, j, area, isVisited);
					countList.add(count);
				}
			}
		}
		
		System.out.println(countList.size());
		Collections.sort(countList);
		for (int i=0; i<countList.size(); i++) {
			System.out.print(countList.get(i) + " ");
		}
	}

	private static void dfs(int x, int y, int[][] area, boolean[][] isVisited) {
		isVisited[x][y] = true;
		count++;
		
		for (int i=0; i<dx.length; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if (newX>=0 && newX<m && newY>=0 && newY<n) {
				if (area[newX][newY] == 0 && !isVisited[newX][newY]) {
					dfs(newX, newY, area, isVisited);
				}
			}
		}
	}
}
