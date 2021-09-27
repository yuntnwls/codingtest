package com.programmers.check;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class T5342 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().replaceAll(" ", "");
		String[] enroll = line.split(",");
		for (int i=0; i<enroll.length; i++) {
			enroll[i] = enroll[i].substring(1, enroll[i].length()-1);
		}
		
		line = br.readLine().replaceAll(" ", "");
		String[] referral = line.split(",");
		for (int i=0; i<referral.length; i++) {
			referral[i] = referral[i].substring(1, referral[i].length()-1);
		}
		
		line = br.readLine().replaceAll(" ", "");
		String[] seller = line.split(",");
		for (int i=0; i<seller.length; i++) {
			seller[i] = seller[i].substring(1, seller[i].length()-1);
		}
		
		line = br.readLine().replaceAll(" ", "");
		String[] split = line.split(",");
		int[] amount = new int[split.length];
		for (int i=0; i<amount.length; i++) {
			amount[i] = Integer.parseInt(split[i]);
		}
		
		int[] answer = solution(enroll, referral, seller, amount);
		for (int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	
	static class People {
		String enroll;
		String referral;
		int index;
		public People(String enroll, String referral, int index) {
			this.enroll = enroll;
			this.referral = referral;
			this.index = index;
		}
	}

	private static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		Map<String, People> map = new HashMap<String, People>();
		for (int j=0; j<enroll.length; j++) {
			map.put(enroll[j], new People(enroll[j], referral[j], j));
		}
		
		int[] answer = new int[enroll.length];
		
		String now = "";
		People nowPeople = null;
		int money = 0;
		int temp = 0;
		for (int i=0; i<seller.length; i++) {
			now = seller[i];
			money = amount[i]*100;
			while (!now.equals("-")) {
				nowPeople = map.get(now);
				temp = money / 10;
				
				answer[nowPeople.index] += (money - temp);
				money = money/10;
				
				now = nowPeople.referral;
				
				if (money < 1) {
					break;
				}
			}
		}
		
		return answer;
	}
}
