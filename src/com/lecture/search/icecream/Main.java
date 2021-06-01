package com.lecture.search.icecream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n = 0;
	private static int m = 0;
	private static int[][] tool;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		tool = new int[n][m];
		for (int i=0; i<n; i++) {
			String[] arr = br.readLine().split("");
			for (int j=0; j<arr.length; j++) {
				tool[i][j] = Integer.parseInt(arr[j]);
			}
		}
		
		//  DFS 활용 
		int result = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (dfs(i, j))
					result += 1;
			}
		}
		
		System.out.println(result);
	}
	
	private static boolean dfs(int x, int y) {
		// 주어진 범위를 벗어나는 경우에는 즉시 종료 
		if (x < 0 || x >= n || y < 0 || y >= m) {
			return false;
		}
		// 현재 노드를 아직 방문하지 않았다면 
		if (tool[x][y] == 0) {
			// 해당 노드 방문 처리 
			tool[x][y] = 1;
			// 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출 
			dfs(x-1, y);
			dfs(x, y-1);
			dfs(x+1, y);
			dfs(x, y+1);
			return true;
		}
		return false;
	}
}
