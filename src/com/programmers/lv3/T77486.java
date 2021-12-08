package com.programmers.lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/77486?language=java
public class T77486 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().replaceAll(" ", "").replaceAll("\"", "");
		String[] enroll = line.split(",");
		line = br.readLine().replaceAll(" ", "").replaceAll("\"", "");
		String[] referral = line.split(",");
		line = br.readLine().replaceAll(" ", "").replaceAll("\"", "");
		String[] seller = line.split(",");
		line = br.readLine().replaceAll(" ", "");
		String[] split = line.split(",");
		int[] amount = new int[split.length];
		for (int i=0; i<split.length; i++) {
			amount[i] = Integer.parseInt(split[i]);
		}
		
		int[] answer = solution(enroll, referral, seller, amount);
		for (int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	private static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		Map<String, Seller> sellerMap = new HashMap<>();
		sellerMap.put("-", new Seller(null, "-"));
		for (int i=0; i<enroll.length; i++) {
			sellerMap.put(enroll[i], new Seller(sellerMap.get(referral[i]), enroll[i]));
		}
		
		for (int i=0; i<seller.length; i++) {
			int income = amount[i]*100;
			sellerMap.get(seller[i]).addIncome(income);
		}
		
		int[] result = new int[enroll.length];
		for (int i=0; i<enroll.length; i++) {
			result[i] = sellerMap.get(enroll[i]).income;
		}
		return result;
	}
	
	static class Seller {
		Seller parent;
		String name;
		int income;
		public Seller(Seller parent, String name) {
			this.parent = parent;
			this.name = name;
		}
		public void addIncome(int income) {
			if (parent == null) {
				this.income += income;
				return;
			}
			int temp = income/10;
			if (temp < 1) {
				this.income += income;
			} else {
				this.income += (income-temp);
				this.parent.addIncome(temp);
			}
		}
	}
}
