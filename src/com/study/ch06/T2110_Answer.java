package com.study.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class T2110_Answer {

	// 이진 탐색 알고리즘 사용 (재귀적, 반복적 사용가능 - 반복적으로 푸는게 유리할 수 있음)
	// 데이터의 범위가 크거나 갯수가 많은 경우 이진 탐색 고려 
	// min/max 사이의 midde를 계속 검색 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] location = new int[n];
		for (int i=0; i<n; i++) {
			location[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(location);
		
		int answer = solution(location, c);
		System.out.println(answer);
	}

	private static int solution(int[] location, int c) {
		int maxGap = location[location.length-1] - location[0];
		int minGap = maxGap;
		for (int i=1; i<location.length; i++) {
			minGap = Math.min(minGap, location[i] - location[i-1]);
		}
		
		int start = minGap;
		int end = maxGap;

		int current = 0;
		int mid = 0;
		int count = 0;
		int maxResult = 0;
		while (start <= end) {
			mid = (start+end)/2;
			count = 1;
			current = location[0];
			for (int i=1; i<location.length; i++) {
				if (location[i] >= current+mid) {
					current = location[i];
					count++;
				}
			}
			
			if (c > count) {
				// 공유기 수를 늘려야함 => 간격 좁히기 
				end = mid-1;
			} else {
				// 공유기 수를 줄여야함 => 간격 넓이기 
				maxResult = Math.max(mid, maxResult);
				start = mid + 1;
			}
		}
		return maxResult;
	}
}
