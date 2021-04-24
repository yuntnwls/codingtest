package com.backjoon.backtracking.t15649;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://st-lab.tistory.com/114
// 백트래킹 : 어떤노드의 유망성을 판단한 뒤, 해당 노드가 유망하지 않다면 부모 노드로 돌아가 다른 자식노드를 찾는 방법,
// 모든 경우의 수를 찾아보지만, 그 중에서도 가능성이 있는 경우의 수만 찾아보는 방법 
// 백트래킹의 방법 중 하나가 DFS
// 브루트포스 : 모든 경우의수를 찾아보는 방법(가능성은 따지지 않고 모든 경우의 수를 순회) 
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[] visit = new boolean[n];
		int[] answer = new int[m];
		StringBuffer sb = new StringBuffer();
		
		dfs(n, m, 0, answer, visit, sb);
		System.out.println(sb);
	}

	private static void dfs(int n, int m, int depth, int[] answer, boolean[] visit, StringBuffer sb) {
		if (depth == m) {
			for (int val : answer) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=0; i<n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				answer[depth] = i+1;
				dfs(n, m, depth+1, answer, visit, sb);
				visit[i] = false;
			}
		}
	}
}

