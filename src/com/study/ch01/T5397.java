package com.study.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class T5397 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String answer = "";
		for (int i=0; i<n; i++) {
			answer = solution(br.readLine());
			System.out.println(answer);
		}
	}
	
	private static String solution(String keyLocker) {
		int index = 0;
		String[] split = keyLocker.split("");
		List<String> result = new ArrayList<>();
		for (int i=0; i<split.length; i++) {
			if (split[i].equals("<")) {
				if (index > 0) {
					index--;
				}
			} else if (split[i].equals(">")) {
				if (index < result.size()) {
					index++;
				}
			} else if (split[i].equals("-")) {
				if (index > 0) {
					result.remove(index-1);
					index--;
				}
			} else {
				result.add(index, split[i]);
				index++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<result.size(); i++) {
			sb.append(result.get(i));
		}
		
		return sb.toString();
	}
}
