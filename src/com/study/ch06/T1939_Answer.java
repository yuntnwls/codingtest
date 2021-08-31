package com.study.ch06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class T1939_Answer {
	// 중량이 최대 1,000,000,000 이므로 값이 큼
	// 중량제한을 찾고자하므로 이진탐색을 수행 
	// BFS를 이용하여 특정한 위치에서 다른 특정한 노드로 이동이 가능한지 확인 
	// 간선의 갯수만큼 반복 수행 
	// 이진 탐색 + BFS
	
	static class Route {
		int dest;
		int weight;
		public Route(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}
	
	private static int n;
	private static int m;
	private static List<List<Route>> map = new ArrayList<List<Route>>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<=n; i++) {
			map.add(new ArrayList<Route>());
		}
		
		int maxWeight = 0;
		int start;
		int end;
		int weight;
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			
			map.get(start).add(new Route(end, weight));
			map.get(end).add(new Route(start, weight));
			
			maxWeight = Math.max(maxWeight, weight);
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int answer = solution(start, end, maxWeight);
		System.out.println(answer);
	}
	
	private static int solution(int start, int end, int maxWeight) {
		int left = 0;
		int right = maxWeight;
		
		while (left <= right) {
			int mid = (left + right)/2;
			
			if (bfs(start, end, mid)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return right;
	}

	private static boolean bfs(int start, int end, int mid) {
		boolean[] isVisited = new boolean[n+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		isVisited[start] = true;
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			if (now == end) {
				return true;
			}
			
			for (Route route : map.get(now)) {
				if (!isVisited[route.dest] && mid <= route.weight) {
					isVisited[route.dest] = true;
					queue.add(route.dest);
				}
			}
		}
		
		return false;
	}
}

//https://hidelookit.tistory.com/200