package com.lecture.implementation.night;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String night = br.readLine();
		int x = Integer.parseInt(night.substring(1));
		int y = night.charAt(0) - 'a' + 1;
		
		int answer = 0;
		// 나이트가 이동할 수 있는 8가지 방향 정의 
		int[] dx = {-1, 1, -2, -2, -1, 1, 2, 2};
		int[] dy = {2, 2, -1, 1, -2, -2, -1, 1};
		for (int i=0; i<dx.length; i++) {
			int currX = x+dx[i];
			int currY = y+dy[i];
			if (isMove(currX, currY)) {
				answer++;
			}
		}
		System.out.println(answer);
		
	}
	
	private static boolean isMove(int x, int y) {
		// 이동이 가능한지 확인 
		if (x >= 1 && x <= 8 && y >= 1 && y <= 8) {
			return true;
		}
		return false;
	}
}
