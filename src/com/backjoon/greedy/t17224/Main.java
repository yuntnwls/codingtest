package com.backjoon.greedy.t17224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] level = new int [n][2];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			level[i][0] = Integer.parseInt(st.nextToken());
			level[i][1] = Integer.parseInt(st.nextToken());
		}
		int answer = solution(n, l, k, level);
		System.out.println(answer);
	}

	private static int solution(int n, int l, int k, int[][] level) {
		int answer = 0;
		
		for (int i=0; i<n; i++) {
			if (i >= k ) {
				break;
			}
			
			if (level[i][1] <= l) {
				answer += 140;
			} else if (level[i][0] <= l) {
				answer += 100;
			}
		}
		return answer;
	}
}
