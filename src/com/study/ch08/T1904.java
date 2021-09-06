package com.study.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class T1904 {
	// 이미 구한 값은 저장해두고 다시 사용하므로 다시 구하지 않음 
	// 인접한 항들 사이의 관계식인 점화식을 새워야함 
	// 앞에서 구했던 값을 어떻게 조합해서 새로운 항을 구할 수 있나
	// d[i] = d[i-1] + d[i-2]
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] data = new int[1000001];
		data[1] = 1;
		data[2] = 2;
		
		for (int i=3; i<=n; i++) {
			data[i] = (data[i-1] + data[i-2]) % 15746;
		}
		System.out.println(data[n]);
	}
}
