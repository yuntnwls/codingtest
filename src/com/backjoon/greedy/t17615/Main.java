package com.backjoon.greedy.t17615;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] balls = br.readLine().split("");
		
		int answer = solution(n, balls);
		System.out.println(answer);
	}

	private static int solution(int n, String[] balls) {
		int answer = n;
		
		int cntR = 0;
		int cntB = 0;
		for (int i=0; i<n; i++) {
			if (balls[i].equals("R")) {
				cntR++;
			} else {
				cntB++;
			}
		}
		
		// 왼쪽 or 오른쪽에 몰려있는 R이나 B의 개수 
		int count = 0;
		// R을 오른쪽으로 모두 이동 
		for (int i=n-1; i>=0; i--) {
			if (balls[i].equals("R")) {
				count++;
			} else {
				break;
			}
		}
		answer = Math.min(answer, cntR-count);
		count = 0;
		// R을 왼쪽으로 모두 이동 
		for (int i=0; i<=n-1; i++) {
			if (balls[i].equals("R")) {
				count++;
			} else {
				break;
			}
		}
		answer = Math.min(answer, cntR-count);
		count = 0;
		// B을 오른쪽으로 모두 이동 
		for (int i=n-1; i>=0; i--) {
			if (balls[i].equals("B")) {
				count++;
			} else {
				break;
			}
		}
		answer = Math.min(answer, cntB-count);
		count = 0;
		// B을 왼쪽으로 모두 이동 
		for (int i=0; i<=n-1; i++) {
			if (balls[i].equals("B")) {
				count++;
			} else {
				break;
			}
		}
		answer = Math.min(answer, cntB-count);
		
		return answer;
	}
}
