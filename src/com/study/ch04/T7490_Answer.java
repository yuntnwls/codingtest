package com.study.ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class T7490_Answer {

	// 들어가는 값의 범위가 한정적이므로 모든 경우를 계산 가능 
	// 수 리스트, 연산자 리스트를 따로 관리 
	private static List<String> dataList = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i=0; i<t; i++) {
			dataList.clear();
			int n = Integer.parseInt(br.readLine());
			
			solution(n, 2, "1");
			
			printAnswerList();
			System.out.println();
		}
	}

	private static void solution(int n, int now, String operator) {
		if (now > n) {
			dataList.add(operator);
			return;
		}
		operator += " ";
		operator += now;
		solution(n, now + 1, operator);
		operator = operator.substring(0, operator.length()-2);
		
		operator += "+";
		operator += now;
		solution(n, now + 1, operator);
		operator = operator.substring(0, operator.length()-2);
		
		operator += "-";
		operator += now;
		solution(n, now + 1, operator);
		operator = operator.substring(0, operator.length()-2);
	}
	
	private static void printAnswerList() {
		int sum = 0;
		String data = "";
		String[] calStr = null;
		String[] calFormual = null;
		int index = 0;
		for (int i=0; i<dataList.size(); i++) {
			index = 0;
			data = dataList.get(i).replaceAll(" ", "");
			calStr = data.split("\\+|\\-");
			calFormual = new String[calStr.length-1];
			for (char ch : data.toCharArray()) {
				if (ch == '+') {
					calFormual[index++] = "+";
				} else if (ch == '-') {
					calFormual[index++] = "-";
				}
			}
			sum = Integer.parseInt(calStr[0]);
			for (int j=1; j<calStr.length; j++) {
				if (calFormual[j-1].equals("+")) {
					sum += Integer.parseInt(calStr[j]);
				} else if (calFormual[j-1].equals("-")) {
					sum -= Integer.parseInt(calStr[j]);
				}
			}

			if (sum == 0) {
				System.out.println(dataList.get(i));
			}
		}
	}
}
