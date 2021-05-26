package com.backjoon.greedy.t1493;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int length = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int heigth = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		
		int[] cubes = new int[n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			
			cubes[index] = Integer.parseInt(st.nextToken());
		}
		
		long answer = solution(length, width, heigth, n, cubes);
		System.out.println(answer);
	}

	private static long solution(int length, int width, int heigth, int n, int[] cubes) {
		long answer = 0;
		long temp = 0;
		
		for (int i=n-1; i>=0; i--) {
			temp <<= 3;
			
			long possibleCube = (long)(length>>i) * (width>>i) * (heigth>>i) - temp;
			long newCube = Math.min((long)cubes[i], possibleCube);
			
			temp += newCube;
			answer += newCube;
		}
		
		if (temp != (long)length*width*heigth) {
			answer = -1;
		}
		return answer;
	}
}
//https://steady-coding.tistory.com/14