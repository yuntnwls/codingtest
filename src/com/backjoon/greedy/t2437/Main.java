package com.backjoon.greedy.t2437;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		for (int i=0; i<n; i++) {
			num[i] = Integer.parseInt(sc.next());
		}
		
		int answer = solution(n, num);
		System.out.println(answer);
	}

	private static int solution(int n, int[] num) {
		int answer = 0;
		// 오름차순으로 정
		Arrays.sort(num);
		
		// 가장 작은 추의 수가 가장 작은 양의 정수인 1보다 큰 경우 1을 바로 리턴 
		if (num[0] != 1) {
			return 1;
		}
		
		// sum+1보다 큰 무게의 추가 생기는지 확인 
		int sum = num[0];
		for (int i=1; i<n; i++) {
			if (num[i] > sum + 1) {
				answer = sum + 1;
				break;
			} else {
				sum += num[i];
			}
		}
		answer = sum + 1;
		return answer;
	}
}