package com.study.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T1495_2 {
	private static int[] v;
	private static boolean[][] vols;
	private static int n;
	private static int m;
	
	// 변견 가능한 모든 볼륨을 알아보기 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		v = new int[n];
		for (int i=0; i<n; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}
		vols = new boolean[n+1][m+1];
		
		int answer = solution(s);
		System.out.println(answer);
	}

	private static int solution(int s) {
		vols[0][s] = true;
		for (int i=1; i<=n; i++) {
			for (int j=0; j<=m; j++) {
				if (!vols[i-1][j]) {
					continue;
				}
				if (j-v[i-1] >= 0) {
					vols[i][j-v[i-1]] = true;
				}
				if (j+v[i-1] <= m) {
					vols[i][j+v[i-1]] = true;
				}
			}
		}
		int answer = -1;
		for (int i=0; i<=m; i++) {
			if (vols[n][i]) {
				answer = Math.max(answer, i);
			}
		}
		return answer;
	}
}
