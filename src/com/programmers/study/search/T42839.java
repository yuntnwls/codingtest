package com.programmers.study.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/42839?language=java
public class T42839 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numbers = br.readLine();
		
		int answer = solution(numbers);
		System.out.println(answer);
	}
	
	private static int solution(String numbers) {
		List<Integer> numList = new ArrayList<>();
		String[] numberArr = numbers.split("");
		
		String result = "";
		boolean[] isVisited = new boolean[numbers.length()];
		for (int i=1; i<=numbers.length(); i++) {
			Arrays.fill(isVisited, false);
			result = "";
			combination(isVisited, numList, numberArr, i, result);
		}
		
		return numList.size();
	}
	
	private static void combination(boolean[] isVisited, List<Integer> numList, String[] numberArr, int len, String result) {
		if (result.length() == len) {
			addNumber(result, numList);
		} else {
			for (int i=0; i<numberArr.length; i++) {
				if (isVisited[i]) {
					continue;
				}
				result += numberArr[i];
				isVisited[i] = true;
				combination(isVisited, numList, numberArr, len, result);
				isVisited[i] = false;
				result = result.substring(0, result.length()-1);
			}
		}
	}

	private static void addNumber(String result, List<Integer> numList) {
		int num = Integer.parseInt(result);
		if (!numList.contains(num)) {
			if (isPrime(num)) {
				numList.add(num);
				System.out.println(num);
			}
		}
	}

	private static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i=2; i<=num/2; i++) {
			if (num%i == 0) {
				return false;
			}
		}
		return true;
	}
}
