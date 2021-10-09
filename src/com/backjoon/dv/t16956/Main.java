package com.backjoon.dv.t16956;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16956
public class Main {
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		String[][] map = new String[R][C];
		
		for (int i=0; i<R; i++) {
			String line = br.readLine();
			String[] split = line.split("");
			map[i] = split;
		}
		
		solution(R, C, map);
	}

	private static void solution(int r, int c, String[][] map) {
		
		// 늑대와 인접한 곳에 바로 양이 있는지 확인 
		boolean isCheck = false;
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				if (map[i][j].equals("W")) {
					for (int d=0; d<dx.length; d++) {
						int newX = i + dx[d];
						int newY = j + dy[d];
						if (newX >= 0 && newX < r && newY >= 0 && newY < c) {
							if (map[newX][newY].equals("S")) {
								// 인접한 곳에 바로 양이 있는 경우 
								isCheck = true;
							} else if (map[newX][newY].equals(".")){
								// 늑대 주위에 모두 울타리를 쳐두기 
								map[newX][newY] = "D";
							}
						}
					}
				}
			}
		}
		
		if (isCheck) {
			System.out.println("0");
		} else {
			System.out.println("1");
			for (int i=0; i<r; i++) {
				for (int j=0; j<c; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
