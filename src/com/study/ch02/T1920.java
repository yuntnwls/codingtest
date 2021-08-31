package com.study.ch02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class T1920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		// HashSet이 가장 빠른 임의 접근 속도/순서는 예측 불가 
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int i=0; i<n; i++) {
			hashSet.add(Integer.parseInt(st.nextToken()));
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int checkNum = -1;
		for (int i=0; i<m; i++) {
			checkNum = Integer.parseInt(st.nextToken());
			if (hashSet.contains(checkNum)) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}
	}
}
