package com.study.etc;

public class Snail {	
	
	// 달팽이 방향으로 배열 채우기 
	// 0,0 부터 시계방향 회전 
	public static void main(String[] args) {
		createSnailArray(5);
	}

	private static void createSnailArray(int n) {
		int[][] arr = new int[n][n];
		
		int num = 1; 	// 현재 채울 숫자 
		int right = -1;
		int bottom = 0;
		int dir = 1;	// 채울 방향의 반전 
		
		int len = n;
		for (int i=n; i>0; i--) {
			// 오른쪽(왼쪽) 방향으로 채우기 
			for (int j=0; j<len; j++) {
				right += dir;
				arr[bottom][right] = num;
				num++;
			}
			
			// 숫자가 채워질 길이 
			len--;
			
			// 아래(위) 방향으로 채우기 
			for (int j=0; j<len; j++) {
				bottom += dir;
				arr[bottom][right] = num;
				num++;
			}
			
			// 방향 전환 
			dir *= (-1);
		}
		
		print(arr);
	}

	private static void print(int[][] arr) {
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.print(String.format("%3d", arr[i][j]));
			}
			System.out.println();
		}
	}
}
// https://choykim.tistory.com/2