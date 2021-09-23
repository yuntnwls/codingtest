package com.backjoon.backtracking.t2529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	private static String[] input;
	private static long min = Long.MAX_VALUE;
	private static long max = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		String line = br.readLine();
		input = line.split(" ");
		
		solution();
	}

	private static void solution() {
		boolean[] isVisited = new boolean[10];
		int[] result = new int[10];
		
		combination(isVisited, 0, result);
		
		String format = "%0" + (input.length+1) + "d";
		System.out.println(String.format(format, max));
		System.out.println(String.format(format, min));
	}

	// 순서있는 조합 만들기 
	private static void combination(boolean[] isVisited, int depth, int[] result) {
		if (depth == input.length+1) {
			checkAnswer(result);
		} else {
			for (int i=0; i<=9; i++) {
				if (!isVisited[i]) {
					isVisited[i] = true;
					result[depth] = i;
					combination(isVisited, depth+1, result);
					isVisited[i] = false;
				}
			}
		}
	}

	private static void checkAnswer(int[] result) {
		StringBuffer sb = new StringBuffer();
		sb.append(result[0]);
		for (int i=1; i<=input.length; i++) {
			if (isValid(result[i-1], result[i], input[i-1])) {
				sb.append(result[i]);
			} else {
				return;
			}
		}
		long value = Long.parseLong(sb.toString());
		min = Math.min(min, value);
		max = Math.max(max, value);
	}
	
	private static boolean isValid(int left, int right, String oper) {
		if (oper.equals("<")) {
			if (left < right) {
				return true;
			}
		} else if (oper.equals(">")) {
			if (left > right) {
				return true;
			}
		}
		return false;
	}
}
