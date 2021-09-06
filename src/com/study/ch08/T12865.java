package com.study.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T12865 {
	// knapsack 알고리즘 
	// 모든 무게에 대하여 최대 가치를 정한다 
	// 현재 무게가 총 무게보다 크면 이전값을 그대로 
	// 현재 무게가 총 무게보다 작으며 이전값 vs (총무게-현재무게)의 이전값+현재가치 중 큰 값 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int w = 0;
		int v = 0;
		
		int[][] data = new int[n+1][k+1];
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			for (int j=1; j<=k; j++) {
				if (j < w) {
					data[i][j] = data[i-1][j];
				} else {
					data[i][j] = Math.max(data[i-1][j], data[i-1][j-w] + v);
				}
			}
		}
		System.out.println(data[n][k]);
	}
}
