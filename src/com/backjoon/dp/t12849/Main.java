package com.backjoon.dp.t12849;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://www.acmicpc.net/problem/12849
public class Main {
	
	// 0분에 어떤 지점에 도착할 수 있는 상태
	// 0: 정보과학관 
	// 1: 전산관 
	// 2: 미래관 
	// 3: 신앙관 
	// 4: 한경관
	// 5: 진리관
	// 6: 학생회관
	// 7: 형남공학관 
	private static long[][] dp = new long[2][8];
	private static long mod = 1000000007;
	private static int[][] link;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int D = Integer.parseInt(br.readLine());
		
		long answer = solution(D);
		System.out.println(answer);
	}

	private static long solution(int d) {
		link = new int[][] {
			{1, 2},
			{0, 2, 3},
			{0, 1, 3, 4},
			{1, 2, 4, 5},
			{2, 3, 5, 7},
			{3, 4, 6},
			{5, 7},
			{4, 6}
		};
		
		dp[0][0] = 1;
		for (int i=0; i<d; i++) {
			// 1분씩 지나는 상황 
			next();
		}
		return dp[0][0];
	}
	
	// 1분 후의 상태를 구하는 함수 
	private static void next() {
		for (int i=0; i<8; i++) {
			dp[1][i] = 0;
			for (int j=0; j<link[i].length; j++) {
				dp[1][i] = ((dp[1][i]%mod) + (dp[0][link[i][j]]%mod))%mod;
			}
		}
		for (int i=0; i<8; i++) {
			dp[0][i] = dp[1][i];
		}
	}
}
