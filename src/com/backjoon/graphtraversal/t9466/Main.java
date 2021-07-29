package com.backjoon.graphtraversal.t9466;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	private static int cnt = 0;
	private static boolean[] isVisited = null;
	private static boolean[] isFinished = null;	// 방문이 끝났는지 여부 확인 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		List<Integer> answerList = new ArrayList<Integer>();
		StringTokenizer st = null;
		for (int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] students = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=n; j++) {
				students[j] = Integer.parseInt(st.nextToken());
			}
			
			cnt = 0;
			isVisited = new boolean[n+1];
			isFinished = new boolean[n+1];
			for (int k=1; k<=n; k++) {
				if (!isVisited[k]) {
					dfs(students, k);
				}
			}
			answerList.add(n-cnt);
		}
		
		for (int i=0; i<t; i++) {
			System.out.println(answerList.get(i));
		}
	}

	private static void dfs(int[] students, int k) {
		isVisited[k] = true;
		
		int next = students[k];
		if (!isVisited[next]) {
			dfs(students, next);
		} else {
			// 이미 방문했지만 방문이 끝난 노드가 아니라면 싸이클 
			if (!isFinished[next]) {
				// 현재 노드가 아닌 다음 노드 기준으로 하면 싸이클이 무조건 존재 
				cnt++;
				for (int i=next; i!=k; i=students[i]) {
					cnt++;
				}
			}
		}
		
		isFinished[k] = true;
	}
}
// http://melonicedlatte.com/algorithm/2018/08/26/232029.html