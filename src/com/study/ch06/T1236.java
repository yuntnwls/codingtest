package com.study.ch06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T1236 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String line = null;
		int[][] map = new int[n][m];
		for (int i=0; i<n; i++) {
			line = br.readLine();
			String[] split = line.split("");
			for (int j=0; j<split.length; j++) {
				if (split[j].equals("X")) {
					map[i][j] = 1;
				}
			}
		}
		
		int answer = solution(map);
		System.out.println(answer);
	}

	private static int solution(int[][] map) {
		boolean[] isColVisited = new boolean[map.length];
		boolean[] isRowVisited = new boolean[map[0].length];		
		
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[i].length; j++) {
				if (map[i][j] == 1) {
					isColVisited[i] = true;
					isRowVisited[j] = true;
				}
			}
		}
		
		int emptyColCount = 0;
		int emptyRowCount = 0;
		for (int i=0; i<isColVisited.length; i++) {
			if (isColVisited[i] == false) {

				
				
				emptyRowCount++;
			}
		}
		return Math.max(emptyColCount, emptyRowCount);
	}
}
