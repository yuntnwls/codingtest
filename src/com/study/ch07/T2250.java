package com.study.ch07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class T2250 {
	
	private static Map<Integer, Node> map = new HashMap<>();
	private static int currentCol = 1;
	private static List<Integer> levelMinCol;
	private static List<Integer> levelMaxCol;
	private static int maxLevel = 1;
	
	static class Node {
		int parent = -1;
		int data;
		int left;
		int right;
		public Node(int data, int left, int right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		levelMinCol = new ArrayList<>();
		levelMaxCol = new ArrayList<>();
		levelMinCol.add(0);
		levelMaxCol.add(0);
		for (int i=1; i<=n; i++) {
			levelMinCol.add(n);
			levelMaxCol.add(0);
			map.put(i, new Node(i, -1, -1));
		}
		
		StringTokenizer st = null;
		int data = -1;
		int left = -1;
		int right = -1;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			data = Integer.parseInt(st.nextToken());
			left = Integer.parseInt(st.nextToken());
			right =Integer.parseInt(st.nextToken());
			
			map.get(data).left = left;
			map.get(data).right = right;
			if (left != -1) {
				map.get(left).parent = data;
			}
			if (right != -1) {
				map.get(right).parent = data;
			}
		}
		
		int root = -1;
		for (int i=1; i<=n; i++) {
			if (map.get(i).parent == -1) {
				root = i;
				break;
			}
		}
		
		// 행과 열에 배치 
		preOrder(map.get(root), 1);
		
		int maxWidth = 0;
		int minLevel = 0;
		int width = 0;
		for (int i=1; i<=maxLevel; i++) {
			width = levelMaxCol.get(i) - levelMinCol.get(i) + 1;
			if (maxWidth < width) {
				maxWidth = width;
				minLevel = i;
			}
		}
		System.out.println(minLevel + " " + maxWidth);
	}

	private static void preOrder(Node node, int depth) {
		// left
		if (node.left != -1) {
			preOrder(map.get(node.left), depth+1);
		}
		// data
		int minCol = Math.min(levelMinCol.get(depth), currentCol);
		int maxCol = Math.max(levelMaxCol.get(depth), currentCol);
		levelMinCol.set(depth, minCol);
		levelMaxCol.set(depth, maxCol);
		currentCol++;
		maxLevel = Math.max(maxLevel, depth);
		// right
		if (node.right != -1) {
			preOrder(map.get(node.right), depth+1);
		}
	}
}
