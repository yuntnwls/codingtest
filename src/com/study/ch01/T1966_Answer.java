package com.study.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class T1966_Answer {
	static class Document {
		int index;
		int importance;
		
		public Document(int index, int importance) {
			this.index = index;
			this.importance = importance;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int n = 0;
		int m = 0;
		int answer = 0;
		for (int i=0; i<t; i++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			Queue<Document> queue = new LinkedList<>();
			PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
			for (int k=0; k<n; k++) {
				int temp = Integer.parseInt(st.nextToken());
				queue.add(new Document(k, temp));
				pQueue.add(temp);
			}
			while (true) {
				Document current = queue.poll();
				// 가장 중요도가 높은경우 출력
				if (current.importance == pQueue.peek()) {
					answer++;
					pQueue.poll();
					if (current.index == m) {
						break;
					}
				} else {
					queue.add(new Document(current.index, current.importance));
				}
			}
			System.out.println(answer);
		}
	}
}
