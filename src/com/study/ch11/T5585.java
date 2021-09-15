package com.study.ch11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class T5585 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int charge = 1000-n;
		int answer = 0;
		
		int[] coin = {500, 100, 50, 10, 5, 1};
		for (int i=0; i<coin.length; i++) {
			answer += charge / coin[i];
			charge = charge % coin[i];
		}
		
		System.out.println(answer);
	}
}
