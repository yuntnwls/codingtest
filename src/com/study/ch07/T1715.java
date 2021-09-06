package com.study.ch07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class T1715 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		for (int i=0; i<n; i++) {
			pQueue.add(Integer.parseInt(br.readLine()));
		}
	
		int answer = solution(pQueue);
		System.out.println(answer);
	}

	private static int solution(PriorityQueue<Integer> pQueue) {
		int answer = 0;
		int sum = 0;
		while (pQueue.size() > 1) {
			sum = pQueue.poll();
			sum += pQueue.poll();
			answer += sum;
			pQueue.add(sum);
		}
		return answer;
	}
}
