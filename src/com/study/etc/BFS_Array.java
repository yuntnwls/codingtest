package com.study.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_Array {
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
		
		// BFS - 인접행렬 
		bfs_array(v, nodeArray, visited);
	}

	private static void bfs_array(int v, int[][] nodeArray, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int n = nodeArray.length-1;
		
		queue.add(v);
		visited[v] = true;
		
		while (!queue.isEmpty()) {
			v = queue.poll();
			System.out.print(v + " ");
			
			for (int i=1; i<=n; i++) {
				if (nodeArray[v][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
