package com.programmers.lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://programmers.co.kr/learn/courses/30/lessons/60058?language=java
public class T60058 {
	private static StringBuilder sb = null;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String p = br.readLine();
		
		String answer = solution(p);
		System.out.println(answer);
	}

	private static String solution(String p) {
		sb = new StringBuilder();
		
		if (p.equals(""))
			return "";
		return getValidString(p);
	}
	
	private static String getValidString(String p) {
		int index = splitString(p);
		String u = p.substring(0, index);
		String v = p.substring(index);
		
		if (isValidateString(u)) {
			sb.append(u);
		} else {
			sb.append("(");
			if (!v.equals("")) {
				getValidString(v);
				v = "";
			}
			sb.append(")");
			sb.append(convertValidString(u));
		}
		if (!v.equals("")) {
			getValidString(v);
		}
		
		return sb.toString();
	}
	
	// 문자열을 u, v로 나누기위해 자를 위치 선정 
	private static int splitString(String p) {
		String[] split = p.split("");
		int count = 0;	// '('이 나오면 ++ / ')'이 나오면 -- 
		int index = 0;
		for (int i=0; i<split.length; i++) {
			if (split[i].equals("("))
				count++;
			else 
				count--;
			
			// 균형잡힌 문자열이라면 반환 
			if (count == 0) {
				index = i+1;
				break;
			}
		}
		return index;
	}
	
	// 올바른 문자열인지 확인 
	private static boolean isValidateString(String p) {
		String[] split = p.split("");
		int count = 0;	// 올바른 문자열이라면 '(' 와 ')'가 쌍으로 오므로 count가 음수가 될 수 없음 
		for (String str : split) {
			if (str.equals("("))
				count++;
			else
				count--;
			
			if (count < 0) 
				return false;
		}
		return true;
	}
	
	// 올바른 문자열로 바꿔주는 함수 
	private static String convertValidString(String p) {
		String[] split = p.split("");
		StringBuilder sb = new StringBuilder();
		// 첫문자와 끝문자를 지우므로 인덱스는 1~length-2까지
		for (int i=1; i<split.length-1; i++) {
			if (split[i].equals("("))
				sb.append(")");
			else
				sb.append("(");
		}
		return sb.toString();
	}
	
}
// https://velog.io/@tmdgusya/프로그래머스-괄호변환Java
// https://github.com/tmdgusya/AlgoStudy/blob/master/src/Programmers/괄호변환.java