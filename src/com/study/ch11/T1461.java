package com.study.ch11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class T1461 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] pos = new int[n];
		for (int i=0; i<n; i++) {
			pos[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = solution(n, k, pos);
		System.out.println(answer);
	}

	private static int solution(int n, int k, int[] pos) {
		// 음수와 양수를 나누기 
		List<Integer> pList = new ArrayList<Integer>();
		List<Integer> mList = new ArrayList<Integer>();
		for (int i=0; i<pos.length; i++) {
			if (pos[i] < 0) {
				mList.add(pos[i]*(-1));
			} else {
				pList.add(pos[i]);
			}
		}
		// 내림차순으로 정렬 
		Collections.sort(pList, Collections.reverseOrder());
		Collections.sort(mList, Collections.reverseOrder());
		
		// 한 번에 들 수있는 책의 수만큼 걸음 수 추가  
		int sum = 0;
		for (int i=0; i<pList.size(); i+=k) {
			sum += pList.get(i);
		}
		for (int i=0; i<mList.size(); i+=k) {
			sum += mList.get(i);
		}
		
		// 왕복이므로 x2
		sum *= 2;
		// 마지막 가장 먼 거리는 돌아오지 않아도되므로 빼주기
		if (pList.size() == 0) {
			sum -= mList.get(0);
		} else if (mList.size() == 0) {
			sum -= pList.get(0);
		} else {
			if (pList.get(0) > mList.get(0)) {
				sum -= pList.get(0);
			} else {
				sum -= mList.get(0);
			}
		}
		return sum;
	}
}
