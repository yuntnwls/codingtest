package com.backjoon.greedy.t1339;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] words = new String[n];
		for (int i=0; i<n; i++) {
			words[i] = sc.nextLine();
		}
		
		int answer = solution(n, words);
		System.out.println(answer);
	}

	private static int solution(int n, String[] words) {
		int answer = 0;
		// 단어를 풀어서 식으로 생각해보기 
		// ABC = 100A + 10B + C
		// BCD = 100B + 10C + D
		// => 110B + 100A + 11C + D
		// B->A->C->D 순서대로 큰 수를 설정 
		
		// 알파벳에 곱해야할 값들을 넣을 배열
		int[] alphabet = new int[26];
		for (int i=0; i<n; i++) {
			char[] charArr = words[i].toCharArray();
			int pos = (int) Math.pow(10, words[i].length()-1);
			for (int j=0; j<charArr.length; j++) {
				alphabet[charArr[j] - 'A'] += pos;
				pos /= 10;
			}
		}
		// 알파벳 배열을 정렬(오름차순)
		// int 배열이므로 reverse는 불가능 -> Integer배열로 변경시 가능 
		Arrays.sort(alphabet);
		// 9부터 시작해서 하나씩 작은 수를 곱해서 큰 수를 만들기 
		int num = 9;
		for (int i=alphabet.length-1; i>=0; i--) {
			answer += num*alphabet[i];
			num--;
			if (num == 0 || alphabet[i] == 0) {
				break;
			}
		}
		
		return answer;
	}
}

//https://mygumi.tistory.com/156
