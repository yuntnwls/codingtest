package com.study.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1991
public class Tree {
	
	// 전위순회 : root->left->right
	// 중위순회 : left->root->right
	// 후위순회 : left->right->root 
	private static Node root;	// 초기 root 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String data = st.nextToken();
			String lData = st.nextToken();
			String rData = st.nextToken();
			createNode(data, lData, rData);
		}

		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
	}
	
	private static void createNode(String data, String leftData, String rightData) {
		if (root == null) {
			root = new Node(data);
			
			// 좌우 값이 있는 경우, 좌/우 값이 -1이 아닌 경우 
			if (!leftData.equals(".")) {
				root.left = new Node(leftData);
			}
			if (!rightData.equals(".")) {
				root.right = new Node(rightData);
			}
		} else {
			// 추가되는 노드들이 어느 위치에 추가될지 판별하기 위해 호출 
			searchNode(root, data, leftData, rightData);
		}
	}
	
	private static void searchNode(Node node, String data, String leftData, String rightData) {
		if (node == null) {
			return;
		} else if (node.data.equals(data)) {
			// 들어갈 위치를 찾았다면
			if (!leftData.equals(".")) {
				node.left = new Node(leftData);
			}
			if (!rightData.equals(".")) {
				node.right = new Node(rightData);
			}
		} else {
			// 아직 위치를 찾지못했고 탐색할 노드가 남은 경우 
			searchNode(node.left, data, leftData, rightData);	// 왼쪽 재귀 
			searchNode(node.right, data, leftData, rightData); 	// 오른쪽 재귀 
		}
	}
	
	// 전위 순회 
	private static void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			if (node.left != null)
				preOrder(node.left);
			if (node.right != null)
				preOrder(node.right);
		}
	}
	
	// 중위 순회 
	private static void inOrder(Node node) {
		if (node != null) {
			if (node.left != null)
				inOrder(node.left);
			System.out.print(node.data + " ");
			if (node.right != null)
				inOrder(node.right);
		}
	}
	
	// 후위 순회
	private static void postOrder(Node node) {
		if (node != null) {
			if (node.left != null)
				postOrder(node.left);
			if (node.right != null)
				postOrder(node.right);
			
			System.out.print(node.data + " ");
		}
	}
	
	static class Node {
		String data;
		Node left;
		Node right;
		
		public Node(String data) {
			this.data = data;
		}
	}
}
// https://minhamina.tistory.com/83