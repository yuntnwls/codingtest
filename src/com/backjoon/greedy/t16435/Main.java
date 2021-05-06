package com.backjoon.greedy.t16435;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] h = new int[n];
		for (int i=0; i<n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		int answer = solution(n, l, h);
		System.out.println(answer);
	}

	private static int solution(int n, int l, int[] h) {
		// 낮은 높이부터 정렬 
		Arrays.sort(h);
		
		int currHeight = l;
		for (int i=0; i<n; i++) {
			if (h[i] <= currHeight) {
				currHeight++;
			} else {
				break;
			}
		}
		return currHeight;
	}
}
