package com.backjoon.greedy.t1461;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		List<Integer> mLoc = new ArrayList<>();
		List<Integer> pLoc = new ArrayList<>();
		for (int i=0; i<n; i++) {
			int loc = Integer.parseInt(st.nextToken());
			if (loc < 0) {
				mLoc.add(loc*(-1));
			} else {
				pLoc.add(loc);
			}
		}
		int answer = solution(n, m, mLoc, pLoc);
		System.out.println(answer);
	}

	private static int solution(int n, int m, List<Integer> mLoc, List<Integer> pLoc) {
		int answer = 0;
		// 오름차순로 정렬 
		Collections.sort(mLoc, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		Collections.sort(pLoc, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		int idx = 0;
		int myLoc = 0;
		// 오른쪽의 책들이 모두 정리될 때까지 
		int pSize = pLoc.size();
		int mSize = mLoc.size();
		while (idx < pSize) {
			if (pLoc.get(idx)> myLoc) {
				// 가장 먼 곳 
				answer += pLoc.get(idx);
				myLoc += pLoc.get(idx);
			} else {
				answer += (pLoc.get(idx)*2);
			}
			idx += m;
		}
		idx = 0;
		// 왼쪽 책들이 모두 정리될 때 
		while (idx < mSize) {
			if (mLoc.get(idx)> myLoc) {
				// 가장 먼 곳 
				answer += mLoc.get(idx);
				answer += myLoc;	// +와-가 모두 있는 경우 +가 끝나고 -를 갈떄 원점을 한번은 지나야함  
				myLoc += mLoc.get(idx);
			} else {
				answer += (mLoc.get(idx)*2);
			}
			idx += m;
		}
		return answer;
	}
}

// https://bba-dda.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%8A%A4%ED%84%B0%EB%94%94-%EB%B0%B1%EC%A4%80-1461-%EB%8F%84%EC%84%9C%EA%B4%80