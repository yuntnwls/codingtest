package com.backjoon.graphtraversal.t2206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int n;
	private static int m;
	
	private static int dx[] = {-1, 0, 1, 0};
	private static int dy[] = {0, 1, 0, -1};
	
	static class Pos {
		int x;
		int y;
		int dist;	// 이동거리 
		int block;	// 공사횟수 
		public Pos(int x, int y, int dist, int block) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.block = block;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		int[][] isVisited = new int[n][m];
		for (int i=0; i<n; i++) {
			String[] array = br.readLine().split("");
			for (int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(array[j]);
				isVisited[i][j] = Integer.MAX_VALUE;
			}
		}
		int answer = bfs(map, isVisited);
		System.out.println(answer);
	}

	private static int bfs(int[][] map, int[][] isVisited) {
		Queue<Pos> queue = new LinkedList<Pos>();
		
		queue.add(new Pos(0, 0, 1, 0));
		isVisited[0][0] = 0; // 처음 공사횟수 

		int currDist = 0;
		Pos now = null;
		int block = 0;
		while (!queue.isEmpty()) {
			now = queue.poll();
			
			currDist = now.dist;
			block = now.block;
			
			// 도착지점 종료 
			if (now.x == n-1 && now.y == m-1) {
				return currDist;
			}
			
			for (int i=0; i<dx.length; i++) {
				int newX = now.x + dx[i];
				int newY = now.y + dy[i];
				
				if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
					continue;
				}
				
				if (isVisited[newX][newY] <= block) {
					continue;
				}
				
				if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
					if (map[newX][newY] == 0) {
						// 벽이 없고 이동 가능한 경우
						isVisited[newX][newY] = block;
						queue.add(new Pos(newX, newY, currDist + 1, block));
					} else {
						// 벽이 있고 벽을 부술 수 있는 경우 
						if (block == 0) {
							isVisited[newX][newY] = block+1;
							queue.add(new Pos(newX, newY, currDist + 1, block+1));
						}
					}
				}
			}
		}
		
		return -1;
	}
}
