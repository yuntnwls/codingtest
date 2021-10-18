package com.backjoon.greedy.t1439;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1439
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] split = line.split("");
		int[] array = new int[split.length];
		for (int i=0; i<split.length; i++) {
			array[i] = Integer.parseInt(split[i]);
		}
		
		int answer = solution(array);
		System.out.println(answer);
	}

	private static int solution(int[] array) {
		// 0, 1 : 0 => 0(바뀌는 구간의 수)
		// 01, 10 : 1 => 1
		// 101, 010 : 1 => 1
		// 1010 : 2 => 3
		// 10101 : 2 => 4
		// 101010 : 3 => 5
		// (다른 숫자로 바뀌는 구간+1)/2
		
		int count = 0;
		for (int i=1; i<array.length; i++) {
			if (array[i-1] != array[i]) {
				count++;
			}
		}
		
		return (count+1)/2;
	}

//	private static int solution(int[] array) {
//		int count0 = 0; // 모두 0으로 바꾸는 경우 
//		int count1 = 0; // 모두 1로 바꾸는 경우 
//		
//		int preNum = array[0];
//		if (preNum == 0) {
//			count1++;
//		} else {
//			count0++;
//		}
//		
//		// 바꿀 숫자가 시작하는 구간에서 count++
//		for (int i=1; i<array.length; i++) {
//			if (array[i-1] != array[i]) {
//				if (array[i] == 0) {
//					count1++;
//				} else {
//					count0++;
//				}
//			}
//		}
//		
//		return Math.min(count1, count0);
//	}
}
