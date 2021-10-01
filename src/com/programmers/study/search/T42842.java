package com.programmers.study.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://programmers.co.kr/learn/courses/30/lessons/42842
public class T42842 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int brown = Integer.parseInt(br.readLine());
		int yellow = Integer.parseInt(br.readLine());
		
		int[] answer = solution(brown, yellow);
		for (int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	private static int[] solution(int brown, int yellow) {
		int temp = brown/2 - 2;
		
		int w = 0, h = 0;
		for (int i=1; i<=temp; i++) {
			h = i;
			w = temp-i;
			if (w*h == yellow) {
				break;
			}
		}
		
		int[] answer = new int[2];
		answer[0] = w+2;
		answer[1] = h+2;
		return answer;
	}
}
