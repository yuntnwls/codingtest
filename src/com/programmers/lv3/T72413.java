package com.programmers.lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://programmers.co.kr/learn/courses/30/lessons/72413?language=java
public class T72413 {
	// 플로이드 와샬 알고리즘 
	private static int[][] nodes;
	private static final int INF = 20000001; // 200 * 100000 + 1
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int s = Integer.parseInt(br.readLine());
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		int f = Integer.parseInt(br.readLine());
		int[][] fares = new int [f][3];
		for (int i=0; i<f; i++) {
			String line = br.readLine().replaceAll(" ", "");
			String[] split = line.split(",");
			for (int j=0; j<split.length; j++) {
				fares[i][j] = Integer.parseInt(split[j]);
			}
		}
		
		int answer = solution(n, s, a, b, fares);
		System.out.println(answer);
	}

	private static int solution(int n, int s, int a, int b, int[][] fares) {
		nodes = new int[n+1][n+1];
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				nodes[i][j] = INF;
			}
			nodes[i][i] = 0;	// 출발점과 도착점이 같은 경우 0으로 설정 
		}
		for (int i=0; i<fares.length; i++) {
			int[] fare = fares[i];
			nodes[fare[0]][fare[1]] = fare[2];
			nodes[fare[1]][fare[0]] = fare[2];
		}
		
		// 지나가는 정점 
		for (int k=1; k<=n; k++) {
			// 출발 정점
			for (int i=1; i<=n; i++) {
				// 도착 정점 
				for (int j=1; j<=n; j++) {
					if (nodes[i][k] + nodes[k][j] < nodes[i][j]) {
						nodes[i][j] = nodes[i][k] + nodes[k][j];
					}
				}
			}
		}
		
		// 각자 가는데 필요한 비용 
		int answer = nodes[s][a] + nodes[s][b];
		for (int i=1; i<=n; i++) {
			if (s == i)
				continue;
			// i까지 같이가는데 필요한 비용들과 비교  
			answer = Math.min(answer, nodes[s][i] + nodes[i][a] + nodes[i][b]);
		}
		return answer;
	}
}
