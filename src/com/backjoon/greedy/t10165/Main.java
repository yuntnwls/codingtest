package com.backjoon.greedy.t10165;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static List<Bus> busZeroList;
	public static List<Bus> busList;
	public static int n = 0;
	public static int minStart = -1;
	public static int maxEnd = -1;
	public static boolean[] answer;
	
	static class Bus implements Comparable<Bus>{
		int index;
		int start;
		int end;
		
		public Bus(int index, int start, int end) {
			this.index = index;
			this.start = start;
			if (start > end) {
				this.end = end + n;
			} else {
				this.end = end;
			}
		}
		@Override
		public int compareTo(Bus o) {
			if (this.start == o.start) {
				// 시작점이 같다면 늦게 끝나는 노선 
				return (o.end - this.end);
			}
			// 먼저 시작하는 노선 
			return (this.start - o.start);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		answer = new boolean[m+1];
		StringTokenizer st = null;
		
		minStart = n;
		busList = new ArrayList<>();
		busZeroList = new ArrayList<>();
		int start = 0;
		int end = 0;
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			if (start <= end) {
				busList.add(new Bus(i+1, start, end));
			} else {
				busZeroList.add(new Bus(i+1, start, end));
				if (start < minStart) {
					minStart = start;
				}
				if (end > maxEnd) {
					maxEnd = end;
				}
			}
		}
		solution();
		printAnswer();
	}

	private static void solution() {
		Collections.sort(busList);
		Collections.sort(busZeroList);
		
		// 0을 거치지 않는 노선 
		long right = 0;
		Bus bus = null;
		for (int i=0; i<busList.size(); i++) {
			bus = busList.get(i);
			if (bus.end <= right) {
				answer[bus.index] = true;
			} else {
				right = bus.end;
			}
			
			// 0을 거치는 노선의 시작점 < 0을 거치지 않는 노선의 시작점
			// 0을 거치는 노선의 도착점 > 0을 거치지 않는 노선의 도착점 
			// 반드시 0을 거치는 노선은 0을 거치지 않는 노선에 포함
			if (minStart <= bus.start || maxEnd >= bus.end) {
				answer[bus.index] = true;
			}
		}
		
		// 0을 거치는 노선
		right = 0;
		for (int i=0; i<busZeroList.size(); i++) {
			bus = busZeroList.get(i);
			if (bus.end <= right) {
				answer[bus.index] = true;
			} else {
				right = bus.end;
			}
		}
		
	}
	
	private static void printAnswer() throws Exception {
		// 취소되지 않은 노선 출력 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i=1; i<answer.length; i++) {
			if (!answer[i]) {
				bw.write(String.valueOf(i) + " ");
			}
		}
		bw.write(String.valueOf("\n"));
		bw.flush();
		bw.close();
	}
}

// https://chanhuiseok.github.io/posts/baek-32/
// https://hsdevelopment.tistory.com/476
