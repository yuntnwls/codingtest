package com.study.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class T1774 {
	// 최소 신장 트리 (MST=Minimum Spanning Tree)
	// n개의 정점을 가지는 그래프에 대해 반드시 n-1개의 정점을 가져야한다.
	// 간선의 가중치 합이 최소 
	// 사이클이 포함되어서는 안된다. 
	
	// 크루스칼(Kruskal) 알고리즘  
	// https://www.youtube.com/watch?v=LQ3JHknGy8c
	// union-find를 통해 사이클이 발생하지 않도록 확인 
	// https://www.youtube.com/watch?v=AMByrd53PHM
	
	static int[] parent;
	static List<Edge> edgeList;
	
	static class Node {
		double x;
		double y;
		int index;
		
		public Node(double x, double y, int index) {
			this.x = x;
			this.y = y;
			this.index = index;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		double weight;
		
		public Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			if (this.weight < o.weight) {
				return -1;
			}
			return 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		for (int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
		Node[] nodes = new Node[n+1];
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			nodes[i] = new Node(x, y, i);
		}
		
		// 사전에 연결된 간선을 미리 합집합 연산 
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			union(start, end);
		}
		
		// 모든 통로들 간의 간선과 비용 정보를 리스트에 저장 
		edgeList = new ArrayList<>();
		for (int i=1; i<=n; i++) {
			for (int j=i+1; j<=n; j++) {
				double weight = distance(nodes[i], nodes[j]);
				edgeList.add(new Edge(nodes[i].index, nodes[j].index, weight));
			}
		}
		
		// 간선 비용을 기준으로 오름차순 정렬 
		Collections.sort(edgeList);
		
		double answer = 0;
		// 크로스칼 알고리즘 수행 
		for (int i=0; i<edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			if (find(edge.start) != find(edge.end)) {
				answer += edge.weight;
				union(edge.start, edge.end);
			}
		}
		
		System.out.println(String.format("%.2f", answer));
	}

	private static double distance(Node node1, Node node2) {
		return Math.sqrt(Math.pow(node1.x - node2.x, 2) + Math.pow(node1.y - node2.y, 2));
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			parent[y] = x;
		}
	}

	private static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
}
