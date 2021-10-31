package com.study.etc;

public class Permutation {
	// 순열(Permutaion)
	// {1,2} != {2,1}
	// 순서를 지키면서 n개중 r개를 뽑는 경우 
	public static void main(String[] args) {
		int n = 3;
		int[] arr = {1,2,3};
		int[] output = new int[n];
		boolean[] visited = new boolean[n];
		
		perm(arr, output, visited, 0, n, 3);
		
	}
	
	// 사전순으로 순열 구하기(n개중 r개 뽑기)
	private static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if (depth == r) {
			print(output, r);
			return;
		}
		
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, output, visited, depth+1, n, r);
				visited[i] = false;
			}
		}
	}

	private static void print(int[] output, int r) {
		for (int i=0; i<r; i++) {
			System.out.print(output[i] + " ");
		}
		System.out.println();
	}
}
// https://bcp0109.tistory.com/14
// https://swycha.tistory.com/133
