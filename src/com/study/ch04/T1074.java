package com.study.ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T1074 {
	
	private static int r;
	private static int c;
	private static int result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		solution((int)Math.pow(2, n), 0, 0);
	}

	private static void solution(int n, int x, int y) {
		// 가장 최소 단위의 z이동 
		if (n == 2) {
			if (x == r && y == c) {
				System.out.println(result);
				return;
			}
			result++;
			if (x == r && y+1 == c) {
				System.out.println(result);
				return;
			}
			result++;
			if (x+1 == r && y == c) {
				System.out.println(result);
				return;
			}
			result++;
			if (x+1 == r && y+1 == c) {
				System.out.println(result);
				return;
			}
			result++;
			return;
		}
		solution(n/2, x, y);
		solution(n/2, x, y+n/2);
		solution(n/2, x+n/2, y);
		solution(n/2, x+n/2, y+n/2);
	}
}
