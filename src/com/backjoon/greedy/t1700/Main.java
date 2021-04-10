package com.backjoon.greedy.t1700;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int tool[] = new int[k];
		for (int i=0; i<k; i++) {
			tool[i] = sc.nextInt();
		}
		
		int result = solution(n, k, tool); 
		System.out.println(result);
	}

	private static int solution(int n, int k, int[] tool) {
		int result = 0;
		int[] used = new int[n];
		for (int i=0; i<n; i++) {
			used[i] = -1;
		}
		
		boolean isUsed = false;
		for (int i=0; i<k; i++) {
			isUsed = false;
			// 해당 기기가 꽂혀있는지 확인 
			for (int j=0; j<n; j++) {
				if (tool[i] == used[j]) {
					isUsed = true;
					break;
				}
			}
			if (isUsed) {
				continue;
			}
			
			// 빈곳이 있는 경우 꽂기 
			for (int j=0; j<n; j++) {
				if (used[j] < 0) {
					used[j] = tool[i];
					isUsed = true;
					break;
				}
			}
			if (isUsed) {
				continue;
			}
			
			// 어떤 콘센트를 빼야하는지 확인 
			// 이후 단한번도 쓰이지 않을 기기를 빼거나 더 마지막에 쓰이는 기기를 뺴기
			int lastIdx = -1;
			int maxIdx = 0;
			int deviceIdx = -1;
			for (int j=0; j<n; j++) {
				boolean isNeverUsed = true;
				for (int t=i+1; t<k; t++) {
					if (used[j] == tool[t]) {
						isNeverUsed = false;
						lastIdx = t;
						break;
					}
				}
				if (isNeverUsed) {
					deviceIdx = j;
					break;
				}
				if (maxIdx < lastIdx) {
					maxIdx = lastIdx;
					deviceIdx = j;
				}
			}
			
			used[deviceIdx] = tool[i];
			result++;
		}
		return result;
	}
}
