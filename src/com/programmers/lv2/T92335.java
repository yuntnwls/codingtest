package com.programmers.lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://programmers.co.kr/learn/courses/30/lessons/92335
public class T92335 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int answer = solution(n, k);
		System.out.println(answer);
	}
	
	public static int solution(int n, int k) {
        int answer = 0;
		String numStr = convertNumber(n, k);
		int i,j;
		for (i=0; i<numStr.length(); i=j) {
			// 마지막 단어거나 0을 만나는 경우까지 자르기 
			for (j=i+1; j<numStr.length() && numStr.charAt(j) != '0'; j++);
			if (isPrime(Long.parseLong(numStr.substring(i, j))))
				answer++;
		}
        return answer;
    }
	
	private static String convertNumber(int n, int k) {
		// 진수 구하기 
		String res = "";
        while(n > 0) {
            res = n % k + res;
            n /= k;
        }
        return res;
	}
	
	private static boolean isPrime(long n) {
		if (n <= 1)	
			return false;
		else if (n == 2) 
			return true;
		
		for (int i=2; i<=Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
