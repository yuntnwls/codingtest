package com.study.ch11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class T1781 {
	
	static class Exam implements Comparable<Exam> {
		int no;
		int deadline;
		int cup;
		public Exam(int no, int deadline, int cup) {
			this.no = no;
			this.deadline = deadline;
			this.cup = cup;
		}
		@Override
		public int compareTo(Exam o) {
			return this.deadline - o.deadline;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		List<Exam> examList = new ArrayList<>();
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			examList.add(new Exam(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		int answer = solution(examList);
		System.out.println(answer);
	}

	private static int solution(List<Exam> examList) {
		// 데드라인 기준으로 오름차순 정렬 
		Collections.sort(examList);
		
		// 현재까지 푼 문제의 컵라면 수를 담을 큐 
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i=0; i<examList.size(); i++) {
			Exam exam = examList.get(i);
			queue.add(exam.cup);
			// 현재까지 푼 문제 수가 데드라인보다 큰 경우 데드라인을 초과한 문제이므로 삭제 
			if (exam.deadline < queue.size()) {
				queue.poll();
			}
		}
		
		int sum = 0;
		while (!queue.isEmpty()) {
			sum += queue.poll();
		}
		
		return sum;
	}
}
