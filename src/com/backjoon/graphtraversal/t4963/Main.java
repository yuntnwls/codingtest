package com.backjoon.graphtraversal.t4963;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	private static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) {
				break;
			}
			int[][] map = new int[h][w];
			for (int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = solution(w, h, map);
			System.out.println(answer);
		}
	}

	private static int solution(int w, int h, int[][] map) {
		int answer = 0;

		boolean[][] visited = new boolean[h][w];
		// 모든 곳을 방문 
		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				// 육지이면서 방문하지 않은 경우 
				if (map[i][j] == 1 && !visited[i][j]) {
					answer++;
					dfs(i, j, map, visited);
				}
			}
		}
		
		return answer;
	}

	private static void dfs(int x, int y, int[][] map, boolean[][] visited) {
		visited[x][y] = true;
		
		for (int i=0; i<dx.length; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[x].length) {
				if (map[newX][newY] == 1 && !visited[newX][newY]) {
					dfs(newX, newY, map, visited);
				}
			}
		}
	}
}
