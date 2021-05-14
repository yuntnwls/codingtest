package com.backjoon.greedy.t16120;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		boolean isPpap = solution(word);
		if (isPpap) {
			System.out.println("PPAP");
		} else {
			System.out.println("NP");
		}
	}

	private static boolean solution(String word) {
		boolean isPpap = true;
		Stack<Character> stack = new Stack<>();
		
		for (int i=0; i<word.length(); i++) {
			char temp = word.charAt(i);
			if (temp == 'P') {
				stack.push(temp);
			} else {
				// A가 오는 경우 
				// 앞에 P가 2개오고 뒤에 P가 하나 더 있는 경우 
				if (stack.size() >= 2 && (i < (word.length()-1) && word.charAt(i+1) == 'P')) {
					stack.pop();
					stack.pop();
				} else {
					isPpap = false;
					break;
				}
			}
		}
		
		// 마지막에 P만 남아있다면 PPAP문자열 
		if (stack.size() != 1) {
			isPpap = false;
		}
		return isPpap;
	}
}
