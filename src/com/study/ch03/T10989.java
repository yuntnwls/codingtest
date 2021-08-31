package com.study.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T10989 {
	// 계수 정렬 알고리즘 (수의 범위가 제한되어있는 경우 사용)
	// 데이터 = 인덱스 
	// 데이터의 범위만큼 배열을 만들고 데이터와 동일한 인덱스의 값 증가 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] datas = new int[10001];
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			datas[Integer.parseInt(br.readLine())]++;
		}
		
		// sysout으로 계속 출력하면 시간초과 발생 
		// 한 번에 빠르게 출력하기위해 StringBuilder 사용 
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<datas.length; i++) {
			if (datas[i] > 0) {
				for (int j=0; j<datas[i]; j++) {
					sb.append(i).append("\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
