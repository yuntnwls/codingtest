package com.study.ch02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class T4195_Answer {
	// Union-Find(합집합) 알고리즘
	// 원소들의 연결 여부 확인 알고리즘 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int k=0; k<t; k++) {
			int f = Integer.parseInt(br.readLine());
			
			int[] parent = new int[f*2+1];
			int[] network = new int[f*2+1];
			Map<String, Integer> dataMap = new HashMap<String, Integer>();
			
			String one;
			String two;
			int no = 1;
			for (int i=1; i<=f*2; i++) {
				parent[i] = i;
				network[i] = 1;
			}
			for (int i=0; i<f; i++) {				
				st = new StringTokenizer(br.readLine());
				one = st.nextToken();
				two = st.nextToken();

				if (dataMap.get(one) == null)	dataMap.put(one, no++);
				if (dataMap.get(two) == null)	dataMap.put(two, no++);
			
				unionParent(parent, network, dataMap.get(one), dataMap.get(two));
				System.out.println(network[findParent(parent, dataMap.get(one))]);
			}
		}
	}
	
	private static int findParent(int[] parent, int x) {
		if (parent[x] == x) {
			return x;
		} else {
			return findParent(parent, parent[x]);
		}
	}
	
	private static void unionParent(int[] parent, int[] network, int x, int y) {
		x = findParent(parent, x);
		y = findParent(parent, y);
		
		if (x != y) {
			parent[y] = x;
			network[x] += network[y];
		}
	}
}
