package com.backjoon.graphtraversal.t7562;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int dx[] = {-2, -2, -1, 1, 2, 2, 1, -1};
	private static int dy[] = {-1, 1, 2, 2, 1,-1, -2, -2};
	
	static class Pos {
		int x;
		int y;
		int dist;
		public Pos(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for (int t=0; t<tc; t++) {
			int len = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			Pos source = new Pos(x, y, 0);

			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			Pos dest = new Pos(x, y, 0);
			
			int count = bfs(source, dest, len);
			System.out.println(count);
		}
	}
	
	private static int bfs(Pos source, Pos dest, int len) {
		boolean[][] isVisited = new boolean[len][len];
		Queue<Pos> queue = new LinkedList<Pos>();
		
		queue.add(source);
		isVisited[source.x][source.y] = true;
		
		int answer = 0;
		int currDist = 0;
		Pos now = null;
		while(!queue.isEmpty()) {
			now = queue.poll();
			currDist = now.dist;
			answer = currDist;
			
			if (now.x == dest.x && now.y == dest.y) {
				break;
			}
			
			for (int i=0; i<dx.length; i++) {
				int newX = now.x + dx[i];
				int newY = now.y + dy[i];
				
				if (newX >= 0 && newX < len && newY >= 0 && newY < len) {
					if (!isVisited[newX][newY]) {
						isVisited[newX][newY] = true;
						queue.add(new Pos(newX, newY, currDist+1));
					}
				}
			}
		}
		
		return answer;
	}
}
