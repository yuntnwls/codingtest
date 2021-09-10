package com.study.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T1495 {

	private static int[] v;
	private static boolean[][] vols;
	private static int m;
	
	// 변견 가능한 모든 볼륨을 알아보기 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		v = new int[n];
		for (int i=0; i<n; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}
		vols = new boolean[v.length][m+1];
		
		int answer = solution(s);
		System.out.println(answer);
	}

	private static int solution(int s) {
		setVol(s, 0);
		boolean isChanged = false;
		for (int i=1; i<v.length; i++) {
			isChanged = false;
			for (int j=0; j<=m; j++) {
				if (vols[i-1][j]) {
					setVol(j, i);
					isChanged = true;
				}
			}
			if (!isChanged) {
				return -1;
			}
		}
		
		int maxVol = -1;
		for (int j=0; j<=m; j++) {
			if (vols[v.length-1][j]) {
				maxVol = Math.max(maxVol, j);
			}
		}
		return maxVol;
	}
	
	private static void setVol(int now, int index) {
		int vol = now - v[index];
		if (vol >= 0 && vol <= m) {
			vols[index][vol] = true;
		}
		vol = now + v[index];
		if (vol >= 0 && vol <= m) {
			vols[index][vol] = true;
		}
	}
}
