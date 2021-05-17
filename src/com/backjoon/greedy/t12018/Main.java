package com.backjoon.greedy.t12018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Subject {
		int person;
		int limit;
		int[] m = null;
		
		public Subject(int p, int limit, StringTokenizer st) {
			this.person = p;
			this.limit = limit;
			m = new int[person];
			for (int i=0; i<p; i++) {
				m[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(m);
		}
		
		public int getAvalibleMileage() {
			if (person < limit) {
				return 1;
			} else {
				return m[person-limit];
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 과목 수 
		int n = Integer.parseInt(st.nextToken());
		// 주어진 마일리지 
		int myM = Integer.parseInt(st.nextToken());
		List<Subject> subjectList = new ArrayList<>();
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			subjectList.add(new Subject(Integer.parseInt(st.nextToken()), 
										Integer.parseInt(st.nextToken()) , 
										new StringTokenizer(br.readLine())));
		}
		
		int answer = solution(n, myM, subjectList);
		System.out.println(answer);
	}

	private static int solution(int n, int myM, List<Subject> subjectList) {
		int answer = 0;
		
		int[] subMinM = new int[n];
		for (int i=0; i<n; i++) {
			subMinM[i] = subjectList.get(i).getAvalibleMileage();
		}
		Arrays.sort(subMinM);
		
		int total = myM;
		for (int i=0; i<n; i++) {
			total -= subMinM[i];
			if (total >= 0) {
				answer++;
			}
		}
		return answer;
	}
}
