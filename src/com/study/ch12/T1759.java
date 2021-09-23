package com.study.ch12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class T1759 {
	
	private static char[] input = null;
	private static char[] vowArr = {'a', 'e', 'i', 'o', 'u'};
	private static final int VOW_MIN_COUNT = 1;	// 모음 최소 개수 
	private static final int CON_MIN_COUNT = 2; // 자음 최소 개수 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		String line = br.readLine().replace(" ", "");
		input = line.toCharArray();
		
		solution(L, C);
	}

	private static void solution(int l, int c) {
		Arrays.sort(input);
		
		boolean[] isVisited = new boolean[c];
		// 모든 조합 구하기 
		combination(isVisited, 0, l);
	}

	private static void combination(boolean[] isVisited, int start, int len) {
		if (len == 0) {
			printPassword(isVisited);
			return;
		} else {
			for (int i=start; i<input.length; i++) {
				isVisited[i] = true;
				combination(isVisited, i+1, len-1);
				isVisited[i] = false;
			}
		}
	}

	private static void printPassword(boolean[] isVisited) {
		StringBuffer sb = new StringBuffer();
		int vowCnt = 0;
		for (int i=0; i<isVisited.length; i++) {
			if (isVisited[i]) {
				if (isVow(input[i])) {
					vowCnt++;
				}
				sb.append(input[i]);
			}
		}
		// 만들어진 문자열에서 모음/자음의 수로 걸러내기 
		if (vowCnt >= VOW_MIN_COUNT && (sb.toString().length() - vowCnt) >= CON_MIN_COUNT) {
			System.out.println(sb.toString());
		}
	}
	
	private static boolean isVow(char data) {
		for (int i=0; i<vowArr.length; i++) {
			if (data == vowArr[i]) {
				return true;
			}
		}
		return false;
		
	}
}
