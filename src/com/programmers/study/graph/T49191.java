package com.programmers.study.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://programmers.co.kr/learn/courses/30/lessons/49191?language=java
public class T49191 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] results = new int[m][2];
		for (int i=0; i<m; i++) {
			String line = br.readLine().replaceAll(" ", "");
			String[] split = line.split(",");
			results[i][0] = Integer.parseInt(split[0]);
			results[i][1] = Integer.parseInt(split[1]);
		}
		
		int answer = solution(n, results);
		System.out.println(answer);
	}

	// 플로이드 워셜 알고리즘 사용 
	private static int solution(int n, int[][] results) {
		boolean[][] resultTable = new boolean[n+1][n+1];
		for (int i=0; i<results.length; i++) {
			int win = results[i][0];
			int lose = results[i][1];
			
			resultTable[win][lose] = true;
			resultTable[lose][win] = false;
		}
		
		floyd(n, resultTable);
		
		// 승/패를 정확히 알아 순위를 매길수 있는 사람의 수 
		int answer = 0;
		for (int i=1; i<=n; i++) {
			boolean isRanked = true;
			for (int j=1; j<=n; j++) {
				if (i == j) {
					continue;
				}
				// 승패가 하나라도 알 수 없는 경우 
				if (!(resultTable[i][j] || resultTable[j][i])) {
					isRanked = false; 
				}
			}
			if (isRanked)
				answer++;
		}
		return answer;
	}
	
	private static void floyd(int n, boolean[][] resultTable) {
		for (int k=1; k<=n; k++) {
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=n; j++) {
					if (i == j) {
						continue;
					}
					// i와 j의 승패를 확실히 알 수 있는 경우 
					if (resultTable[i][k] && resultTable[k][j]) {
						resultTable[i][j] = true;
					}
				}
			}
		}
	}
	
//	private static int solution(int n, int[][] results) {
//		int[][] resultTable = new int[n+1][n+1];
//		for (int i=0; i<results.length; i++) {
//			int win = results[i][0];
//			int lose = results[i][1];
//			
//			resultTable[win][lose] = 1;
//			resultTable[lose][win] = -1;
//		}
//		
//		floyd(n, resultTable);
//		
//		// 승/패를 정확히 알아 순위를 매길수 있는 사람의 수 
//		int answer = 0;
//		for (int i=1; i<=n; i++) {
//			int cnt = 0;
//			for (int j=1; j<=n; j++) {
//				if (resultTable[i][j] != 0 || resultTable[j][i] != 0) {
//					if (i != j)
//						cnt++;
//				}
//			}
//			if (cnt == n-1)
//				answer++;
//		}
//		return answer;
//	}
//	
//	private static void floyd(int n, int[][] resultTable) {
//		for (int k=1; k<=n; k++) {
//			for (int i=1; i<=n; i++) {
//				for (int j=1; j<=n; j++) {
//					if (resultTable[i][k] == 0) {
//						continue;
//					}
//					
//					if (resultTable[i][k] == resultTable[k][j]) {	// 확실한 승/패가 있는 경우 
//						resultTable[i][j] = resultTable[i][k]; // i->k->j or j->k->i 이므로 i,k의 대소 관계를 알 수 있다.
//					}
//				}
//			}
//		}
//	}
}
