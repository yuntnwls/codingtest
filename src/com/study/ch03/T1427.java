package com.study.ch03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class T1427 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		String[] array = num.split("");
		Integer[] intArray = new Integer[num.length()];
		for (int i=0; i<num.length(); i++) {
			intArray[i] = Integer.parseInt(array[i]);
		}
		
		Arrays.sort(intArray, Collections.reverseOrder());
		
		for (int i=0; i<num.length(); i++) {
			System.out.print(intArray[i]);
		}
	}
}
