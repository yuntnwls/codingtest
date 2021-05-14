package com.backjoon.greedy.t16120;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Timeout {
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
		boolean isPpap = false;
		while(true) {
			int index = word.indexOf("PPAP");
			if (index < 0) {
				break;
			} else {
				word = word.replaceAll("PPAP", "P"); 
			}
		}
		if (word.equals("P")) {
			isPpap = true;
		}
		return isPpap;
	}
}
