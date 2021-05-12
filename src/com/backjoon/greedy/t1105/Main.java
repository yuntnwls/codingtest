package com.backjoon.greedy.t1105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String lStr = st.nextToken();
		String rStr = st.nextToken();
		String l[] = lStr.split("");
		String r[] = rStr.split("");
		
		int answer =  solution(l, r);
		System.out.println(answer);	
	}

	private static int solution(String[] l, String[] r) {
		int answer = 0;
		if (l.length != r.length) {
			// 자릿수가 다르면 8이 없는 수가 올 수 있음 
			answer = 0;
		} else {
			for (int i=0; i<l.length; i++) {
				// 자릿수가 같으면 앞자리부터 비교해서 8과 다른 자릿수가 나온다면 다른 수가 올 수 있음 
				if (l[i].equals(r[i])) {
					if (l[i].equals("8")) {
						answer++;
					}
				} else {
					break;
				}
			}
		}
		return answer;
	}
}
