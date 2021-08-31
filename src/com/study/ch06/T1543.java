package com.study.ch06;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class T1543 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = br.readLine();
		String word = br.readLine();
		
		int count = 0;
		int startIndex = 0;
		while (true) {
			int index = data.indexOf(word, startIndex);
			if (index == -1) {
				break;
			}
			count++;
			startIndex = (index + word.length());
		}
		
		System.out.println(count);
	}
}
