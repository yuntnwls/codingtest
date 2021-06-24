package com.backjoon.graphtraversal.t1697;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Location {
		int num;	// 현재 위치 
		int depth;	// 해당 위치에 도달하는데 걸린 시간 
		public Location(int num, int depth) {
			this.num = num;
			this.depth = depth;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int answer = solution(n, k);
		System.out.println(answer);
	}

	private static int solution(int n, int k) {
		int result = 0;
		boolean[] isVisited = new boolean[100001];
		Queue<Location> queue = new LinkedList<Location>();
		queue.add(new Location(n, 0));
		
		while(!queue.isEmpty()) {
			Location loc = queue.poll();
			int num = loc.num;
			int depth = loc.depth;
			
			if (num == k) {
				// k의 위치와 동일하면 종료
				result = depth;
				break;
			}
			
			if (isValid(num-1, isVisited)) {
				isVisited[num-1] = true;
				queue.add(new Location(num-1, depth + 1));
			}
			if (isValid(num+1, isVisited)) {
				isVisited[num+1] = true;
				queue.add(new Location(num+1, depth + 1));
			}
			if (isValid(num*2, isVisited)) {
				isVisited[num*2] = true;
				queue.add(new Location(num*2, depth + 1));
			}
		}
		
		return result;
	}
	
	private static boolean isValid(int num, boolean[] isVisited) {
		if (num >= 0 && num <= 100000 && !isVisited[num]) {
			return true;
		}
		return false;
	}
}

//https://chanhuiseok.github.io/posts/baek-14/
