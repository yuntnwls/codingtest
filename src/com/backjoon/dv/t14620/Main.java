package com.backjoon.dv.t14620;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14620
public class Main {
	
	// 자신의 위치도 포함 
	private static int[] dx = {0, -1, 0, 1, 0};
	private static int[] dy = {0, 0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i=0; i<N; i++) {
			String line = br.readLine();
			String[] split = line.split(" ");
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}
		
		int answer = solution(N, map);
		System.out.println(answer);
	}

	private static int solution(int N, int[][] map) {
		boolean[][] isVisited = new boolean[N][N];
		int answer = Integer.MAX_VALUE;
		// 각 칸은 x * N + y 값으로 표현가능하므로 위치를 좌표가 아닌 숫자로 사용 
		// 가장 바깥쪽 라인은 꽃이 피면 범위를 벗어나므로 안쪽까지만 확인 
		int minRange = N+1;
		int maxRange = (N-1) * N - 1;
		for (int i=minRange; i<maxRange; i++) {
			for (int j=minRange; j<maxRange; j++) {
				for (int k=minRange; k<maxRange; k++) {
					answer = Math.min(answer, getCost(N, new int[] {i, j, k}, map, isVisited));
				}
			}
		}
		return answer;
	}

	private static int getCost(int N, int[] pos, int[][] map, boolean[][] isVisited) {
		clear(isVisited);
		
		int cost = 0;
		int x, y;
		int newX, newY;
		for (int i=0; i<pos.length; i++) {
			x = pos[i] / N;
			y = pos[i] % N;
			for (int d=0; d<dx.length; d++) {
				newX = x + dx[d];
				newY = y + dy[d];
				// 밖으로 벗어나는지 확인 
				if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
					if (isVisited[newX][newY]) {
						// 서로 겹치는지 확인 
						return Integer.MAX_VALUE;
					}
					isVisited[newX][newY] = true;
					cost += map[newX][newY];
				} else {
					return Integer.MAX_VALUE;
				}
			}
		}
		return cost;
	}
	
	private static void clear(boolean[][] isVisited) {
		for (int i=0; i<isVisited.length; i++) {
			Arrays.fill(isVisited[i], false);
		}
	}
}
