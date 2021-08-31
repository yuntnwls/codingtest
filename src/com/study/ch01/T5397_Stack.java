package com.study.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class T5397_Stack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String answer = "";
		for (int i=0; i<n; i++) {
			answer = solution(br.readLine());
			System.out.println(answer);
		}
	}
	
	private static String solution(String keyLocker) {
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();
		
		char curr;
		for (int i=0; i<keyLocker.length(); i++) {
			curr = keyLocker.charAt(i);
			if (curr == '-') {
				// 왼쪽에서 삭제 
				if (!left.isEmpty()) {
					left.pop();
				}
			} else if (curr == '<') {
				// 왼쪽에서 오른쪽으로 이동
				if (!left.isEmpty()) {
					right.push(left.pop());
				}
			} else if (curr == '>') {
				// 오른쪽에서 왼쪽으로 이동 
				if (!right.isEmpty()) {
					left.push(right.pop());
				}
			} else {
				// 왼쪽에 추가 
				left.push(curr);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!right.isEmpty()) {
			left.push(right.pop());
		}
		while (!left.isEmpty()) {
			sb.append(left.pop());
		}
		return sb.reverse().toString();
	}
}
