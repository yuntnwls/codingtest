package com.study.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class T9251 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data1 = br.readLine();
		String data2 = br.readLine();
		
		char[] arrayA = new char[data1.length()+1];
		char[] arrayB = new char[data2.length()+1];
		for (int i=0; i<data1.length(); i++) {
			arrayA[i+1] = data1.charAt(i);
		}
		for (int i=0; i<data2.length(); i++) {
			arrayB[i+1] = data2.charAt(i);
		}
		
		int[][] answer = new int[arrayA.length][arrayB.length];
		int max = 0;
		for (int i=1; i<=data1.length(); i++) {
			for (int j=1; j<=data2.length(); j++) {
				if (arrayA[i] == arrayB[j]) {
					answer[i][j] = answer[i-1][j-1] + 1;
					max = Math.max(answer[i][j], max);
				} else {
					answer[i][j] = Math.max(answer[i-1][j], answer[i][j-1]);
				}
			}
		}
		System.out.println(max);
	}
}
