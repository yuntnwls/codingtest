package com.backjoon.greedy.t1052;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int answer = solution(n, k);
		System.out.println(answer);
	}

	private static int solution(int n, int k) {
		if (n <= k) {
			return 0;
		}
		
		int answer = 0;
		int moveCnt = 0;
		while (true) {
			moveCnt = addWater(n);
			if (moveCnt <= k) {
				break;
			}
			answer++;
			n++;
		}
		return answer;
	}
	
	private static int addWater(int w) {
		int cnt = 0;
		while (w>0) {
			if (w % 2 == 1) {
				cnt++;
			}
			w /= 2;
		}
		return cnt;
	}
}
