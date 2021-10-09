package com.backjoon.graphtraversal.t12100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/12100
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		for (int i=0; i<N; i++) {
			String line = br.readLine();
			String[] split = line.split(" ");
			for (int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(split[j]);
			}
		}
		
		int answer = dfs(N, board, 5);
		System.out.println(answer);
	}

	private static int dfs(int n, int[][] board, int count) {
		int answer = getMaxValue(board);
		if (count == 0) {
			return answer;
		}
		
		// 상하좌우로 이동하는것을 구현하는 것이 아닌 
		// 보드 자체를 90도씩 돌려주면서 같은 방향으로 계속 이동하는 방법 사용 
		for (int i=0; i<4; i++) {
			if (!moveBoard(board, n)) {
				answer = Math.max(answer, dfs(n, board, count-1));
			}
			// 90도로 돌려주기 
			board = rotate90(board, n);
		}
		
		return answer;
	}
	
	private static int[][] rotate90(int[][] board, int n) {
		// 보드를 90도로 돌리기
		int[][] newBoard = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				newBoard[j][n-i-1] = board[i][j];
			}
		}
		return newBoard;
	}

	private static boolean moveBoard(int[][] board, int n) {
		// 이동 후 이전 보드와 동일한지 비교
		// 동일하다면 true, 동일하지 않다면 한번더 실행해야하므로 false
		// 보드의 데이터를 왼쪽으로 이동 
		int[][] preBoard = copyBoard(board, n);
		for (int i=0; i<board.length; i++) {
			moveLeftLine(board[i]);
		}
		
		boolean isSameBoard = true;
		for (int i=0; i<n; i++) {
			if (!Arrays.equals(preBoard[i], board[i])) {
				isSameBoard = false;
				break;
			}
		}
		return isSameBoard;
	}
	
	private static void moveLeftLine(int[] lineArr) {
		// 왼쪽으로 쏠리도록 모으기 
		int[] temp = new int[lineArr.length];
		int index = 0;
		for (int i=0; i<lineArr.length; i++) {
			if (lineArr[i] > 0) {
				temp[index++] = lineArr[i];
			}
		}
		
		// 값을 합치기 
		for (int i=1; i<lineArr.length; i++) {
			if (temp[i-1] == temp[i]) {
				temp[i-1] *= 2;
				temp[i] = 0;
			}
		}
		
		// 합친 값들을 다시 왼쪽으로 모으기 
		index = 0;
		for (int i=0; i<lineArr.length; i++) {
			if (lineArr[i] > 0) {
				lineArr[index++] = temp[i];
			}
		}
	}
	
	private static int[][] copyBoard(int[][] board, int n) {
		int[][] copy = new int[n][n];
		for (int i=0; i<n; i++) {
			copy[i] = board[i].clone();
		}
		return copy;
	}
	
	private static int getMaxValue(int[][] board) {
		int max = 0;
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				max = Math.max(max, board[i][j]);
			}
		}
		return max;
	}
}
