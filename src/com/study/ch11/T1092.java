package com.study.ch11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class T1092 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[] cranes = new Integer[n];
		for (int i=0; i<n; i++) {
			cranes[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cranes, Collections.reverseOrder());
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Integer[] boxes = new Integer[m];
		for (int i=0; i<m; i++) {
			boxes[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(boxes, Collections.reverseOrder());

		int[] position = new int[n];		// 각 크레인이 옮기는 박스 번호 
		boolean[] isMoved = new boolean[m];	// 박스의 이동 여부 
		if (cranes[0] < boxes[0]) {
			System.out.println(-1);
		} else {
			int count = 0;	// 옮긴 박스의 수 
			int answer = 0; // 걸린 시간 
			while (true) {
				if (count == m) {
					break;
				}
				for (int i=0; i<n; i++) {
					while (position[i] < m) {
						if (!isMoved[position[i]] &&  cranes[i] >= boxes[position[i]]) {
							isMoved[position[i]] = true;
							position[i]++;
							count++;
							break;
						}
						position[i]++;
					}
				}
				answer++;
			}
			System.out.println(answer);
		}
	}
}
