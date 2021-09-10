package com.study.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class T2655 {

	private static List<Brick> brickList = new ArrayList<>();
	
	static class Brick implements Comparable<Brick> {
		int index;
		int area;
		int height;
		int weight;
		public Brick(int index, int area, int height, int weight) {
			this.index = index;
			this.area = area;
			this.height = height;
			this.weight = weight;
		}
		@Override
		public int compareTo(Brick o) {
			// 너비 기준으로 정렬 
			return this.area - o.area;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		brickList.add(new Brick(0, 0, 0, 0));
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			brickList.add(new Brick(i, Integer.parseInt(st.nextToken()), 
									   Integer.parseInt(st.nextToken()), 
									   Integer.parseInt(st.nextToken())));
		}
		Collections.sort(brickList);
		
		solution(n);
	}

	private static void solution(int n) {
		int[] dp = new int[n+1];
		List<Integer> answerList = new ArrayList<Integer>();
		for (int i=1; i<=n; i++) {
			for (int j=0; j<i; j++) {
				if (brickList.get(i).weight > brickList.get(j).weight) {
					dp[i] = Math.max(dp[i], dp[j]+brickList.get(i).height);
				}
			}
		}
		
		int maxHeight = 0;
		for (int i=n; i>=1; i--) {
			maxHeight = Math.max(maxHeight, dp[i]);
		}
		
		for (int i=n; i>=1; i--) {
			if (maxHeight == dp[i]) {
				answerList.add(brickList.get(i).index);
				maxHeight -= brickList.get(i).height;
			}
		}
		
		System.out.println(answerList.size());
		for (int i=answerList.size()-1; i>=0; i--) {
			System.out.println(answerList.get(i));
		}
	}
}
