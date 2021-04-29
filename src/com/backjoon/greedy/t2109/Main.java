package com.backjoon.greedy.t2109;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Lecture implements Comparable<Lecture> {
		int day = 0;
		int pay = 0;
		
		public Lecture(int pay, int day) {
			this.day = day;
			this.pay = pay;
		}

		@Override
		public int compareTo(Lecture o) {
			if (o.pay == this.pay) {
				// 페이가 같다면 더 큰 날짜 순으로 정렬 
				return o.day - this.day;
			}
			// 높은 페이 순으로 정렬 
			return o.pay - this.pay;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		List<Lecture> lectureList = new ArrayList<>();
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			lectureList.add(new Lecture(Integer.parseInt(st.nextToken()), 
									    Integer.parseInt(st.nextToken())));
		}
		
		int answer = solution(n, lectureList);
		System.out.println(answer);
	}
	
	private static int solution(int n, List<Lecture> lectureList) {
		if (n == 0) {
			return 0;
		}
		
		// 높은 페이순으로 정렬 
		Collections.sort(lectureList);
		
		// 각 날짜마다 받을 수 있는 페이를 확인할 수 있는 배열 
		int[] pays = new int[10001];
		int answer = 0;
		Lecture currLec = null;
		for (int i=0; i<n; i++) {
			currLec = lectureList.get(i);
			for (int j=currLec.day; j>=1; j--) { 
				if (pays[j] == 0) {
					// 강연을 하지 않는 날을 찾아 넣음 
					pays[j] = currLec.pay;
					answer += currLec.pay;
					break;
				}
			}
		}
		return answer;
	}
}
