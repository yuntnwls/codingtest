package com.backjoon.graphtraversal.t9019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static final int MAX = 10000;
	
	static class Item {
		int num;
		String move;
		public Item(int n, String move) {
			this.num = n;
			this.move = move;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		List<String> answerList = new ArrayList<String>();
		StringTokenizer st = null;
		for (int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			String answer = solution(num1, num2);
			answerList.add(answer);
		}
		
		for (int i=0; i<answerList.size(); i++) {
			System.out.println(answerList.get(i));
		}
	}

	private static String solution(int num1, int num2) {
		boolean[] isVisited = new boolean[MAX];
		Queue<Item> que = new LinkedList<Item>();
		que.add(new Item(num1, ""));
		isVisited[num1] = true;
		
		while (!que.isEmpty()) {
			Item curr = que.poll();
			
			if (curr.num == num2) {
				return curr.move;
			}
			
			// D 
			int now = (2*curr.num) % MAX;
			addItem(isVisited, que, curr, now, "D");
			
			// S 
			now = curr.num - 1 < 0? 9999 : curr.num -1;
			addItem(isVisited, que, curr, now, "S");
			
			// L
			now = ((curr.num%1000) * 10) + curr.num/1000;
			addItem(isVisited, que, curr, now, "L");
			
			// R 
			now = (curr.num/10) + (curr.num%10*1000);
			addItem(isVisited, que, curr, now, "R");
		}
		
		return "";
	}
	
	private static void addItem(boolean[] isVisited, Queue<Item> que, Item curr, int now, String move) {
		if (!isVisited[now]) {
			isVisited[now] = true;
			que.add(new Item(now, curr.move + move));
		}
	}
}
