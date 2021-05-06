package com.backjoon.greedy.t19941;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String distStr = br.readLine();
		
		int answer = solution(n, k, distStr);
		System.out.println(answer);
	}

	private static int solution(int n, int k, String distStr) {
		int answer = 0;
		
		int[] ham = new int[n];
		String[] dist = distStr.split("");
		for (int i=0; i<n; i++) {
			if (dist[i].equals("H")) {
				ham[i] = 1;
			}
		}
		
		int start, end;
		for (int i=0; i<n; i++) {
			if (dist[i].equals("P")) {
				start = i-k;
				if (start < 0) {
					start = 0;
				}
				end = i+k;
				if (end > n-1) {
					end = n-1;
				}
				for (int j=start; j<=end; j++) {
					if (ham[j] > 0) {
						ham[j] = 0;
						answer++;
						break;
					}
				}
			}
		}
		return answer;
	}
}
