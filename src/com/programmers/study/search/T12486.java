package com.programmers.study.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/43238?language=java
public class T12486 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String line = br.readLine().replaceAll(" ", "");
		String[] split = line.split(",");
		int[] times = new int[split.length];
		for (int i=0; i<split.length; i++) {
			times[i] = Integer.parseInt(split[i]);
		}
		
		long answer = solution(n, times);
		System.out.println(answer);
	}

	private static long solution(int n, int[] times) {
		Arrays.sort(times);
		
		long left = 1; // 총 시간을 찾기위한 가장 작은 값 
		// 반드시 형변환이 필요!!!
		long right = (long)n*times[times.length-1]; // 총 시간을 찾기 위한 가장 큰 값 
		long mid;
		long count; // 심사위원당 맡을 수 있는 인원 수 
		long answer = right;
		
		while (left <= right) {
			mid = (left+right)/2;
			
			count = 0;
			// 심사위원당 맡을 수 있는 인원을 모두 더하기 
			for (int i=0; i<times.length; i++) {
				count += (mid/times[i]);
				if (count >= n) 
					break;
			}
			
			if (n <= count) {
				// 맡을수 있는 인원수가 주어진 인원수보다 많다면 더 작은 값 가능 
				answer = Math.min(answer, mid);
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		
		return answer;
	}
}
