package com.backjoon.graphtraversal.t7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int dx[] = {-1, 0, 1, 0};
	private static int dy[] = {0, 1, 0, -1};
	private static int n = 0;
	private static int m = 0;
	
	static class Tomato {
		int x;
		int y;
		public Tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		int[][] box = new int[n][m];
		Queue<Tomato> queue = new LinkedList<Main.Tomato>();
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					queue.add(new Tomato(i, j));
				}
			}
		}
		bfs(box, queue);
	
		int answer = getDayCount(box);
		System.out.println(answer);
	}

	private static int getDayCount(int[][] box) {
		int answer = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (box[i][j] == 0) {
					return -1;
				}
				answer = Math.max(answer, box[i][j]);
			}
		}
		if (answer == 1) {
			// 모두 익어있는 경우  
			return 0;
		} else {
			// 모두 익지 않은 경우 
			return answer - 1;
		}
	}

	private static void bfs(int[][] box, Queue<Tomato> queue) {
		while (!queue.isEmpty()) {
			Tomato tomato = queue.poll();
			
			for (int i=0; i<dx.length; i++) {
				int newX = tomato.x + dx[i];
				int newY = tomato.y + dy[i];
				
				if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
					if (box[newX][newY] == 0) {	// 토마토가 익지 않았다면 
						// 익은 토마토 추가 
						queue.add(new Tomato(newX, newY));
						box[newX][newY] = box[tomato.x][tomato.y] + 1;
					}
				}
			}
		}
	}
}
