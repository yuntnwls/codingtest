package com.study.ch09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class T1325 {

	private static int n;
	private static int m;
	
	private static List<Integer>[] computers;
	private static boolean[] isVisited;
	private static int[] answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		isVisited = new boolean[n+1];
		answer = new int[n+1];
		computers = new ArrayList[n+1];
		
		for (int i=1; i<=n; i++) {
			computers[i] = new ArrayList<>();
		}
		
		int a=0, b=0;
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			computers[a].add(b);
		}
		
//		for (int i=1; i<=n; i++) {
//			isVisited = new boolean[n+1];
//			bfs(i);
//		}
		
		for (int i=1; i<=n; i++) {
			isVisited = new boolean[n+1];
			dfs(i);
		}
		
		int max = 0;
		for (int i=1; i<=n; i++) {
			max = Math.max(max, answer[i]);
		}
		
		for (int i=1; i<=n; i++) {
			if (max == answer[i]) {
				System.out.print(i + " ");
			}
		}
	}

	private static void dfs(int i) {
		isVisited[i] = true;
		for (int next : computers[i]) {
			if (!isVisited[next]) {
				answer[next]++;
				dfs(next);
			}
		}
	}

	private static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		isVisited[i] = true;
		
		int now = -1;
		while (!queue.isEmpty()) {
			now = queue.poll();
			for (int next : computers[now]) {
				if (!isVisited[next]) {
					answer[next]++;
					isVisited[next] = true;
					queue.add(next);
				}
			}
		}
	}
}
