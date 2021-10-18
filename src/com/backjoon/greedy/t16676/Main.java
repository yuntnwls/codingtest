package com.backjoon.greedy.t16676;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/16676
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int data = Integer.parseInt(input);

		if (data <= 10) {
			System.out.println(1);
			return;
		}
		
		// 0 1 2 3 4 5 6 7 8 9 (< 11) 	=> 1팩일 때는 11 전까지 표현 가능 
		// 0 1 2 3 4 5 6 7 8 9 (< 111) 	=> 2팩일 때는 111 전까지 표현 가능 
		// 0 1 2 3 4 5 6 7 8 9 (< 1111) => 3팩일 떄는 1111 전까지 표현 가능 
		// 11이상 111미만이라면 2팩 필요 
		int answer = 2;
		int temp = 11;
		while (true) {
			if (data >= temp && data <= temp*10) {
				break;
			}
			temp = temp*10+1;
			answer++;
		}
		
		System.out.println(answer);
	}
}
