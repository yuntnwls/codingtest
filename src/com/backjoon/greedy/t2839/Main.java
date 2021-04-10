package com.backjoon.greedy.t2839;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sugar = sc.nextInt();
		
		int result = solution(sugar);
		System.out.println(result);
	}
	
	public static int solution(int sugar) {
		int result = 0;
		
		// 5로 나누어 떨어질떄까지 3kg봉지에 담기
		while (true) {
			if (sugar % 5 == 0) {
				result += sugar/5;
				break;
			} else if (sugar <= 0) {
				result = -1;
				break;
			}
			sugar -= 3;
			result++;
		}
		
		return result;
	}
}
