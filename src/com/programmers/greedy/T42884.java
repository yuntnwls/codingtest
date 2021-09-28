package com.programmers.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// https://programmers.co.kr/learn/courses/30/lessons/42884?language=java
public class T42884 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] routes = new int[n][2];
		String line = "";
		for (int i=0; i<n; i++) {
			line = br.readLine();
			String[] split = line.split(",");
			for (int j=0; j<2; j++) {
				routes[i][j] = Integer.parseInt(split[j]);
			}
		}
		
		int answer = solution(routes);
		System.out.println(answer);
	}

	private static int solution(int[][] routes) {
		// 끝나는 시점으로 오름차순 정렬 
		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		int count = 0;
		int min = Integer.MIN_VALUE;
		for (int i=0; i<routes.length; i++) {
			if (min < routes[i][0])  {
				// 현재 설치할 위치보다 시작점이 더 크다면 카메라 추가
				min = routes[i][1];
				count++;
			}
		}
		
		return count;
	}
}
