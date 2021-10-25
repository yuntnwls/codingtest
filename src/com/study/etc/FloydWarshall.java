package com.study.etc;

public class FloydWarshall {
	
	// 플로이드-와샬 알고리즘 : 모든 정점에서 모든 정점으로의 최단 경로 
	// 거쳐가는 정점을 기준으로 최단거리를 구하는 것 
	// 다익스트라 알고리즘은 가장 적은 비용을 하나씩 선택해야 했다면
	// 플로이드 와샬 알고리즘은 기본적으로 거쳐가는 정점을 기준으로 알고리즘 수행 
	// https://blog.naver.com/ndb796/221234427842
	
	private static int n = 4;
	private static final int INF = 10000000;
	
	public static void main(String[] args) {
		int[][] a = new int[n+1][n+1];
		input(a);
		
		floydWarshall(a);
	}
	
	private static void floydWarshall(int[][] a) {
		// 결과 그래프 초기화 
		int[][] d = new int[n+1][n+1];
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				d[i][j] = a[i][j];
			}
		}
		
		//k = 거쳐가는 노드 
		for (int k=1; k<=n; k++) {
			//i = 출발 노드 
			for (int i=1; i<=n; i++) {
				// j = 도착 노드 
				for (int j=1; j<=n; j++) {
					// k를 거쳐가는것이 현재 값보다 작으면 갱신 
					if (d[i][k] + d[k][j] < d[i][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void input(int[][] a) {
		a[1][1] = 0;
		a[1][2] = 5;
		a[1][3] = INF;
		a[1][4] = 8;
		
		a[2][1] = 7;
		a[2][2] = 0;
		a[2][3] = 9;
		a[2][4] = INF;
		
		a[3][1] = 2;
		a[3][2] = INF;
		a[3][3] = 0;
		a[3][4] = 4;
		
		a[4][1] = INF;
		a[4][2] = INF;
		a[4][3] = 3;
		a[4][4] = 0;
	}
}
