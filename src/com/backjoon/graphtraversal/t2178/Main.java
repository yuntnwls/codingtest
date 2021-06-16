package com.backjoon.graphtraversal.t2178;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n = 0;
	private static int m = 0;
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] miro = new int[n][m];
		int[][] checked = new int [n][m];
		for (int i=0; i<n; i++) {
			String line = br.readLine();
			String[] array = line.split("");
			for (int j=0; j<array.length; j++) {
				miro[i][j] = Integer.parseInt(array[j]);
			}
		}
		
		int answer = bfs(miro, checked);
		System.out.println(answer);
	}

	private static int bfs(int[][] miro, int[][] checked) {
		// 이동할 수 있는 방향 
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		boolean[][] visited = new boolean[n][m];
		Queue<Node> queue = new LinkedList<Node>();
		
		visited[0][0] = true;
		queue.add(new Node(0, 0));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int y = node.y;
			
			for (int i=0; i<dx.length; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				// 이동 가능한지 확인 
				if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
					// 갈 수 있는 길이고 방문한 적이 없는 길인 경우 
					if (miro[nextX][nextY] == 1 && visited[nextX][nextY] == false) {
						checked[nextX][nextY] = checked[x][y] + 1;
						visited[nextX][nextY] = true;
						queue.add(new Node(nextX, nextY));
					}
				}
			}
		}	
		return checked[n-1][m-1] + 1;
	}
}

//https://cocoon1787.tistory.com/115
