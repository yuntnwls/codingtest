package com.lecture.binarysearch.count;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	private static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		// 정렬된 배열 형태로 입력됨
		for (int i=0; i<n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		// 정렬된 배열이므로 이진 탐색을 수행 
		// 이진 탐색을 두번 수행해서 첫번쨰 x의 위치와 마지막 x의 위치를 찾아서 답을 구하기 
		int answer = solution(n, x);
		System.out.println(answer);
	}

	private static int solution(int n, int x) {
		int answer = 0;
		
		int start = getLowerIndex(x);
		int end = getUpperIndex(x);
		answer = end-start;
		
		if (answer == 0) {
			answer = -1;
		}
		return answer;
	}
	
	private static int getLowerIndex(int x) {
		int start = 0;
		int end = list.size()-1;
		
		while (start < end) {
			int mid = (start + end)/2;
			if (list.get(mid) >= x) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		return end;
	}
	
	private static int getUpperIndex(int x) {
		int start = 0;
		int end = list.size()-1;
		
		while (start < end) {
			int mid = (start + end)/2;
			if (list.get(mid) > x) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		return end;
	}

}
