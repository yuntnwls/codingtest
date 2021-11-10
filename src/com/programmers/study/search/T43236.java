package com.programmers.study.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/43236
public class T43236 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int distance = Integer.parseInt(br.readLine());
		String line = br.readLine().replaceAll(" ", "");
		String[] split = line.split(",");
		int[] rocks = new int[split.length];
		for (int i=0; i<split.length; i++) {
			rocks[i] = Integer.parseInt(split[i]);
		}
		int n = Integer.parseInt(br.readLine());
		
		int answer = solution(distance, rocks, n);
		System.out.println(answer);
	}

	private static int solution(int distance, int[] rocks, int n) {
		Arrays.sort(rocks);
		// 모든 돌들의 간격 구하기 
		int[] gap = new int[rocks.length+1];
		gap[0] = rocks[0];
		for (int i=1; i<rocks.length; i++) {
			gap[i] = rocks[i]-rocks[i-1];
		}
		gap[gap.length-1] = distance - rocks[rocks.length-1];
		
		// 이분탐색 
		int left = 1;			// 시작점 
		int right = distance;	// 도착점 
		int mid = (left+right)/2;
		int	dist, removeCnt;
		while (right > left+1) {
			removeCnt = 0;
			dist = 0;
			for (int i=0; i<gap.length; i++) {
				dist += gap[i];
				if (dist < mid) {
					removeCnt++;
				} else {
					dist = 0;
				}
			}
			if (removeCnt > n) {
				right = mid;
			} else {
				left = mid;
			}
			mid = (left+right)/2;
		}
		return mid;
	}
}
// https://velog.io/@cgw0519/알고리즘-문제풀이-프로그래머스-징검다리
