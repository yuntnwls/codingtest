package com.programmers.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class T42861 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] costs = new int[n+1][3];
		for (int i=0; i<=n; i++) {
			String line = br.readLine();
			String[] split = line.split(",");
			for (int j=0; j<3; j++) {
				costs[i][j] = Integer.parseInt(split[j]);
			}
		}
		
		int answer = solution(n, costs);
		System.out.println(answer);
	}
	
	private static int[] parent;

	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	// 크루스칼 알고리즘 사용 
	private static int solution(int n, int[][] costs) {
		List<Node> nodeList = new ArrayList<>();
		parent = new int[n];
		for (int i=0; i<n; i++) {
			parent[i] = i;
		}
		for (int i=0; i<costs.length; i++) {
			nodeList.add(new Node(costs[i][0], costs[i][1], costs[i][2]));
		}
		Collections.sort(nodeList);

		int answer = 0;
		for (int i=0; i<costs.length; i++) {
			int start = find(nodeList.get(i).x);
			int end = find(nodeList.get(i).y);
			int cost = nodeList.get(i).cost;
			
			if (start != end) {
				answer += cost;
				parent[end] = start;
			}
		}
		
		return answer;
	}
	
	private static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
}
