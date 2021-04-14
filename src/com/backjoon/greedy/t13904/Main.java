package com.backjoon.greedy.t13904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][]	homeworks = new int[n][2];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			homeworks[i][0] = Integer.parseInt(st.nextToken());
			homeworks[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int answer = solution(n, homeworks);
		System.out.println(answer);
	}

	private static int solution(int n, int[][] homeworks) {
		int answer = 0;
		// 점수 기준으로 정렬 
		Arrays.sort(homeworks, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])	// 점수가 같다면 마감일이 가까운 순으로 정렬 
					return o1[0] - o2[0];
				else
					return o2[1] - o1[1];
			}
		});
		
		// 그 날 해야하는 숙제의 점수 배열 
		int[] todo = new int[1000];
		for (int i=0; i<n; i++) {
			int date = homeworks[i][0];
			int score = homeworks[i][1];
			// 마감일 전날부터 0까지 숙제를 하지 않는 곳을 찾아 점수 추가 
			for (int j=date-1; j>=0; j--) {
				if (todo[j] == 0) {
					todo[j] = score;
					answer += score;
					break;
				}
			}
		}
		return answer;
	}
}
