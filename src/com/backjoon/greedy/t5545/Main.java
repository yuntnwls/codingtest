package com.backjoon.greedy.t5545;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 도우 가격 
		int a = Integer.parseInt(st.nextToken());
		// 토핑 가격 
		int b = Integer.parseInt(st.nextToken());
		// 도우의 열량 
		int c = Integer.parseInt(br.readLine());
		// 토핑들의 열량 
		int[] d = new int[n];
		for (int i=0; i<n; i++) {
			d[i] = Integer.parseInt(br.readLine());
		}
		
		int answer = solution(a, b, c, d);
		System.out.println(answer);
	}

	private static int solution(int a, int b, int c, int[] d) {
		int answer = 0;
		
		Arrays.sort(d);
		
		int kcal = c;
		int price = a;
		
		int temp = kcal / price;
		answer = temp;
		for (int i=d.length-1; i>=0; i--) {
			kcal += d[i];
			price += b;
			
			temp = kcal / price;
			if (answer < temp) {
				answer = temp;
			}
		}
		return answer;
	}
}
