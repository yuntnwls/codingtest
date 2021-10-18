package com.backjoon.greedy.t2014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2014
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		long[] numArr = new long[k];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<k; i++) {
			numArr[i] = Long.parseLong(st.nextToken());
		}
		
		long answer = solution(k, n, numArr);
		System.out.println(answer);
	}

	private static long solution(int k, int n, long[] numArr) {
		PriorityQueue<Long> pq = new PriorityQueue<>();
		// 처음엔 모든 수를 큐에 넣어주기 
		for (int i=0; i<k; i++) {
			pq.offer(numArr[i]);
		}
		
		long answer = 0;
		// 우선순위 큐에서 꺼낸 값을 처음에 입력받은 소수 배열의 값들과 곱해서 다시 우선순위 큐에 넣어주기 
		while (n > 0) {
			answer  = pq.poll();
			
			for (int i=0; i<k; i++) {
				// 문제의 정답이 2^31보다 작음 
				if ((answer*numArr[i]) >= ((long)2<<30)) {
					break;
				}
				
				pq.offer(answer * numArr[i]);
				
				// 중복된 값을 배제하기 위해 
				// 우선순위 큐에서 꺼낸 값을 입력받은 소수들과 나누어 보면 나누어 떨어지는 수까지만 우선순위 큐에 넣으면 됨 
				if (answer % numArr[i] == 0) {
					break;
				}
			}
			n--;
		}
		
		return answer;
	}
}
