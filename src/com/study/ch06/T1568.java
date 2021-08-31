package com.study.ch06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class T1568 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int birdCount = n;
		int singNum = 1;
		int answer = 0;
		while (birdCount > 0) {
			if (singNum > birdCount) {
				singNum = 1;
			}
			birdCount -= singNum;
			answer++;
			singNum++;
		}
		System.out.println(answer);
	}
}
