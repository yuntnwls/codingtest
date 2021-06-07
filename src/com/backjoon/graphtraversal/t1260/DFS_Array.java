package com.backjoon.graphtraversal.t1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFS_Array {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	// 정점의 개수 
		int m = Integer.parseInt(st.nextToken());	// 간선의 개수 
		int v = Integer.parseInt(st.nextToken());	// 탐색을 시작할 정점의 번호 
		
		int[][] nodeArray = new int[n+1][n+1];
		boolean[] visited = new boolean[n+1];
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()); 
			int v2 = Integer.parseInt(st.nextToken()); 
			
			nodeArray[v1][v2] = 1;
			nodeArray[v2][v1] = 1;			
		}
		
		// DFS - 인접행렬 / 재귀로 구현 
		dfs_array_recursion(v, nodeArray, visited);
		
		// visited false로 초기화 
		Arrays.fill(visited, false);
		System.out.println("");
		
		// DFS - 인접행렬 / 스택으로 구현 
		dfs_array_stack(v, nodeArray, visited, true);
	}

	// DFS - 인접행렬 / 재귀로 구현 
	private static void dfs_array_recursion(int v, int[][] nodeArray, boolean[] visited) {
		// 인접 리스트에서의 재귀와 동일한 방식 
		int len = nodeArray.length-1;
		visited[v] = true;
		System.out.print(v + " ");
		
		for (int i=0; i<=len; i++) {
			if (nodeArray[v][i] == 1 && !visited[i]) {
				dfs_array_recursion(i, nodeArray, visited);
			}
		}
	}

	// DFS - 인접행렬 / 스택으로 구현 
	private static void dfs_array_stack(int v, int[][] nodeArray, boolean[] visited, boolean flag) {
		int len = nodeArray.length-1;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(v);
		visited[v] = true;
		System.out.print(v + " ");
		
		while(!stack.isEmpty()) {
			int w = stack.peek();
			flag = false;
			
			for (int i=0; i<=len; i++) {
				// 정점에 간선이 연결되어있고, 아직 방문하지 않은 경우 
				if (nodeArray[w][i] == 1 && !visited[i]) {
					stack.push(i);
					System.out.print(i + " ");
					visited[i] = true;
					flag = true;
					
					break;
				}
			}
			if (!flag) {
				// 연결된 간선이 없고, 방문하지 않은 정점을 찾지 못한다면, 더이상 탐색할 수 없음 
				stack.pop();
			}
		}
	}
}
