package com.backjoon.greedy.t17224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainPass {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] level = new int [n][2];
		int hardCnt = 0;
		int easyCnt = 0;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			level[i][0] = Integer.parseInt(st.nextToken());
			level[i][1] = Integer.parseInt(st.nextToken());
			if (level[i][1] <= l) {
				hardCnt++;
			} else if (level[i][0] <=l) {
				easyCnt++;
			}
		}
		int answer = solution(k, hardCnt, easyCnt);
		System.out.println(answer);
	}

	private static int solution(int k, int hardCnt, int easyCnt) {
		int answer = 0;
		// 문제를 순서대로 풀지 않아도 됨 
		// 먼저 가능한 어려운 문제부터 풀기 
		if (hardCnt > k) {
			answer = k*140;
		} else {
			answer = hardCnt*140;
			k-=hardCnt;
			if (easyCnt > k) {
				answer += k*100;
			} else {
				answer += easyCnt * 100;
			}
		}
		return answer;
	}
}
