package com.study.ch11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class T2212 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		if (n <= k) {
			System.out.println("0");
			return;
		}
		
		int[] senors = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			senors[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(senors);
		
		// 각 센서의 간격 구하기 
		int[] interval = new int[n-1];
		for (int i=0; i<n-1; i++) {
			interval[i] = senors[i+1] - senors[i];
		}
		
		// 간격 중 가장 큰 간격으로 나누기
		// 수신 가능 영역 단위로 그룹을 나누기 
		Arrays.sort(interval);
		for (int i=0; i<k-1; i++) {
			interval[n-i-2] = 0;
		}
		
		// 간격의 총 합이 수긴 가능 영역 거리의 합 
		int sum = 0;
		for (int i=0; i<n-1; i++) {
			sum += interval[i];
		}
		
		System.out.println(sum);
	}
}
