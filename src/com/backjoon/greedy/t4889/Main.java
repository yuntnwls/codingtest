package com.backjoon.greedy.t4889;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static final String OPEN_STR = "{";
	public static final String CLOSE_STR = "}";
	public static final String END_STR = "-";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = null;
		int index = 1;
		while((temp = br.readLine()) != null) {
			String[] split = temp.split("");
			int answer =  solution(split);
			if (answer >= 0) {
				System.out.println(String.format("%d. %d", index++, answer));
			}
		}
	}

	private static int solution(String[] split) {
		int answer = 0;
		int openCnt = 0;
		for (int i=0; i<split.length; i++) {
			if (split[i].equals(END_STR)) {
				answer = -1;
				break;
			} else if (split[i].equals(OPEN_STR)) {
				openCnt++;
			} else if (split[i].equals(CLOSE_STR)) {
				openCnt--;
			}
			if (openCnt < 0) {
				// close->open으로 변경 
				answer++;
				openCnt += 2;
			}
		}
		if (openCnt > 0) {
			answer += openCnt/2;
		}
		
		return answer;
	}
}
