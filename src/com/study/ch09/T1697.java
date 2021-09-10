package com.study.ch09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T1697 {
	
	private static final int MAX_VALUE = 100000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		boolean[] isVisited = new boolean[100001];
		int answer = bfs(n, k, isVisited);		
		System.out.println(answer);
	}

	private static int bfs(int n, int k, boolean[] isVisited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		// 해당 위치에 도달하는데 걸리는 시간 배열 
		int[] answer = new int[100001];
		queue.add(n);
		
		int now = -1;
		int next = -1;
		while (!queue.isEmpty()) {
			now = queue.poll();
			if (now == k) {
				return answer[now];
			}
			
			next = now-1;
			if (isMove(next, answer)) {
				queue.add(next);
				answer[next] = answer[now]+1;
			}
			next = now+1;
			if (isMove(next, answer)) {
				queue.add(next);
				answer[next] = answer[now]+1;
			}
			next = now*2;
			if (isMove(next, answer)) {
				queue.add(next);
				answer[next] = answer[now]+1;
			}
		}
		return -1;
	}
	
	private static boolean isMove(int move, int[] answer) {
		if (move >=0 && move <= MAX_VALUE && answer[move] == 0) {
			return true;
		}
		return false;
	}
}
