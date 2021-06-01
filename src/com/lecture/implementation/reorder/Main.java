package com.lecture.implementation.reorder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String answer = "";
		// 방법 1
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		
		int num = 0;
		String str = "";
		for (int i=0; i<arr.length; i++) {
			if (arr[i] > '9') {
				str += arr[i];
			} else {
				num += (arr[i]-'0');
			}
		}
		answer = str + num;

		// 방법 2
		answer = "";
		List<Character> result = new ArrayList<Character>();
		int value = 0;
		for (int i=0; i<s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {
				result.add(s.charAt(i));
			} else {
				value += s.charAt(i) - '0';
			}
		}
		Collections.sort(result);
		
		for (int i=0; i<result.size(); i++) {
			answer += result.get(i);
		}
		if (value != 0) {
			answer += Integer.toString(value);
		}
		
		System.out.println(answer);
	}
}
