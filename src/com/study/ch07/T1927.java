package com.study.ch07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class T1927 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		
		int data = -1;
		int output = -1;
		for (int i=0; i<n; i++) {
			data = Integer.parseInt(br.readLine());
			if (data == 0) {
				if (pQueue.isEmpty()) {
					System.out.println(0);
				} else {
					output = pQueue.poll();
					System.out.println(output);
				}
			} else {
				pQueue.add(data);
			}
			
		}
	}
}
