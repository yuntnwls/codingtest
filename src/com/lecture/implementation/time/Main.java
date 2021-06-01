package com.lecture.implementation.time;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		// 완전 탐색(brute forcing) : 모든 경우의 수를 탐색 
		// 00:00:00 ~ n:59:59까지 3이 포함되는 모든 경우의 수 출력  
		// 하루는 24*60*60 = 86400 초이므로 단순히 1씩 증가시키면서 3이 하나라도 포함되어있는지 확인해도 무관하다. 
		for (int i=0; i<=n; i++) {
			for (int m=0; m<=59; m++) {
				for (int s=0; s<=59; s++) {
					if (isContains(i, m, s)) {
						answer++;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	
	private static boolean isContains(int h, int m, int s) {
		if (h%10==3 || m/10==3 || m%10==3 || s/10==3 || s%10==3) {
			return true;
		}
		return false;
	}
}
