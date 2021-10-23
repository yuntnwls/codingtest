package com.study.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1753
public class Dijkstra {
	// 다익스트라 알고리즘 : 최단경로 탐색 알고리즘 
	// 현재까지 알고있던 최단경로를 계속해서 갱신 
	// 1. 출발 노드 설정
	// 2. 출발 노드를 기준으로 각 노드의 최소 비용 저장
	// 3. 방문하지 않은 노드 중에서 가장 비용이 적은 노드를 선택 
	// 4. 해당 노드를 거쳐서 특정한 노드로 가는 경우를 고려하여 최소 비용 갱신 
	// 5. 3~4번을 반복 
	
	// https://blog.naver.com/ndb796/221234424646
	private static int v, e, k;
	private static List<Node>[] nodes;
	private static int[] dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());	// 정점 개수 
		e = Integer.parseInt(st.nextToken());  	// 간선 개수
		k = Integer.parseInt(br.readLine());	// 시작 정점 번호
		
		// 1~v 정점의 최소 거리를 저장할 배열  
		dist = new int[v+1];
		// 초기값으로 최대값을 설정 
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		nodes = new ArrayList[v+1];
		for (int i=1; i<=v; i++) {
			nodes[i] = new ArrayList<>();
		}
		for (int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			// start에서 end로 가는 가중치 저장 
			nodes[start].add(new Node(end, weight));
		}
		
		dijkstra(k);
		for (int i=1; i<=v; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[v+1];
		pq.add(new Node(start, 0));
		dist[start] = 0; // 자기자신이므로 가중치는 0
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			int currIdx = curr.end;
			if (check[currIdx]) {
				continue;
			}
			check[currIdx] = true;
			
			for (Node node : nodes[currIdx]) {
				if (dist[node.end] > dist[currIdx] + node.weight) {
					dist[node.end] = dist[currIdx] + node.weight;
					pq.add(new Node(node.end, dist[node.end]));
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int end;
		int weight;
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
}
