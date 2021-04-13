package com.backjoon.greedy.t8980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		List<Delivery> dList = new ArrayList<Delivery>();
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			dList.add(new Delivery(Integer.parseInt(st.nextToken()), 
								   Integer.parseInt(st.nextToken()), 
								   Integer.parseInt(st.nextToken())));
		}
		
		int answer = solution(n, c, m, dList);
		System.out.println(answer);
	}

	private static int solution(int n, int c, int m, List<Delivery> dList) {
		int answer = 0;
	
		// 도착도시 기준을 오름차순 정렬 
		Collections.sort(dList, new Comparator<Delivery>() {
			@Override
			public int compare(Delivery o1, Delivery o2) {
				if (o1.to == o2.to) // 도착지가 같다면 출발지 기준으로 정렬 
					return o1.from - o2.from;
				else
					return o1.to - o2.to;
			}
		});
		
		// 최대적재량으로 초기화  
		int[] town = new int[n+1];
		for (int i=1; i<n+1; i++) {
			town[i] = c;
		}
		
		for (int i=0; i<m; i++) {
			Delivery delivery = dList.get(i);
			
			// 보내는 마을과 받는 마을 사이에서 보낼 수 있는 최소 한도 구하기
			int minLimit = Integer.MAX_VALUE;
			for (int j=delivery.from; j<delivery.to; j++) {
				if (minLimit > town[j]) {
					minLimit = town[j];
				}
			}
			
			// 최소 한도가 현재 운반해야하는 갯수보다 적다면 출발지~도착지-1까지 모두 빼기 
			if (minLimit >= delivery.count) {
				for (int j=delivery.from; j<delivery.to; j++) {
					town[j] -= delivery.count;
				}
				answer += delivery.count;
			} else {
				for (int j=delivery.from; j<delivery.to; j++) {
					town[j] -= minLimit;
				}
				answer += minLimit;
			}
		}
		return answer;
	}
}

class Delivery {
	int from;
	int to;
	int count;
	
	public Delivery(int from, int to, int count) {
		this.from = from;
		this.to = to;
		this.count = count;
	}
}