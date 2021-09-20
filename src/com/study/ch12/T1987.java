package com.study.ch12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T1987 {
	
	private static int r;
	private static int c;
	private static boolean[] isVisited;
	private static char[][] board;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	private static int answer = 1;
	private static int count = 1;
	
	static class Node {
		int x;
		int y;
		String move;
		public Node(int x, int y, String move) {
			this.x = x;
			this.y = y;
			this.move = move;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[26];
		board = new char[r][c];
		for (int i=0; i<r; i++) {
			String line = br.readLine();
			board[i] = line.toCharArray();
			for (int j=0; j<c; j++) {
				board[i][j] = (char)(board[i][j]-'A');
			}
		}
		
		dfs(0, 0);
		
		System.out.println(answer);
	}

	private static void dfs(int x, int y) {
		char now = board[x][y];
		isVisited[now] = true;
		
		int newX, newY;
		for (int i=0; i<dx.length; i++) {
			newX = x + dx[i];
			newY = y + dy[i];
			if (newX >= 0 && newX < r && newY >= 0 && newY < c) {
				if (!isVisited[board[newX][newY]]) {
					answer = Math.max(++count, answer);
					dfs(newX, newY);
				}
			}
		}
		
		// 더이상 이동일 불가능한 경우
		// 해당 정점의 방문여부를 없애고 움직인 칸의 수를 뺸다.
		--count;
		isVisited[now] = false;
	}
}
