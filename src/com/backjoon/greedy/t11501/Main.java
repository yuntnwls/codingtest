package com.backjoon.greedy.t11501;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int n = 0;
		long answer = 0;
		for (int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for (int j=0; j<n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			answer = solution(n, arr);
			System.out.println(answer);
		}
	}

	private static long solution(int n, int[] arr) {
		long answer = 0;
		int maxIndex = n-1;
		// 뒤에서부터 확인 
		for (int i=n-2; i>-1; i--) {
			if (arr[i] > arr[maxIndex]) {
				// 앞쪽이 더 크면 살 필요가 없으므로 최대값 이동 
				maxIndex = i;
			} else {
				// 최대값보다 작은 값이 앞에 있다면 사고 파는 주식이므로 이익에 추가 
				answer += (arr[maxIndex] - arr[i]);
			}
		}
		return answer;
	}
}
//https://kangwlgns.tistory.com/18