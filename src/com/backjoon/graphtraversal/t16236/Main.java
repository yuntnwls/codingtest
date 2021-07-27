package com.backjoon.graphtraversal.t16236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int n;
	private static int weight = 2;
	
	private static int dx[] = {-1, 0, 1, 0};
	private static int dy[] = {0, 1, 0, -1};
		 
	static class Pos {
		int x;
		int y;
		int dist;
		public Pos(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][n];
		StringTokenizer st;
		int num;
		Pos sharkPos = null;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				num = Integer.parseInt(st.nextToken());
				if (num == 9) {
					sharkPos = new Pos(i, j, weight);
					num = 0;
				}
				map[i][j] = num;
			}
		}
		
		int answer = bfs(map, sharkPos);
		System.out.println(answer);
	}

	private static int bfs(int[][] map, Pos sharkPos) {
		// 1. 먹을 물고기가 있는지 탐색 
		// 1-1. 제일 가까운 물고기 탐색은 자연스럽게 BFS로 해결, 만약 먹을 물고기 동률 -> 가장위 -> 가장 왼쪽 
		// 2. 먹을 물고기 찾으면 먹고 나이 증가 체크 
		// 3. 큐에 있는 모든 포인트를 날리고 현재 찾은 포인트만 add
		int eat = 0;
		int time = 0;
		
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.add(sharkPos);
		
		while (true) {
			List<Pos> fishes = new ArrayList<Pos>();
			int[][] dist = new int[n][n];	// 현재 위치부터의 거리 
			
			while (!queue.isEmpty()) {
				Pos curr = queue.poll();
				
				for (int i=0; i<dx.length; i++) {
					int nX = curr.x + dx[i];
					int nY = curr.y + dy[i];
					
					if (isPass(nX, nY) && dist[nX][nY] == 0 && map[nX][nY] <= weight) {
						// 먹을 수 있는 물고기 
						dist[nX][nY] = dist[curr.x][curr.y] + 1;
						if (map[nX][nY] >= 1 && map[nX][nY] <= 6 && map[nX][nY] < weight) {
							fishes.add(new Pos(nX, nY, dist[nX][nY]));
							queue.add(new Pos(nX, nY, dist[nX][nY]));
							continue;
						}
						// 먹을 수 없는 물고기 
						queue.add(new Pos(nX, nY, dist[nX][nY]));
					}
				}
			}
			
			// 모든 물고기를 다 먹은 경우 
			if (fishes.size() == 0) {
				return time;
			}
			
			// 먹을 수 있는 물고기의 가장 우선순위 물고기 구하기 
			Pos eatingFish = fishes.get(0);
			for (int i=1; i<fishes.size(); i++) {
				// 최소거리의 물고기 위치 구하기 
				if (eatingFish.dist > fishes.get(i).dist) {
					eatingFish = fishes.get(i);
				}
				
				// 먹을 수 있는 물고기가 여러개 있다면 
				if (eatingFish.dist == fishes.get(i).dist) {
					// 위쪽 우선 
					if (eatingFish.x > fishes.get(i).x) {
						eatingFish = fishes.get(i);
						continue;
					} else if (eatingFish.x == fishes.get(i).x) {
						// 위쪽도 동일하다면 가장 왼쪽 
						if (eatingFish.y > fishes.get(i).dist) {
							eatingFish = fishes.get(i);
						}
					}
				}
			}
			
			time += eatingFish.dist;
			// 먹은 물고기 수 증가 
			eat++;
			map[eatingFish.x][eatingFish.y] = 0;
			// 먹은 물고기 수와 현재 무게가 같다면 무게 증가 
			if (eat == weight) {
				weight++;
				eat = 0;	// 먹은 물고기수 리셋 
			}
			// 새로운 위치 다시 설정 
			queue.add(new Pos(eatingFish.x, eatingFish.y, weight));
		}
		
	}
	
	private static boolean isPass(int x, int y) { 
		if (x >= 0 && x < n && y >=0 && y < n) {
			return true;
		}
		return false;
	}
}
