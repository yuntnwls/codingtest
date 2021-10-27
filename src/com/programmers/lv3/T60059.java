package com.programmers.lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://programmers.co.kr/learn/courses/30/lessons/60059?language=java
public class T60059 {
	private static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] key = new int[m][m];
		int[][] lock = new int[n][n];
		for (int i=0; i<m; i++) {
			String line = br.readLine().replaceAll(" ", "");
			String[] split = line.split(",");
			for (int j=0; j<m; j++) {
				key[i][j] = Integer.parseInt(split[j]);
			}
		}
		for (int i=0; i<n; i++) {
			String line = br.readLine().replaceAll(" ", "");
			String[] split = line.split(",");
			for (int j=0; j<n; j++) {
				lock[i][j] = Integer.parseInt(split[j]);
			}
		}
		
		boolean answer = solution(key, lock);
		System.out.println(answer);
	}

	private static boolean solution(int[][] key, int[][] lock) {
		n = lock.length;
		
		// key를 매칭할 모든 범위만큼 lock 패딩이 추가된 배열 생성 
		int paddingLen = lock.length + key.length*2 - 2;
		int[][] lockPadding = new int[paddingLen][paddingLen];
		for (int i=0; i<lock.length; i++) {
			for (int j=0; j<lock.length; j++) {
				lockPadding[i+key.length-1][j+key.length-1] = lock[i][j];
			}
		}
		
		// 0 90 180 270 회전 후 체크 
		// 회전 안한 경우 
		if (checkUnlock(key, lockPadding)) {
			return true;
		}
		
		// 90도 회전 
		key = rotate90(key);
		if (checkUnlock(key, lockPadding)) {
			return true;
		}

		// 180도 회전 
		key = rotate90(key);
		if (checkUnlock(key, lockPadding)) {
			return true;
		}
		
		// 270도 회전 
		key = rotate90(key);
		if (checkUnlock(key, lockPadding)) {
			return true;
		}
		
		return false;
	}
	
	private static boolean unlock(int[][] key, int[][] lock, int x, int y) {
		int checkIdx = key.length-1;
		for (int i=checkIdx; i<checkIdx+n; i++) {
			for (int j=checkIdx; j<checkIdx+n; j++) {
				int keyX = i-x;
				int keyY = j-y;
				if (keyX >= 0 && keyX < key.length && keyY >= 0 && keyY < key.length) {
					if (key[keyX][keyY] == lock[i][j]) {
						return false;
					}
				} else {
					if (lock[i][j] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	private static boolean checkUnlock(int[][] key, int[][] lock) {
		int endIdx = lock.length - key.length;
		for (int i=0; i<=endIdx; i++) {
			for (int j=0; j<=endIdx; j++) {
				if (unlock(key, lock, i, j)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static int[][] rotate90(int[][] key) {
		int n = key.length;
		int[][] result = new int[n][n];
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				result[i][j] = key[n-1-j][i];
			}
		}
		
		return result;
	}
}
