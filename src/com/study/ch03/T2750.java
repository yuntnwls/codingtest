package com.study.ch03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class T2750 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		for (int i=0; i<n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(array);
		for (int i=0; i<n; i++) {
			System.out.println(array[i]);
		}
	}
}
