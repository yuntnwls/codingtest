package com.programmers.study.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://programmers.co.kr/learn/courses/30/lessons/42895?language=java
public class T42895 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int number = Integer.parseInt(br.readLine());
		
		int answer = solution(N, number);
		System.out.println(answer);
	}

	private static int n;
	private static int number;
	private static int answer = Integer.MAX_VALUE;
	
	private static int solution(int N, int number) {
		if (N == number) {
			return 1;
		}
		
		dfs(0, 0);
		
		if (answer != Integer.MAX_VALUE) {
			return answer;
		}
		return -1;
	}

	private static void dfs(int count, int pre) {
		if (count > 8) {	// 최대 사용횟수가 8번이므로 8번이 넘으면 -1반환 
			answer = -1;
			return;
		}
		
		if (pre == number) {
			answer = Math.min(answer, count);
			return;
		}
		
		int tempN = n;
		for (int i=0; i<8-count; i++) {
			int newCount = count + i + 1;
			dfs(newCount, pre + tempN);
			dfs(newCount, pre - tempN);
			dfs(newCount, pre / tempN);
			dfs(newCount, pre * tempN);
			
			// N을 NN으로 만들어주기 
			tempN = tempN  * 10 + n;
		}
	}
}
