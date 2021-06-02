package com.lecture.sorting.change;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int[] b = new int[n];
		for (int i=0; i<n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
	
		// 라이브러리에서 제공하는 정렬은 대부분 퀵정렬 
		// 시간 복잡도가 O(NlogN)
		// 선택 정렬, 삽입정렬 등을 직접 구현하는 것보다 제공해주는 라이브러리 함수를 사용하는게 더 빠름 
		Arrays.sort(a);
		Arrays.sort(b);
	
		int idx = 0;
		for (int i=0; i<k; i++) {	
			if (a[idx] < b[n-1-idx]) {
				int temp = a[idx]; 
				a[idx] = b[n-1-idx];
				b[n-1-idx] = temp;
				
				idx++;
			} else {
				break;
			}
		}
		
		int answer = 0;
		for (int i=0; i<n; i++) {
			answer += a[i];
		}
		
		System.out.println(answer);
	}
}
