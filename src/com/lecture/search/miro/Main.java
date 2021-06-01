package com.lecture.search.miro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int n = 0;
	private static int m = 0;
	private static int[][] road;

	// BFS를 사용 : 간선의 비용이 모두 같을 때 최단 거리를 탐색하기위해 사용 
	// 이동할 네가지 방향 정의 (상, 하, 좌, 우) 
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		road = new int[n][m];
		for (int i=0; i<n; i++) {
			String[] arr = br.readLine().split("");
			for (int j=0; j<arr.length; j++) {
				road[i][j] = Integer.parseInt(arr[j]);
			}
		}
		
		int answer = bfs(0, 0);
		System.out.println(answer);
	}
	
	private static int bfs(int x, int y) {
		// 큐 구현을 위해 queue 라이브러리 사용 
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		// 큐가 빌 때까지 반복 
		while (!q.isEmpty()) {
			Node node = q.poll();
			x = node.x;
			y = node.y;
			// 현재 위치에서 네가지 방향으로 위치 확인 
			for (int i=0; i<dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				// 미로 범위를 벗어난 경우 
				if (nx < 0 || nx >= n || ny < 0 || ny >=m) {
					continue;
				}
				// 벽인 경우 
				if (road[nx][ny] == 0) {
					continue;
				}
				if (road[nx][ny] == 1) {
					road[nx][ny] = road[x][y] + 1;
					q.offer(new Node(nx, ny));
				}
			}
		}
		// 가장 오른쪽 아래까지의 최단 거리 반환 
		return road[n-1][m-1];
	}
}
