package com.programmers.study.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://programmers.co.kr/learn/courses/30/lessons/42897?language=java
public class T42897 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().replaceAll(" ", "");
		String[] split = line.split(",");
		int[] money = new int[split.length];
		for (int i=0; i<split.length; i++) {
			money[i] = Integer.parseInt(split[i]);
		}
		
		int answer = solution(money);
		System.out.println(answer);
	}

	private static int solution(int[] money) {
		// dp[i] = 도둑이 i번쨰 집에 왔을 때의 훔친 돈의 최댓값 
		// 현재 집을 털거나 (그 전전 집의 dp + 현재 집이 가진돈 = dp[i-2]+money[i])
		// 현재 집을 털지 않거나 (dp[i-1]값을 그대로 가져옴) 
		// dp[i] = Math.max(dp[i-1], dp[i-2] + money[i])
		
		int answer = 0;
		// 3개인 경우 한군데만 털면되므로 가장 큰 돈을 가진 곳만 구하면 끝 
		if (money.length == 3) {
			for (int i=0; i<money.length; i++) {
				answer = Math.max(answer, money[i]);
			}
			return answer;
		}
		
		// 원형으로 이루어진 집이므로 처음집과 마지막집이 이어져있음 		
		// 첫번째 집을 무조건 털고, 마지막 집을 털지 않은 경우 
		int[] dpForGetFirst = new int[money.length];
		dpForGetFirst[0] = money[0];
		dpForGetFirst[1] = Math.max(money[0], money[1]);
		
		// 첫번째 집을 무조건 털지 않은 경우 
		int[] dpForGetLast = new int[money.length];
		dpForGetLast[0] = 0;
		dpForGetLast[1] = money[1];
		
		for (int i=2; i<money.length; i++) {
			dpForGetLast[i] = Math.max(dpForGetLast[i-1], dpForGetLast[i-2] + money[i]);
			answer = Math.max(answer, dpForGetLast[i]);
		
			if (i == money.length-1) {
				break;	//	마지막 집은 털지 않음 
			}
			dpForGetFirst[i] = Math.max(dpForGetFirst[i-1],	dpForGetFirst[i-2]+money[i]);
			answer = Math.max(answer, dpForGetFirst[i]);
		}
		
		return answer;
	}
}
