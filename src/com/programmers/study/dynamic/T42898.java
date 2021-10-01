package com.programmers.study.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/42898?language=java
public class T42898 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		int[][] puddles = new int[p][2];
		for (int i=0; i<p; i++) {
			String line = br.readLine().replaceAll(" ", "");
			String[] split = line.split(",");
			puddles[i][0] = Integer.parseInt(split[0]);
			puddles[i][1] = Integer.parseInt(split[1]);
		}
		
		int answer = solution(m, n, puddles);
		System.out.println(answer);
	}
	
	private static int solution(int m, int n, int[][] puddles) {
		int mod = 1000000007;
		
		int[][] map = new int[n+1][m+1];
		for (int i=0; i<puddles.length; i++) {
			map[puddles[i][1]][puddles[i][0]] = -1;
		}
		
		map[1][1] = 1;
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				if (map[i][j] == -1) {
					continue;
				}
				if (map[i-1][j] > 0) {
					// 왼쪽에 웅덩이가 없는 경우 
					map[i][j] += (map[i-1][j] % mod);
				}
				if (map[i][j-1] > 0) {
					// 윗쪽에 웅덩이가 없는 경우 
					map[i][j] += (map[i][j-1] % mod);
				}
			}
		}
		
		return map[n][m]%mod;
	}
	
}
