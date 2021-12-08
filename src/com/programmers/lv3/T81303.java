package com.programmers.lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/81303
public class T81303 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		String line = br.readLine().replaceAll("\"", "");
		String[] cmd = line.split(",");
		
		String answer = solution(n, k, cmd);
		System.out.println(answer);
	}

	private static String solution(int n, int k, String[] cmd) {
		Stack<Integer> histroy = new Stack<>();
		int tableSize = n;
		int focus = k;
		for (String temp : cmd) {
			String[] split = temp.split(" ");
			if (split[0].equals("D")) {
				focus += Integer.parseInt(split[1]);
			} else if (split[0].equals("U")) {
				focus -= Integer.parseInt(split[1]);
			} else if (split[0].equals("C")) {
				histroy.add(focus);
				tableSize--;
				if (focus == tableSize) {
					focus--;
				}
			} else if (split[0].equals("Z")) {
				if (histroy.pop() <= focus) {
					focus++;
				}
				tableSize++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<tableSize; i++) {
			sb.append("O");
		}
		while (!histroy.isEmpty()) {
			sb.insert(histroy.pop().intValue(), "X");
		}
		return sb.toString();
	}
}
