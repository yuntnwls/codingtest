package com.study.ch12;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class T9663 {
	// 퀸은 상하좌우 대각선 모두 이동 가능 
	// 백트리킹 : 가능한 경우를 전부 탐색을 하면서 더이상 나아갈 수 없는 경우 이전으로 돌아가 다시 수행 
	
	private static int n;
	private static int[] row;
	private static int answer;
	
	// DFS를 이용 단, DFS는 구현은 간단하나 BFS보다 속도가 느림.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		answer = 0;
		row = new int[n];
		// 각 행을 차례대로 확인 
		dfs(0);
		
		System.out.println(answer);
	}

	private static void dfs(int x) {
		if (x == n) {
			// 모든 행을 확인한 경우 
			answer += 1;
		} else {
			// x번째 행의 각 열에 Queen 두기 
			for (int i=0; i<n; i++) {
				row[x] = i;
				// 해당 위치에 Queen을 놓아도 되는지 확인 
				if (check(x)) {
					dfs(x+1);
				}
			}
		}
	}

	private static boolean check(int x) {
		for (int i=0; i<x; i++) {
			// 위에 있는 경우 
			if (row[x] == row[i]) {
				return false;
			}
			// 대각선에 있는 경우 
			if (Math.abs(row[x] - row[i]) == x-i) {
				return false;
			}
		}
		return true;
	}
}
