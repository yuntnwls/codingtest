package com.programmers.study.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/49189?language=java
public class T49189 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] edge = new int[m][2];
		for (int i=0; i<m; i++) {
			String line = br.readLine().replaceAll(" ",  "");
			String[] split = line.split(",");
			edge[i][0] = Integer.parseInt(split[0]);
			edge[i][1] = Integer.parseInt(split[1]);
		}
		
		int answer =  solution(n, edge);
		System.out.println(answer);
	}
	
	private static int[] dist;
	private static ArrayList<Integer>[] nodeList;
	
	private static int solution(int n, int[][] edge) {
		nodeList = new ArrayList[n+1];
		for (int i=1; i<=n; i++) {
			nodeList[i] = new ArrayList<Integer>();
		}
		
		for (int i=0; i<edge.length; i++) {
			nodeList[edge[i][0]].add(edge[i][1]);
			nodeList[edge[i][1]].add(edge[i][0]);
		}
		
		dist = new int[n+1];
		
		bfs(n);
		
		// max 거리인 node 개수 구하기 
		int max = 0;
		int answer = 0;
		for (int i=1; i<=n; i++) {
			if (max < dist[i]) {
				max = dist[i];
				answer = 1;
			} else if (max == dist[i]) {
				answer++;
			}
		}
		return answer;
	}

	private static void bfs(int n) {
		boolean[] isVisited = new boolean[n+1];
		isVisited[1] = true;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		
		int now = 0;
		while (!queue.isEmpty()) {
			now = queue.poll();
			for (int node : nodeList[now]) {
				if (!isVisited[node]) {
					isVisited[node] = true;
					dist[node] = dist[now]+1; // 현재 거리+1 
					queue.add(node);
				}
			}
		}
	}
}
