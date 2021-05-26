package com.backjoon.greedy.t17521;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long w = Long.parseLong(st.nextToken());
		int[] price = new int[n+1];
		for (int i=0; i<n; i++) {
			price[i] = Integer.parseInt(br.readLine());
		}
		
		long answer = solution(n, w, price);
		System.out.println(answer);
	}

	private static long solution(int n, long w, int[] price) {
		boolean isUp = false;
		long currentW = w;
		long coin = 0;
		for (int i=0; i<n-1; i++) {
			if (price[i] < price[i+1]) {
				// 다음날 오르는 경우
				if (!isUp) {
					coin += (currentW/price[i]);
					currentW %= price[i];
					isUp = true;
				}
			} else if (price[i] > price[i+1]) {
				// 다음날 떨어지는 경우
				if (isUp) {
					currentW += (price[i]*coin);
					coin = 0;
					isUp = false;
				}
			}
		}
		currentW += (price[n-1]*coin);
		
		return currentW;
	}
}
