package com.study.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T2920Answer {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		String[] split = line.split(" ");
		Integer[] datas = new Integer[split.length];
		for (int i=0; i<split.length; i++) {
			datas[i] = Integer.parseInt(split[i]);
		}
		
		boolean isAsc = true;
		boolean isDesc = true;
		for (int i=0; i<datas.length-1; i++) {
			if (datas[i] < datas[i+1]) {
				isDesc = false;
			} else if (datas[i] > datas[i+1]) {
				isAsc = false;
			}
		}
		
		if (isAsc) {
			System.out.println("ascending");
		} else if (isDesc) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
}
