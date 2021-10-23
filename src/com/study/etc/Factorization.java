package com.study.etc;

public class Factorization {
	// 소인수 : 약수들 중 소수인 수 
	
	public static void main(String[] args) {
//		int[] A = eraFactorCount(100);
//		int[] A = eraFactorSum(100);
		int[] A = eraFactoriztion(100);
//		for (int i=0; i<A.length; i++) {
//			System.out.print(A[i] + " ");
//		}
		
		// 소인수분해ㅠ 하는 방법 
		int N = 84;
		while (A[N] != 0) {
			System.out.println(A[N]);
			N /= A[N];
		}
	}
	
	// 소인수의 개수 
	private static int[] eraFactorCount(int N) {
		int[] A = new int[N+1];
		for (int i=1; i<N; i++) {
			for (int j=i; j<N; j+=i) {
				A[j] += 1; // 자신의 배수 개수만큼 더하기  
			}
		}
		return A;
	}
	
	// 소인수의 합 
	private static int[] eraFactorSum(int N) {
		int[] A = new int[N+1];
		for (int i=1; i<N; i++) {
			for (int j=i; j<N; j+=i) {
				A[j] += i;
			}
		}
		return A;
	}
	
	// 소인수분해를 하기위한 배열 만들기 
	private static int[] eraFactoriztion(int N) {
		// 자신을 나누는 가장 큰 소수를 배열에 저장 
		int[] A = new int[N+1];
		for (int i=2; i<N; i++) {
			if (A[i] > 0)
				continue;
			for (int j=i; j<N; j+=i) {
				A[j] = i;	
			}
		}
		return A;
	}
}
