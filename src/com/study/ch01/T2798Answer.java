package com.study.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class T2798Answer {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
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
		// 카드를 뽑는 경우의 수는 n(n-1)(n-2)/n! 로 조합의 수가 적으므로 3중 for문으로도 해결 가능 
		int answer = 0;
		int sum = 0;
		for (int i=0; i<cards.length; i++) {
			for (int j= i+1; j<cards.length; j++) {
				for (int k=j+1; k<cards.length; k++) {
					sum = cards[i] + cards[j] + cards[k];
					if (sum <= m) {
						answer = Math.max(sum, answer);
					}
				}
			}
		}
		
		return answer;
	}
}
