package com.programmers.study.check;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class T1467 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String line = br.readLine().replaceAll(" ", "");
		String[] split = line.split(",");
		
		int[] works = new int[split.length];
		for (int i=0; i<split.length; i++) {
			works[i] = Integer.parseInt(split[i]);
		}
		
		long answer = solution(n, works);
		System.out.println(answer);
	}

	private static long solution(int n, int[] works) {
		PriorityQueue<Integer> nightWorks = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int time : works){
			nightWorks.add(time);
		}
		
		for (int i=0; i<n; i++) {
			int max = nightWorks.poll();
			if (max <= 0)
				break;
			nightWorks.add(max-1);
		}
		
		long answer = 0;
		while (!nightWorks.isEmpty()) {
			answer += Math.pow(nightWorks.poll(), 2);
		}
		
		return answer;
	}
}
