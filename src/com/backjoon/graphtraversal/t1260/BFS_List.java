package com.backjoon.graphtraversal.t1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_List {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	// 정점의 개수 
		int m = Integer.parseInt(st.nextToken());	// 간선의 개수 
		int v = Integer.parseInt(st.nextToken());	// 탐색을 시작할 정점의 번호 
		
		LinkedList<Integer>[] nodeList = new LinkedList[n+1];
		for (int i=0; i<=n; i++) {
			nodeList[i] = new LinkedList<Integer>();
		}
		
		// 두 정점 사이에 여러개의 간선이 있을 수 있다.
		// 입력으로 주어지는 간선은 양방향 
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()); 
			int v2 = Integer.parseInt(st.nextToken()); 
			nodeList[v1].add(v2);
			nodeList[v2].add(v1);
		}
		
		for (int i=0; i<=n; i++) {
			// 방문 순서를 위해 오름차순 정렬 
			Collections.sort(nodeList[i]);
		}
		
		boolean[] visited = new boolean[n+1];
		bfs_list(v, nodeList, visited);
	}

	// BFS 인접 리스트 
	private static void bfs_list(int v, LinkedList<Integer>[] nodeList, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[v] = true;
		queue.add(v);
		
		while (queue.peek() != null) {
			v = queue.poll();
			System.out.print(v + " ");
			
			Iterator<Integer> iter = nodeList[v].listIterator();
			while (iter.hasNext()) {
				int w = iter.next();
				if (!visited[w]) {
					visited[w] = true;
					queue.add(w);
				}
			}
		}
	}

}
