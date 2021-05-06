package com.backjoon.greedy.t18310;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] point = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			point[i] = Integer.parseInt(st.nextToken());
		}
		int answer = solution(n, point);
		System.out.println(answer);
	}

	private static int solution(int n, int[] point) {
		int answer = 0;
	
		Arrays.sort(point);
		
		answer = point[(n-1)/2];
		
		return answer;
	}
}
