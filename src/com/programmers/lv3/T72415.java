package com.programmers.lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://programmers.co.kr/learn/courses/30/lessons/72415?language=java
public class T72415 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] board = new int[4][4];
		for (int i=0; i<4; i++) {
			String line = br.readLine();
			String[] split = line.split(",");
			for (int j=0; j<4; j++) {
				board[i][j] = Integer.parseInt(split[j]);
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int answer = solution(board, r, c);
		System.out.println(answer);
	}

	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {-1, 1, 0, 0};
	
	// 다익스트라 알고리즘 사용 (백트래킹 + 최단거리)
	private static int solution(int[][] board, int r, int c) {
		// r = y / c = x
		if (isGameOver(board))
			return 0;
		
		int answer = Integer.MAX_VALUE;
		
		// board[r][c] 의 위치에서 시작해 모든 종류의 카드 뒤집어보기
		// board의 원소는 1~6까지의 자연수 
		List<Point> pointList = new ArrayList<>();
		for (int k=1; k<=6; k++) {
			pointList.clear();
			for (int i=0; i<board.length; i++) {
				for (int j=0; j<board[i].length; j++) {
					if (board[i][j] == k) {
						pointList.add(new Point(i, j));
					}
				}
			}
			
			if (pointList.isEmpty())
				continue;
			
			// 앞에꺼를 먼저 뒤집음 
			int card1 = getDist(board, r, c, pointList.get(0).y, pointList.get(0).x) 
						+ getDist(board, pointList.get(0).y, pointList.get(0).x, pointList.get(1).y, pointList.get(1).x) + 2;

			// 뒤에꺼를 먼저 뒤집음 
			int card2 = getDist(board, r, c, pointList.get(1).y, pointList.get(1).x) 
						+ getDist(board, pointList.get(1).y, pointList.get(1).x, pointList.get(0).y, pointList.get(0).x) + 2;
			
			// DFS
			board[pointList.get(0).y][pointList.get(0).x] = 0;
			board[pointList.get(1).y][pointList.get(1).x] = 0;
			
			answer = Math.min(answer, Math.min(card1 + solution(board, pointList.get(1).y, pointList.get(1).x), 
											   card2 + solution(board, pointList.get(0).y, pointList.get(0).x)));
			
			board[pointList.get(0).y][pointList.get(0).x] = k;
			board[pointList.get(1).y][pointList.get(1).x] = k;
		}
		
		return answer;
	}
	
	// 다익스트라를 이용한 최소 키보드 입력 횟수 반환 
	private static int getDist(int[][] board, int y1, int x1, int y2, int x2) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(y1, x1, 0));
		
		int[][] dist = new int[4][4];
		for (int i=0; i<4; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[y1][x1] = 0;
		
		while(!pq.isEmpty()) {
			Point current = pq.poll();
			int currDist = current.dist;
			
			if (dist[current.y][current.x] < currDist)
				continue;
			
			if (current.x == x2 && current.y == y2)
				return currDist;
			
			for (int i=0; i<dx.length; i++) {
				int cnt = 0;
				int newX = current.x;
				int newY = current.y;
				
				// 한칸씩 i 방향으로 옮겨가며 최단거리 계산
				while (isRange(newY+dy[i], newX+dx[i])) {
					cnt++;
					newX += dx[i];
					newY += dy[i];
					
					if (board[newY][newX] != 0) {
						break; 	// 카드 마주침 
					}
					
					if (dist[newY][newX] > currDist+cnt) {
						dist[newY][newX] = currDist+cnt;
						pq.add(new Point(newY, newX, currDist+cnt));
					}
				}
				
				// 카드 또는 벽을 마주친 경우 Ctrl 키를 이용하여 1번만에 이동
				if (dist[newY][newX] > currDist+1) {
					dist[newY][newX] = currDist+1;
					pq.add(new Point(newY, newX, currDist+1));
				}
			}
		}
		return 0;
	}
	
	private static boolean isRange(int x, int y) {
		return x>=0 && x<4 && y>=0 && y<4;
	}
	
	private static boolean isGameOver(int[][] board) {
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				if (board[i][j] > 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	static class Point implements Comparable<Point> {
		int x;
		int y;
		int dist;
		
		public Point(int y, int x) {
			this.x = x;
			this.y = y;
		}
		public Point(int y, int x, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Point o) {
			return this.dist - o.dist;
		}
	}
}
// https://yjyoon-dev.github.io/kakao/2021/01/29/kakao-paircard/