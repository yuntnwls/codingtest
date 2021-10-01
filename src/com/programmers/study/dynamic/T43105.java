package com.programmers.study.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://programmers.co.kr/learn/courses/30/lessons/43105?language=java
public class T43105 {
	private static int[] dx = {0, 1, 1, 0};
	private static int[] dy = {-1, -1, 1, 1};
	private static int max = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n][];
		for (int i=1; i<=n; i++) {
			int[] temp = new int[i];
			String line = br.readLine().replaceAll(" ", "");
			String[] split = line.split(",");
			for (int j=0; j<i; j++) {
				temp[j] = Integer.parseInt(split[j]);
			}
			triangle[i-1] = temp;	
		}
		
		int answer = solution(triangle);
		System.out.println(answer);
	}

	private static int solution(int[][] triangle) {
		int answer = 0;
		for (int i=1; i<triangle.length; i++) {
			for (int j=0; j<=i; j++) {
				if (j == 0) {
					// 가장 왼쪽 요소는 바로 위의 요소에서만 이동 가능 
					triangle[i][j] += triangle[i-1][j];
				} else if (j==i) {
					// 가장 오른쪽 요소는 바로 위의 요소에서만 이동 가능 
					triangle[i][j] += triangle[i-1][j-1];
				} else {
					// 가운데 요소들은 해당요소로 이동가능한 요소 중 최대값을 가진 요소로 이동 
					triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
				}
			}
		}
		
		for (int i=0; i<triangle.length; i++) {
			answer = Math.max(triangle[triangle.length-1][i], answer);
		}
		return answer;
	}
}
