package com.programmers.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class T42883 {
	
//	private static long max = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();	// 숫자로 이루어진 문자열 
		int k = Integer.parseInt(br.readLine());// 제거할 숫자 개수 
		
		String answer = solution(number, k);
		System.out.println(answer);
	}

	private static String solution(String number, int k) {
		StringBuffer answer = new StringBuffer();
		int idx = 0;
		char max;
		
		for (int i=0; i<number.length()-k; i++) {
			max = '0';
			for (int j=idx; j<=k+i; j++) {
				if (max < number.charAt(j)) {
					max = number.charAt(j);
					idx = j+1;
				}
			}
			answer.append(max);
		}
		
		return answer.toString();
	}
}
