package com.study.ch06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class T1668 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		
		int max = 0;
		int count = 0;
		for (int i=0; i<n; i++) {
			array[i] = Integer.parseInt(br.readLine());
			if (max < array[i]) {
				max = array[i];
				count++;
			}
		}
		System.out.println(count);
		
		max = 0;
		count = 0;
		for (int i=n-1; i>=0; i--) {
			if (max < array[i]) {
				max = array[i];
				count++;
			}
		}
		System.out.println(count);
	}
}
