package com.study.ch07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class T1766 {
	// 위상 정렬 알고리즘 

	// 노드와 간선 정보 
	private static Map<Integer, List<Integer>> qMap = new HashMap<Integer, List<Integer>>();
	// 진입 차수 
	private static int[] indegree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		indegree = new int[n+1];
		for (int i=1; i<=n; i++) {
			qMap.put(i, new ArrayList<Integer>());
		}
		
		
		int first = 0;
		int second = 0;
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			first = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());
			List<Integer> qList = qMap.get(first);
			qList.add(second);
			
			indegree[second]+=1;
		}
		
		List<Integer> answerList = solution();
		for (int i=0; i<answerList.size(); i++) {
			System.out.print(answerList.get(i));
			System.out.print(" ");
		}
	}

	private static List<Integer> solution() {
		List<Integer> resultList = new ArrayList<Integer>();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i=1; i<indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		int current = 0;
		while (!queue.isEmpty()) {
			current = queue.poll();
			resultList.add(current);
			List<Integer> qList = qMap.get(current);
			for (int i=0; i<qList.size(); i++) {
				int value = qList.get(i);
				indegree[value] -= 1;
				if (indegree[value] == 0) {
					queue.add(value);
				}
			}
		}
		
		return resultList;
	}
}
