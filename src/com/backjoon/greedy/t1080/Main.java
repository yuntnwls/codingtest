package com.backjoon.greedy.t1080;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1080
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arrA = new int[n][m];
		int[][] arrB = new int[n][m];
		for (int i=0; i<n; i++) {
			String line = br.readLine();
			String[] split = line.split("");
			for (int j=0; j<m; j++) {
				arrA[i][j] = Integer.parseInt(split[j]);
			}
		}
		for (int i=0; i<n; i++) {
			String line = br.readLine();
			String[] split = line.split("");
			for (int j=0; j<m; j++) {
				arrB[i][j] = Integer.parseInt(split[j]);
			}
		}
		
		int answer = solution(n, m, arrA, arrB);
		System.out.println(answer);
	}

	private static int solution(int n, int m, int[][] arrA, int[][] arrB) {
		// 첫번째 점이 다르다면 나머지가 뒤집혀야하는지 알 수 있음 
		// 3X3의 첫번째 점이므로 가장 마지막 위치는 arrA[n-3][m-3] 
		int answer = 0;
		for (int i=0; i<n-2; i++) {
			for (int j=0; j<m-2; j++) {
				if (arrA[i][j] != arrB[i][j]) {
					flip(i, j, arrA);
					answer++;
				}
			}
		}
		
		if (equals(n, m, arrA, arrB)) {
			return answer;
		}
		return -1;
	}

	private static boolean equals(int n, int m, int[][] arrA, int[][] arrB) {
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (arrA[i][j] != arrB[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static void flip(int x, int y, int[][] arrA) {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				arrA[x+i][y+j] ^= 1;
			}
		}
	}
}
