package com.backjoon.greedy.t13413;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			String initStr = br.readLine();
			String destStrt = br.readLine();
			solution(n, initStr, destStrt);
		}
	}

	private static void solution(int n, String initStr, String destStr) {
		String[] init = initStr.split("");
		String[] dest = destStr.split("");
		
		int answer = 0;
		// 바꿀 인덱스 저장 
		int index = 0;
		String[] change = new String[n];
		for (int i=0; i<n; i++) {
			if (!init[i].equals(dest[i])) {
				change[index++] = init[i]; 
			}
		}
		
		int wCount = 0;
		int bCount = 0;
		for (int i=0; i<index; i++) {
			if (change[i].equals("W")) {
				wCount++;
			} else {
				bCount++;
			}
		}
		// 뒤집을 갯수 
		answer += Math.abs(wCount-bCount);
		// 서로 바꿀 개수 
		if (wCount > bCount) {
			answer += bCount;
		} else {
			answer += wCount;
		}
		
		System.out.println(answer);
	}
}
