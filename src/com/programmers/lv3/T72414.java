package com.programmers.lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/72414?language=java
public class T72414 {

	// ad[i] = n : i시간 때 광고를 재생하는 시청자 수가 n명
	private static int[] ad;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String play_time = br.readLine();
		String adv_time = br.readLine();
		int n = Integer.parseInt(br.readLine());
		String[] logs = new String[n];
		for (int i=0; i<n; i++) {
			logs[i] = br.readLine();
		}
		
		String answer = solution(play_time, adv_time, logs);
		System.out.println(answer);
	}

	private static String solution(String play_time, String adv_time, String[] logs) {
		ad = new int[360000];	// 100:00:00 => 360000초
		
		for (String log : logs) {
			String[] split = log.split("-");
			int start = convertStrToSec(split[0]);
			int end = convertStrToSec(split[1]);
			for (int i=start; i<end; i++) {
				ad[i]++;
			}
		}
		
		// 전체 구간 길이 
		int totalSec = convertStrToSec(play_time);
		int advSec = convertStrToSec(adv_time);
		
		int startSec = 0;
		long sum = 0;
		long maxSum = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		// 처음엔 0부터 시작할 경우 
		for (int i=0; i<advSec; i++) {
			sum += ad[i];
			queue.add(ad[i]);
		}
		maxSum = sum;
		
		// 전에 구한 구간합에서 가장 첫 원소를 빼고 다음 원소 하나를 넣어주면 다음 구간합과 같음 
		// 한칸씩 옮긴다고 생각하면 됨 
		for (int i=advSec; i<totalSec; i++) {
			sum += ad[i]; 
			queue.add(ad[i]);		// queue에는 항상 광고시간만큼의 데이터가 들어있게 됨 
			sum -= queue.poll();	// 가장 첫번쨰 원소 뺴기(queue에 들어있는 가장 첫 시간)
			if (sum > maxSum) {
				startSec = i-advSec+1;	// 광고 시작 시간 
				maxSum = sum;
			}
		}
		
		return convertSecToStr(startSec);
	}
	
	private static int convertStrToSec(String time) {
		String[] split = time.split(":");
		int sec = 0; 
		sec += Integer.parseInt(split[0])*60*60;
		sec += Integer.parseInt(split[1])*60;
		sec += Integer.parseInt(split[2]);
		return sec;
	}
	
	private static String convertSecToStr(int sec) {
		int s = sec%60;
		sec /= 60;
		int m = sec%60;
		sec /= 60;
		int h = sec;
		
		String str = String.format("%02d:%02d:%02d", h, m, s);
		return str;
	}
}

//https://yjyoon-dev.github.io/kakao/2021/01/29/kakao-insertad/
