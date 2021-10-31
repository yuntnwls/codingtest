package com.study.etc;

// 회전 알고리즘 
public class Rotation {
	// https://bcp0109.tistory.com/150
	public static void main(String[] args) {
		int[][] arr = {
	        {1, 0, 0},
            {1, 1, 1},
            {1, 0, 1},
            {1, 0, 1}
        };

        print(arr);

        int[][] rotateArr;

        System.out.println("\n90");

        // 90 rotate
        rotateArr = rotate(arr, 90);
        print(rotateArr);

        System.out.println("\n180");

        // 180 rotate
        rotateArr = rotate(arr, 180);
        print(rotateArr);

        System.out.println("\n270");

        // 270 rotate
        rotateArr = rotate(arr, 270);
        print(rotateArr);

        System.out.println("\n360 (90 rotate)");

        // 90 rotate
        rotateArr = rotate(rotateArr);
        print(rotateArr);

        System.out.println("\n--------------------------");
        System.out.println("\n정사각형 배열");
        // 정사각형 배열 회전 
		int[][] arr0 = {
	        {1, 0, 0},
            {1, 1, 1},
            {1, 0, 1}
        };
        print(arr0);
        rotate0(arr0);
        System.out.println("\n90도 회전");
        print(arr0);
	}
	
	// NxN 배열에서의 90도 회전 
	private static void rotate0(int[][] matrix) {
		int n = matrix.length;
		
		// 가운데를 기준으로 맞은편 숫자들을 교환 
		for (int i=0; i<n/2; i++) {
			for (int j=0; j<n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-i-1][j];
				matrix[n-i-1][j] = temp;
			}
		}
		
		// 대각선을 기준으로 맞은편으로 교환 
		for (int i=0; i<n; i++) {
			for (int j=i; j <n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
	
	// 직사각형 배열 90도 회전 
	private static int[][] rotate(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		int[][] result = new int[m][n];
		
		for (int i=0; i<result.length; i++) {
			for (int j=0; j<result[i].length; j++) {
				result[i][j] = arr[n-1-j][i];
			}
		}
		
		return result;
	}
	
	// 90도 180도 270도 회전 
	private static int[][] rotate(int[][] arr, int degree) {
		int n = arr.length;
		int m = arr[0].length;
		
		int[][] result;
		switch (degree) {
		case 90:
		case 270:
			result = new int[m][n];
			break;
		case 180:
			result = new int[n][m];
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + degree);
		}
		
		for (int i=0; i<result.length; i++) {
			for (int j=0; j<result[i].length; j++) {
				switch (degree) {
				case 90:
					result[i][j] = arr[n-1-j][i];
					break;
				case 180:
					result[i][j] = arr[n-1-i][m-1-j];
					break;
				case 270:
					result[i][j] = arr[j][m-1-i];
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + degree);
				}
			}
		}
		
		return result;
	}
	
	private static void print(int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
