package com.study.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Prime {
	
	// 에라토스테네스의 체(소수 구하는 알고리즘)
	// 소수가 되는 수의 배수를 지우면 남은 건 소수가 된다 
	
	// ex) 120까지의 소수 구하기 
	public static boolean prime[] = new boolean[121];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
//		printPrime(n);
		
		if (isPrime(n)) {
			System.out.println("Prime = true");
		} else {
			System.out.println("Prime = false");
		}
		
	}
		
	// n까지 모든 소수 출력 
	public static void printPrime(int N) {
		List<Integer> primeList = new ArrayList<>();
		
		// 소수는 false
		// 1은 소수가 아니므로 제외 
		prime[0] = prime[1] = true;
		
		for (int i=1; i*i<=N; i++) {
			// prime[i]가 소수라면 
			if (!prime[i]) {
				// prime[j] 소수가 아닌 표시 
				for (int j=i*i; j<=N; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		// 소수 출력 
		for (int i=0; i<=N; i++) {
			if (!prime[i]) {
				System.out.print(i + " ");
				primeList.add(i);
			}
		}
	}
	
	// n이 소수인지 판단 
	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		if (n%2 == 0) {
			return false;
		}
		
		boolean isPrime = true;
		for (int i=3; i<(int)Math.sqrt(n); i+= 2) {
			if (n%i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
