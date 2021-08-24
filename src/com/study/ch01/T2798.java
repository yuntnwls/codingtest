package com.study.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class T2798 {
	private static int maxSum = 0;
	private static int m = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] cards = new int[n];
		for (int i=0; i<n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cards);
		
		int answer = solution(n, m, cards);
		System.out.println(answer);
	}

	private static int solution(int n, int m, int[] cards) {
		boolean[] isVisited = new boolean[n];
	
		// 1. 백트레킹을 이용한 구현 
//		combBacktracking(cards, isVisited, 0, 3);
		
		
		// 2. 재귀를 이용한 구현 
		combRecusive(cards, isVisited, 0, 3);
		
		return maxSum;
	}

	private static void combRecusive(int[] cards, boolean[] isVisited, int depth, int r) {
		if (r == 0) {
//			printCards(cards, isVisited);
			setMaxValue(cards, isVisited);
			return;
		}
		if (depth == cards.length) {
			return;
		} else {
			isVisited[depth] = true;
			combRecusive(cards, isVisited, depth+1, r-1);
			
			isVisited[depth] = false;
			combRecusive(cards, isVisited, depth+1, r);
		}
	}

	private static void combBacktracking(int[] cards, boolean[] isVisited, int start, int r) {
		if (r == 0) {
//			printCards(cards, isVisited);
			return;
		} else {
			for (int i=start; i<cards.length; i++) {
				isVisited[i] = true;
				combBacktracking(cards, isVisited, i+1, r-1);
				isVisited[i] = false;
			}
		}
	}
	
	private static void printCards(int[] cards, boolean[] isVisited) {
		for (int i=0; i<isVisited.length; i++) {
			if (isVisited[i]) {
				System.out.print(cards[i]);
				System.out.print(" ");
			}
		}
		System.out.println();
	}
	
	private static void setMaxValue(int[] cards, boolean[] isVisited) {
		int sum = 0;
		for (int i=0; i<isVisited.length; i++) {
			if (isVisited[i]) {
				sum += cards[i];
			}
		}
		if (sum > m) {
			return;
		}
		maxSum = Math.max(maxSum, sum);
	}
}

//https://minhamina.tistory.com/38
//조합방법 참고 