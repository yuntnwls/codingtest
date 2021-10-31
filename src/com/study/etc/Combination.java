package com.study.etc;

public class Combination {
	// 조합
	// 순서없이 n개 중 r개를 뽑는 경우 
	public static void main(String[] args) {
		int n = 4;
		int[] arr = {1,2,3,4};
		boolean[] visited = new boolean[n];
		
		for (int i=1; i<=n; i++) {
			System.out.println(String.format("\n%d개 중에서 %d개 뽑기(재귀)", n, i));
			comb1(arr, visited, 0, n, i);
		}
		for (int i=1; i<=n; i++) {
			System.out.println(String.format("\n%d개 중에서 %d개 뽑기(백트래킹)", n, i));
			comb2(arr, visited, 0, n, i);
		}
	}

	// 재귀 사용 
	private static void comb1(int[] arr, boolean[] visited, int depth, int n, int r) {
		if (r == 0) {
			print(arr, visited, n);
			return;
		}
		if (depth == n) {
			return;
		}
		// 현재 인덱스를 뽑는다면 
		visited[depth] = true;
		comb1(arr, visited, depth+1, n, r-1);
		
		// 현재 인덱스를 뽑지 않는다면 
		visited[depth] = false;
		comb1(arr, visited, depth+1, n, r);
	}

	// 백트래킹 사용 
	private static void comb2(int[] arr, boolean[] visited, int start, int n, int r) {
		if (r == 0) {
			print(arr, visited, n);
			return;
		}
		
		for (int i=start; i<n; i++) {
			visited[i] = true;
			comb2(arr, visited, i+1, n, r-1);
			visited[i] = false;
		}
	}

	private static void print(int[] arr, boolean[] visited, int n) {
		for (int i=0; i<n; i++) {
			if (visited[i]) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}
}
// https://bcp0109.tistory.com/15?category=848939
// https://minhamina.tistory.com/38