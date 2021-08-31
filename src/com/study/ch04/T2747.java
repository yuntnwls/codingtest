package com.study.ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class T2747 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int a = 0;
		int b = 1;
		while (n>0) {
			int temp = a;
			a = b;
			b = temp + b;
			n--;
		}
		
		System.out.println(a);
	}
}
