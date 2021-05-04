package com.backjoon.greedy.t1461;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int answer = 0;
	
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
		solution(n, m, mLoc, pLoc);
		System.out.println(answer);
	}

	private static int solution(int n, int m, List<Integer> mLoc, List<Integer> pLoc) {
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
		
		int myLoc = 0;
		if (pLoc.size() > 0 && mLoc.size() > 0) {
			// 음수와 양수가 모두 있는 경우는 순서가 중요
			int pMax = pLoc.get(0);
			int mMax = mLoc.get(0);
			if (pMax > mMax) {
				myLoc = move(mLoc, myLoc, m);
				move(pLoc, myLoc, m);
			} else {
				myLoc = move(pLoc, myLoc, m);
				move(mLoc, myLoc, m);
			}
			// 음수에서 양수/양수에서 음수로 가는 경우 
			// 무조건 한번은 원점을 지나므로 최대 값이 더 작은 수를 더해줌 
			answer += myLoc;
		} else if (pLoc.size() > 0) {
			move(pLoc, myLoc, m);
		} else {
			move(mLoc, myLoc, m);
		}
		return answer;
	}
	
	private static int move(List<Integer> loc, int currentLoc, int m) {
		int idx = 0;
		int locSize = loc.size();
		while (idx < locSize) {
			if (loc.get(idx)> currentLoc) {
				// 가장 먼 곳 
				answer += loc.get(idx);
				currentLoc += loc.get(idx);
			} else {
				answer += (loc.get(idx)*2);
			}
			idx += m;
		}
		return currentLoc;
	}
}

// https://bba-dda.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%8A%A4%ED%84%B0%EB%94%94-%EB%B0%B1%EC%A4%80-1461-%EB%8F%84%EC%84%9C%EA%B4%80