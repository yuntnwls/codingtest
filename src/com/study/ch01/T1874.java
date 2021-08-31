package com.study.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		for (int i=0; i<n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		List<String> resultList = new ArrayList<>();
		Stack<Integer> stack = new Stack<Integer>();
		int index = 0;
		for (int i=1; i<=n; i++) {
			stack.push(i);
			resultList.add("+");
			while (!stack.isEmpty()) {
				if (stack.peek() == array[index]) {
					stack.pop();
					index++;
					resultList.add("-");
				} else {
					break;
				}
			}
		}
		
		if (!stack.isEmpty()) {
			System.out.println("NO");
		} else {
			for (int i=0; i<resultList.size(); i++) {
				System.out.println(resultList.get(i));
			}
		}
	}
}
