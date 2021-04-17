package com.backjoon.greedy.t9009;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		// 미리 리스트를 만들어 둔다.
		// f45 가 n의 최대값을 넘지않는 마지막 수이므로 45까지 
		int[] data = new int[46];
		data[0] = 0;
		data[1] = 1;
		for (int i=2; i<=45; i++) {
			data[i] = data[i-1] + data[i-2];
		}
		
		for (int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			solution(n, data);
		}
	}

	private static void solution(int n, int[] data) {
		Stack<Integer> stack = new Stack<Integer>(); 
		while (true) {
			// 현재 n보다 작거나 같은 값 찾기 
			for (int i=data.length-1; i>=0; i--) {
				if (data[i] <= n) {
					stack.push(data[i]);
					n -= data[i];
					break;
				}
			}
			if (n == 0) {
				break;
			}
		}
		
		// 출력 
		String answer = "";
		while (!stack.empty()) {
			answer += Integer.toString(stack.pop());
			if (stack.size() > 0) {
				answer += " ";
			}
		}
		System.out.println(answer);
	}
}
