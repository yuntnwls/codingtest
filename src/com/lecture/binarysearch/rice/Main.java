package com.lecture.binarysearch.rice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long[] h = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			h[i] = Long.parseLong(st.nextToken());
		}
		
		long answer = solution(n, m, h);
		System.out.println(answer);
	}
	
	private static long solution(int n, long m, long[] h) {
		long result = 0;
		long start = 0;
		long end = (long)1e9;
		
		// 적절한 높이를 찾을 때까지 이진 탐색을 수행하여 높이를 조정 
		// "현재 이 높이로 자르면 조건을 만족 할 수 있는가?"를 확인한뒤에 조건의 만족여부에 따라 탐색 범위를 좁혀서 해결 
		int total = 0;
		while (true) {
			total = 0;
			if (start > end) {
				break;
			}
			// 떡을 자를 높이 
			long mid = (start+end)/2;
			for (int i=0; i<n; i++) {
				//잘랐을 때 떡의 양 계산
				if	(h[i] > mid) {
					total += (h[i]-mid);
				}
			}
			if (total >= m) {
				// 떡의 양이 충분한 경우 덜 자르기(오른쪽 탐색)
				result = mid;
				start = mid+1;
			} else {
				// 떡의 양이 부족한 경우 더 자르기(왼쪽 탐색)
				end = mid-1;
			}
		}
		
		return result;
	}
}
