package com.study.ch10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class T10282 {
	// 다익스트라 유형 
	static class Dependency implements Comparable<Dependency> {
		int dependentCom;
		int sec;
		public Dependency(int dependentCom, int sec) {
			this.dependentCom = dependentCom;
			this.sec = sec;
		}
		@Override
		public int compareTo(Dependency o) {
			return this.sec - o.sec;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcCnt = Integer.parseInt(br.readLine());
		for (int t=0; t<tcCnt; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			List<Dependency>[] depArray = new ArrayList[n+1];

			for (int i=1; i<=n; i++) {
				depArray[i] = new ArrayList<>();
			}
			
			for (int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				depArray[b].add(new Dependency(a, Integer.parseInt(st.nextToken())));
			}
			
			int[] result = dijkstra(depArray, c);
			
			int max = 0;
			int count = 0;
			for (int i=1; i<=n; i++) {
				if (result[i] != Integer.MAX_VALUE) {
					count++;
					max = Math.max(max, result[i]);
				}
			}
			System.out.println(count + " " + max);
		}
	}
	
	private static int[] dijkstra(List<Dependency>[] depArray, int c) {
		int[] infectedSec = new int[depArray.length];
		Arrays.fill(infectedSec, Integer.MAX_VALUE);
		PriorityQueue<Dependency> queue = new PriorityQueue<>();
		queue.add(new Dependency(c, 0));
		infectedSec[c] = 0;
		
		Dependency now;
		int sec;
		int nowIdx;
		int nextIdx;
		int nextSec;
		while (!queue.isEmpty()) {
			now = queue.poll();
			nowIdx = now.dependentCom;
			sec = now.sec;
			if (infectedSec[nowIdx] < sec) {
				continue;
			}
			
			for (int i=0; i<depArray[nowIdx].size(); i++) {
				nextIdx = depArray[nowIdx].get(i).dependentCom;
				nextSec = depArray[nowIdx].get(i).sec + sec;
				if (infectedSec[nextIdx] > nextSec) {
					infectedSec[nextIdx] = nextSec;
					queue.add(new Dependency(nextIdx, nextSec));
				}
			}
		}
		return infectedSec;	
	}
}
