
package com.backjoon.graphtraversal.t1987;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int r;
	private static int c;
	private static int result = 1;
	private static int count = 1;
	
	private static int dx[] = {-1, 0, 1, 0};
	private static int dy[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		boolean[] isVisited = new boolean[26];
		char[][] board = new char[r][c];
		for (int i=0; i<r; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j=0; j<c; j++) {
				board[i][j] = (char)(board[i][j]-'A');
			}
		}
		
		dfs(0, 0, board, isVisited);
		System.out.println(result);
	}

	private static void dfs(int x, int y, char[][] board, boolean[] isVisited) {
		int curr = board[x][y];
		isVisited[curr] = true;
		
		for (int i=0; i<dx.length; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if (newX >= 0 && newX < r && newY >=0 && newY < c) {
				int next = board[newX][newY];
				if (!isVisited[next]) {
					result = Math.max(++count, result);
					dfs(newX, newY, board, isVisited);
				}
			}
		}
		
		--count;
		isVisited[curr] = false;
	}
}
