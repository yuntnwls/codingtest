package com.backjoon.greedy.t13164;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Height implements Comparable<Height> {
		int front;
		int back;
		int gap;
		
		public Height(int index, int gap) {
			this.front = index-1;
			this.back = index;
			this.gap = gap;
		}
		
		@Override
		public int compareTo(Height o) {
			return o.gap - this.gap;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] h = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = solution(n, k, h);
		System.out.println(answer);
	}

	private static int solution(int n, int k, int[] h) {
		int answer = 0;
		
		List<Height> gapList = new ArrayList<>();
		for (int i=1; i<n; i++) {
			gapList.add(new Height(i, h[i]-h[i-1]));
		}
		// 인접한 사람과의 키차이를 내림차순으로 정렬 
		Collections.sort(gapList);
		
		int[] border = new int[k];
		for (int i=0; i<k-1; i++) {
			// 구간을 나눌 지점 저장
			border[i] = gapList.get(i).back;
		}
		// 마지막 인덱스 추가 
		border[k-1] = n;
		// 오름차순으로 정렬 
		Arrays.sort(border);
		
		int temp = 0;
		for (int i=0; i<k; i++) {
			answer += (h[border[i]-1]- h[temp]);
			temp = border[i];
		}
		return answer;
	}
}

//https://kyu9341.github.io/algorithm/2020/03/14/algorithm13164/