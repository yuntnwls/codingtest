package com.backjoon.greedy.t11509;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] h = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = solution(n, h);
		System.out.println(answer);
	}

	private static int solution(int n, int[] h) {
		int answer = 0;
		// 풍선의 위치에 화살이 있는지 확인하기위한 배열 
		int[] arrow = new int[n+1];
		int currHeight = 0;
		for (int i=0; i<n; i++) {
			currHeight = h[i];
			if (arrow[currHeight] == 0) {
				// 현재위치에 화살이 없다면 
				answer++;
				arrow[currHeight-1]++;
			} else if (arrow[currHeight] > 0){
				arrow[currHeight]--;
				arrow[currHeight-1]++;
			}
		}
		return answer;
	}
}

// https://javaiyagi.tistory.com/599
// https://jyukki97.github.io/2020-04-03-11509/