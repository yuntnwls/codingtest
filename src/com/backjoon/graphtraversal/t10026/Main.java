package com.backjoon.graphtraversal.t10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	private static int n;
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		String[][] colorMap = new String[n][n];
		for (int i=0; i<n; i++) {
			colorMap[i] = br.readLine().split("");
		}
		
		String[] colorArray = {"R", "G", "B"};
		int count = 0;
		for (int i=0; i<colorArray.length; i++) {
			count += getColor(colorMap, colorArray[i]);
		}
		System.out.println(count);
		
		changeRToG(colorMap);
		
		count = 0;
		for (int i=1; i<colorArray.length; i++) {
			count += getColor(colorMap, colorArray[i]);
		}
		System.out.println(count);
	}
	
	private static void changeRToG(String[][] colorMap) {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (colorMap[i][j].equals("R")) {
					colorMap[i][j] = "G";
				}
			}
		}
	}
	
	private static int getColor(String[][] colorMap, String color) {
		int count = 0;
		boolean[][] isVisited = new boolean[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (colorMap[i][j].equals(color) && !isVisited[i][j]) {
					count++;
					dfs(i, j, colorMap, color, isVisited);
				}
			}
		}
		return count;
	}

	private static void dfs(int x, int y, String[][] colorMap, String color, boolean[][] isVisited) {
		isVisited[x][y] = true;
		
		for (int i=0; i<dx.length; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
				if (colorMap[newX][newY].equals(color) && !isVisited[newX][newY]) {
					isVisited[newX][newY] = true;
					dfs(newX, newY, colorMap, color, isVisited);
				}
			}
		}
	}
}
