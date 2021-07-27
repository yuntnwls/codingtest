package com.backjoon.graphtraversal.t3055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int r;
	private static int c;
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};

	// 물을 저장할 큐 
	private static Queue<Pos> wQue = new LinkedList<Pos>();
	
	static class Pos {
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		Pos dPos = null;
		Pos sPos = null;
		// 지도를 저장할 배열  
		String map[][] = new String[r][c];
		// 물이 차오르는 날을 저장할 배열 
		int waterDay[][] = new int[r][c];
		for (int i=0; i<r; i++) {
			String line = br.readLine();
			String[] split = line.split("");
			
			for (int j=0; j<c; j++) {
				map[i][j] = split[j];
				if (split[j].equals("D")) {
					dPos = new Pos(i, j);
				} else if (split[j].equals("S")) {
					sPos = new Pos(i, j);
				} else if (split[j].equals("*")) {
					wQue.add(new Pos(i, j));	// 물의 처음 위치 넣기 
				}
			}
		}
		
		// 물에 대한 BFS 수행 
		waterBFS(waterDay, map);
		
		// 고슴도치에 대한 BFS 수행 
		int[][] check = new int[r][c];
		bfs(waterDay, map, sPos, check);
		if (check[dPos.x][dPos.y] != 0) {
			System.out.println(check[dPos.x][dPos.y]);
		} else {
			System.out.println("KAKTUS");
		}
	}
	
	// 물이 언제 차는지 계산 
	private static void waterBFS(int[][] waterDay, String[][] map) {
		while (!wQue.isEmpty()) {
			Pos currW = wQue.poll();
			
			for(int i=0; i<dx.length; i++) {
				int nX = currW.x + dx[i];
				int nY = currW.y + dy[i];
				
				if (isPass(nX, nY)) {
					if (waterDay[nX][nY] == 0 && map[nX][nY].equals(".")) {
						waterDay[nX][nY] = waterDay[currW.x][currW.y] + 1;
						wQue.add(new Pos(nX, nY));
					}
				}
			}
		}
	}

	// 고슴도치 이동거리 계산 
	private static void bfs(int[][] waterDay, String[][] map, Pos sPos, int[][] check) {
		Queue<Pos> que = new LinkedList<Pos>();
		que.add(sPos);
		
		while(!que.isEmpty()) {
			Pos curr = que.poll();
			
			for(int i=0; i<dx.length; i++) {
				int nX = curr.x + dx[i];
				int nY = curr.y + dy[i];
				
				if (isPass(nX, nY)) {
					if (check[nX][nY] == 0 && (map[nX][nY].equals(".") || map[nX][nY].equals("D"))) {
						if (waterDay[nX][nY] == 0) {
							// 도착점은 바로 큐에 넣기 
							check[nX][nY] = check[curr.x][curr.y] + 1;
							que.add(new Pos(nX, nY));
						} else {
							// 이동하려는 칸이 다음날 물이 차오르지 않는다면 큐에 넣어주기 
							if (waterDay[nX][nY] > (check[curr.x][curr.y] + 1)) {
								check[nX][nY] = check[curr.x][curr.y] + 1;
								que.add(new Pos(nX, nY));
							}
						}
					}
				}
			}
		}
	}
	
	private static boolean isPass(int x, int y) {
		if (x >= 0 && x < r && y >= 0 && y < c) {
			return true;
		}
		return false;
	}
}

// https://velog.io/@skyepodium/%EB%B0%B1%EC%A4%80-3055-%ED%83%88%EC%B6%9C
