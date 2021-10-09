package com.backjoon.graphtraversal.t17406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17406
public class Main {

	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, -1, 0, 1};
	private static int answer = 10000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] game = new int[K][3];
		for (int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				game[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solution(A, game);
		System.out.println(answer);
	}

	private static void solution(int[][] A, int[][] game) {
		// game의 순서는 정해져있지않으므로 모든 경우를 해봐야함 
		// 해당 게임을 실행했는지의 여부 
		boolean[] isPlay = new boolean[game.length];
		dfs(A, game, 0, isPlay);
	}
	
	private static void dfs(int[][] A, int[][] game, int count, boolean[] isPlay) {
		if (count == game.length) {
			answer = Math.min(answer, getMinValue(A));
			return;
		}
		
		for (int i=0; i<game.length; i++) {
			if (isPlay[i]) {
				continue;
			}
			// 백트래킹 기법 
			int[][] convertedArr = rotation(A, game[i]);
			isPlay[i] = true;
			dfs(convertedArr, game, count+1, isPlay);
			isPlay[i] = false;
		}
	}

	private static int[][] rotation(int[][] A, int[] game) {
		int r = game[0]-1;
		int c = game[1]-1;
		int s = game[2];
		// 배열을 복사해서 사용 
		int[][] copyArr = copy(A);
		
		// 방향백터를 사용하여 회전 
		// 중심점을 잡고 대각선을 계속 이동 
		for (int i=1; i<=s; i++) {
			// 출발 지점 정하기(우측상단부터) 
			int x = r-i;
			int y = c+i;
			// 우측 상단에서 이동을 시하므로 각 변을 남->서->북->동 방향으로 이동 
			// 4방향을 이동(남, 서, 북, 동)
			for (int w=0; w<dx.length; w++) {
				// 내 중심점에서 멀어진 길이의 2배만큼 움직인다.
				for (int d=0; d<i*2; d++) {
					int newX = x + dx[w];
					int newY = y + dy[w];
					copyArr[newX][newY] = A[x][y];
					x = newX;
					y = newY;
				}
			}
		}
		return copyArr;
	}
	

	private static int[][] copy(int[][] orgin) {
		int[][] copy = new int[orgin.length][orgin[0].length];
		for (int i=0; i<orgin.length; i++) {
			copy[i] = orgin[i].clone();
		}
		return copy;
	}

	private static int getMinValue(int[][] A) {
		int min = Integer.MAX_VALUE;
		for (int i=0; i<A.length; i++) {
			int sum = 0;
			for (int j=0; j<A[i].length; j++) {
				sum += A[i][j];
			}
			min = Math.min(min, sum);
		}
		return min;
	}
}
