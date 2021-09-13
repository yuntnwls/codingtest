package com.study.ch10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class T5720_Answer {
	
	// 최단 경로를 저장하는 리스트(역으로 저장)
	private static List<List<Road>> parentRoad = null;
	// 제외할 경로를 구분하기 위한 배열 
	private static boolean[][] deletedRoad = null;
	
	static class Road implements Comparable<Road> {
		int idx;
		int dist;
		public Road(int idx, int d) {
			this.idx = idx;
			this.dist = d;
		}
		@Override
		public int compareTo(Road o) {
			return this.dist - o.dist;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0) {
				break;
			}
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			List<Road>[] array = new ArrayList[n];
			parentRoad = new ArrayList<>();
			for (int i=0; i<n; i++) {
				array[i] = new ArrayList<>();
				parentRoad.add(new ArrayList<>());
			}
			for (int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int dist = Integer.parseInt(st.nextToken());
				array[start].add(new Road(end, dist));
			}
			
			int[] distArr = new int[n];
			Arrays.fill(distArr, Integer.MAX_VALUE);
			deletedRoad = new boolean[n][n];
			
			// 최단 거리 찾아내기 
			dijkstra(distArr, array, s, d, deletedRoad, true);
			
			// 최단 경로를 제거
			deleteShortestRoads(s, d, deletedRoad);

			// 다시 최단 경로를 검색 
			// 다익스트라를 두번 수행 
			Arrays.fill(distArr, Integer.MAX_VALUE);
			dijkstra(distArr, array, s, d, deletedRoad, false);
			
			int answer = distArr[d];
			if (answer == Integer.MAX_VALUE) {
				answer = -1;
			}
			System.out.println(answer);
		}
		
	}

	private static void deleteShortestRoads(int s, int idx, boolean[][] removedRoad) {
		if (idx == s) {
			return;
		}
		for (int i=0; i<parentRoad.get(idx).size(); i++) {
			Road parent = parentRoad.get(idx).get(i);
			if (removedRoad[parent.idx][idx]) {
				continue;
			}
			removedRoad[parent.idx][idx] = true;
			deleteShortestRoads(s, parent.idx, removedRoad);
		}
	}

	private static void dijkstra(int[] distArr, List<Road>[] array, int s, int d, boolean[][] removedRoad, boolean isSaveParent) {
		PriorityQueue<Road> queue = new PriorityQueue<>();
		queue.add(new Road(s, 0));
		distArr[s] = 0;
		
		Road now;
		while (!queue.isEmpty()) {
			now = queue.poll();
			int nowIdx = now.idx;
			int nowDist = now.dist;
			if (distArr[nowIdx] < nowDist) {
				continue;
			}
			
			for (int i=0; i<array[nowIdx].size(); i++) {
				int nextIdx = array[nowIdx].get(i).idx;
				if (!removedRoad[nowIdx][nextIdx]) {
					int nextDist = array[nowIdx].get(i).dist + nowDist;
					if (distArr[nextIdx] > nextDist) {
						if (isSaveParent) {
							parentRoad.get(nextIdx).clear();
							parentRoad.get(nextIdx).add(now);
						}
						distArr[nextIdx] = nextDist;
						queue.add(new Road(nextIdx, nextDist));
					}
					if (isSaveParent && distArr[nextIdx] == nextDist) {
						parentRoad.get(nextIdx).add(now);
					}
				}
			}
		}
	}
}
