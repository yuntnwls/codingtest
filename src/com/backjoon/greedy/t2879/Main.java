package com.backjoon.greedy.t2879;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] curr = new int[n];
		int[] diff = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			curr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			int tab = Integer.parseInt(st.nextToken());
			diff[i] = curr[i] - tab;
		}
		
		int answer = solution(n, diff);
		System.out.println(answer);
	}


	private static int solution(int n, int[] diff) {
		int answer = 0;
		
		int pre = diff[0];
		if (n == 1) {
			return Math.abs(diff[0]);
		}
		for (int i=1; i<n; i++) {
			if (diff[i] >= 0) {
				if (pre < 0) {
					// 부호가 달라 그룹으로 묶지 못하는 경우 
					answer += Math.abs(pre);
				} else if (pre >= diff[i]) {
					// 현재가 이전 탭의 수보다 더 많이 빼야하는 경우 
					answer += (Math.abs(pre) - Math.abs(diff[i]));
				}
			} else {
				if (pre > 0) {
					// 부호가 달라 그룹으로 묶지 못하는 경우 
					answer += Math.abs(pre);
				} else if (pre <= diff[i]) {
					// 현재가 이전 탭의 수보다 더 많이 더해야하는 경우 
					answer += (Math.abs(pre) - Math.abs(diff[i]));
				}
			}
			pre = diff[i];
		}
		answer += Math.abs(pre);
		
		return answer;
	}
}
