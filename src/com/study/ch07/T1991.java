package com.study.ch07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class T1991 {
	
	private static Map<String, Node> map = new HashMap<>(); 	
	static class Node {
		String data;
		String left;
		String right;
		public Node(String data, String left, String right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String data = st.nextToken();
			map.put(data, new Node(data, st.nextToken(), st.nextToken()));
		}
		
		// 전위 순회 
		preOrder(map.get("A"));
		System.out.println();
		
		// 중위 순회 
		inOrder(map.get("A"));
		System.out.println();
		
		// 후위 순회 
		postOrder(map.get("A"));
	}

	private static void postOrder(Node node) {
		if (!node.left.equals(".")) {
			postOrder(map.get(node.left));
		}
		if (!node.right.equals(".")) {
			postOrder(map.get(node.right));
		}
		System.out.print(node.data);
	}

	private static void inOrder(Node node) {
		if (!node.left.equals(".")) {
			inOrder(map.get(node.left));
		}
		System.out.print(node.data);
		if (!node.right.equals(".")) {
			inOrder(map.get(node.right));
		}
	}

	private static void preOrder(Node node) {
		System.out.print(node.data);
		if (!node.left.equals(".")) {
			preOrder(map.get(node.left));
		}
		if (!node.right.equals(".")) {
			preOrder(map.get(node.right));
		}
	}
}
