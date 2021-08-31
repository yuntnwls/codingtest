package com.study.ch06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T1302 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		String bookTitle = "";
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		for (int i=0; i<n; i++) {
			bookTitle = br.readLine();
			map.put(bookTitle, map.getOrDefault(bookTitle, 1)+1);
			max = Math.max(max, map.get(bookTitle));
		}
		
		List<String> answerList = new ArrayList<String>();

		for (String key : map.keySet()) {
			if (map.get(key) == max) {
				answerList.add(key);
			}
		}
		
		Collections.sort(answerList);
		System.out.println(answerList.get(0));
	}
}
