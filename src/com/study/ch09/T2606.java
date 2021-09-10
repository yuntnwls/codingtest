package com.study.ch09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T2606 {
	
	private static int n;
	private static int[][] network;
	private static boolean[] isVisited;
	private static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		network = new int[n+1][n+1];
		isVisited = new boolean[n+1];
		StringTokenizer st = null;
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int val1 = Integer.parseInt(st.nextToken());
			int val2 = Integer.parseInt(st.nextToken());
			
			network[val1][val2] = 1;
			network[val2][val1] = 1;
		}
		
		dfs(1);
		// 1번을 제외하므로 -1 
		System.out.println(answer-1);
	}

	private static void dfs(int idx) {	
		isVisited[idx] = true;
		answer++;
		
		for (int i=1; i<=n; i++) {
			if (network[idx][i] == 1 && !isVisited[i]) {
				dfs(i);
			}
		}
	}
}
