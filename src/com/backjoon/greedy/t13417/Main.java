package com.backjoon.greedy.t13417;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			String cardStr = br.readLine();
			cardStr = cardStr.replaceAll(" ", "");
			char[] cards = cardStr.toCharArray();
			String answer = solution(n, cards);
			System.out.println(answer);
		}
	}

	private static String solution(int n, char[] cards) {
		String answer = Character.toString(cards[0]);
		int frontIndex = 0;
		
		for (int i=1; i<cards.length; i++) {
			if (cards[frontIndex] < cards[i]) {
				answer = answer + Character.toString(cards[i]);
			} else {
				answer = Character.toString(cards[i]) + answer;
				frontIndex = i;
			}
		}
		return answer;
	}
}
