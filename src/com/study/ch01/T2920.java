package com.study.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class T2920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		String[] split = line.split(" ");
		Integer[] datas = new Integer[split.length];
		Integer[] ascDatas = new Integer[split.length];
		Integer[] descDatas = new Integer[split.length];
		for (int i=0; i<split.length; i++) {
			datas[i] = Integer.parseInt(split[i]);
			ascDatas[i] = datas[i];
			descDatas[i] = datas[i];
		}
		
		// 오름차순 정렬 
		Arrays.sort(ascDatas);
		// 내림차순 정렬 
		Arrays.sort(descDatas, Collections.reverseOrder());
		
		if (Arrays.equals(datas, ascDatas)) {
			System.out.println("ascending");
		} else if (Arrays.equals(datas, descDatas)) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
}
