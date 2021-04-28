package com.backjoon.greedy.t2457;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Flower implements Comparable<Flower> {
		int start;
		int end;
		
		public Flower(int startMon, int startDay, int endMon, int endDay) {
			// 날짜의 대소관계만 비교하면 되므로 아래와같이 수를 만들어둠 
			start = startMon*100 + startDay;
			end = endMon*100 + endDay;
		}
		@Override
		public int compareTo(Flower o) {
			// 빠른 날짜 순으로 정렬 
			if (this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	} 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		Flower[] flowers = new Flower[n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			flowers[i] = new Flower(Integer.parseInt(st.nextToken()), 
									Integer.parseInt(st.nextToken()), 
									Integer.parseInt(st.nextToken()), 
									Integer.parseInt(st.nextToken()));
		}
		int answer = solution(n, flowers);
		System.out.println(answer);
	}

	private static int solution(int n, Flower[] flowers) {
		int answer = 0;
		
		// 빠른날짜 순으로 정렬 
		Arrays.sort(flowers);
		
		int index = 0;
		int current = 301;
		int max = 0;
		while (current < 1201) {
			max = 0;
			boolean flag = false;
			for (int i=index; i<n; i++) {
				// 시작 날짜가 현재보다 큰 경우 종료 
				if (flowers[i].start > current) {
					break;
				}
				// 현재가 속한 날짜 중 제일 오래 꽃이 자라는 날을 max에 저장
				if (flowers[i].start <= current && max < flowers[i].end) {
					max = flowers[i].end;
					index = i+1; // max로 저장된 날짜 다음날부터 다시 비교하면 되므로 i+1 저장 
					flag = true;
				}
			}
			if (flag) {
				// max 날짜가 설정되고 인덱스가 다음으로 넘어간 경우 현재 날짜를 max로 변환 
				// 이전 꽃은 심을 수 있으므로 answer을 증가 
				current = max;
				answer++;
			} else {
				break;
			}
		}
		if (max < 1201) {
			answer = 0;
		}
		return answer;
	}
}

// https://moons-memo.tistory.com/66
