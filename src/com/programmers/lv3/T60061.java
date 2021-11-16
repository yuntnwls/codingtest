package com.programmers.lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://programmers.co.kr/learn/courses/30/lessons/60061?language=java
public class T60061 {

	private static int N;
	private static boolean[][] pillar, beam;
	private static final int PILLAR = 0;
	private static final int BEAM = 1;
	private static final int REMOVE = 0;
	private static final int ADD = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int size = Integer.parseInt(br.readLine());
		int[][] build_frame = new int[size][4];
		for (int i=0; i<size; i++) {
			String line = br.readLine();
			String[] split = line.split(",");
			for (int j=0; j<4; j++) {
				build_frame[i][j] = Integer.parseInt(split[j]);
			}
		}
		
		int[][] answer = solution(n, build_frame);
		for (int i=0; i<answer.length; i++) {
			for (int j=0; j<answer[i].length; j++) {
				System.out.print(answer[i][j] + ",");
			}
			System.out.println();
		}
	}

	private static int[][] solution(int n, int[][] build_frame) {
		N = n;
		
		// 구조물 위치는 0~5이므로 N+1, 양쪽 끝 부분 확인을 위해 +2 => N+3
		// 확인하는 인덱스는 1 ~ N+1 
		pillar = new boolean[N+3][N+3];
		beam = new boolean[N+3][N+3];
		
		int count = 0;
		for (int[] frame : build_frame) {
			int x = frame[0] + 1; 	//1부터 인덱스를 사용하므로 둘다 +1 
			int y = frame[1] + 1; 
			
			if (frame[2] == PILLAR) {	// 기둥 
				if (frame[3] == ADD && isValidPillar(x, y)) {	
					// 해당 위치에 기둥을 세울 수 있다면 
					pillar[x][y] = true;
					count++;
				} else if (frame[3] == REMOVE && isRemove(x, y, PILLAR)) {
					// 삭제할 수 있다면 
					pillar[x][y] = false;
					count--;
				}
			} else {	// 보 
				if (frame[3] == ADD && isValidBeam(x, y)) {
					beam[x][y] = true;
					count++;
				} else if (frame[3] == REMOVE && isRemove(x, y, BEAM)) {
					beam[x][y] = false;
					count--;
				}
			}
		}

		int [][] answer = new int[count][3];
		int index = 0;
		for (int i=1; i<=N+1; i++) {
			for (int j=1; j<=N+1; j++) {
				if (pillar[i][j])
					answer[index++] = new int[] {i-1, j-1, PILLAR};
				if (beam[i][j])
					answer[index++] = new int[] {i-1, j-1, BEAM};
			}
		}
		
		return answer;
	}

	private static boolean isRemove(int x, int y, int type) {
		boolean result = true;
		
		// 유효한지 확인하기위해 임시로 삭제 
		if (type == PILLAR)
			pillar[x][y] = false;
		else
			beam[x][y] = false;
		
		for (int i=1; i<=N+1; i++) {
			for (int j=1; j<=N+1; j++) {
				if (pillar[i][j] && !isValidBeam(i, j)) {
					result = false;
					break;
				}
				if (beam[i][j] && !isValidPillar(i, j)) {
					result = false;
					break;
				}
			}
			if (!result) {
				break;
			}
		}
		
		// 다시 원상 복귀 
		if (type == PILLAR)
			pillar[x][y] = true;
		else
			beam[x][y] = true;
		
		
		return result;
	}

	private static boolean isValidBeam(int x, int y) {
		if (pillar[x][y-1] || pillar[x+1][y-1]) {
			// 기둥이 보 아래 있거나 보가 연결되는 오른쪽에 있는 경우 
			return true;
		} else if (beam[x-1][y] && beam[x+1][y]) {
			// 양쪽 끝에 보가 연결되어있는 경우 
			return true;
		}
		return false;
	}

	private static boolean isValidPillar(int x, int y) {
		if (y == 1 || pillar[x][y-1]) {
			// 현재 바닥부분이거나 내 아랫쪽에 기둥이 있는 경우 
			return true; 
		} else if (beam[x][y] || beam[x-1][y]) {
			// 현재 바닥이 아니라면 기둥이 새워질 곳이 보 위쪽인지 확인(설치할 위치와 왼쪽)
			return true;
		}
		return false;
	}
}
