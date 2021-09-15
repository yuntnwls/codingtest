package com.study.ch11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class T1439 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] split = s.split("");
		
		int count0 = 0;	// 전부 0으로 바꾸는 경우 
		int count1 = 0;	// 전부 1로 바꾸는 경우 
		
		if (split[0].equals("1")) {
			count0++;
		} else {
			count1++;
		}
		
		for (int i=1; i<split.length; i++) {
			if (!split[i-1].equals(split[i])) {
				if (split[i].equals("1")) {
					count0++;
				} else {
					count1++;
				}
			}
		}

		int answer = Math.min(count0, count1);
		System.out.println(answer);
	}
}
