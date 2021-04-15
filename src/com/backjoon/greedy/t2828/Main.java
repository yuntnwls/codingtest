package com.backjoon.greedy.t2828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int j = Integer.parseInt(br.readLine());
		int[] pos = new int[j];
		for (int i=0; i<j; i++) {
			pos[i] = Integer.parseInt(br.readLine());
		}
		
		int answer = solution(n, m, j, pos);
		System.out.println(answer);
	}

	private static int solution(int n, int m, int j, int[] pos) {
		int answer = 0;
		
		// 바구니의 시작과 끝 
		int start = 1;
		int end = m;
		// 한번 움직인 횟수 
		int move = 0;
		for (int i=0; i<j; i++) {
			move = 0;
			if (pos[i] < start) {
				// 왼쪽으로 이동 
				move = start - pos[i];
				start = pos[i];
				end -= move;
			} else if (pos[i] > end) {
				// 오른쪽으로 이동
				move = pos[i] - end;
				start += move;
				end = pos[i];
			}
			answer += move;
		}
		return answer;
	}
}
