package com.backjoon.greedy.t10165;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Timeout {
	public static int n = 0;
	
	static class Bus implements Comparable<Bus>{
		int index;
		int start;
		int end;
		int stationCnt = 0;
		boolean isCancel = false;
		public Bus(int index, int start, int end) {
			this.index = index;
			this.start = start;
			if (start > end) {
				this.end = end + n;
			} else {
				this.end = end;
			}
			// 정차하는 정류장의 수 
			this.stationCnt = this.end - this.start + 1;
		}
		public void setCancel(boolean isCancel) {
			this.isCancel = isCancel;
		}
		@Override
		public int compareTo(Bus o) {
			if (this.start == o.start) {
				return o.end - this.end;
			}
			return this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		Bus[] bus = new Bus[m];
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			bus[i] = new Bus(i+1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		solution(n, m, bus);
		printAnswer(bus);
	}

	private static void solution(int n, int m, Bus[] bus) {
		int same = 0;
		
		Arrays.sort(bus);
		
		for (int i=0; i<m; i++) {
			if (bus[i].isCancel) {
				continue;
			}
			for (int j=0; j<m; j++) {
				if (bus[j].isCancel)
					continue;
				if (i == j) {
					continue;
				}
				same = 0;
				if (bus[i].stationCnt <= bus[j].stationCnt) {
					// 겹치는 노선 수 >= bus[i]의 노선 수
					if (bus[i].start >= bus[j].start) {
						if (bus[i].end <= bus[j].end) {
							same = bus[j].end - bus[i].start + 1;
							if (same >= bus[i].stationCnt) {
								bus[i].setCancel(true);
							}
						}
					} else {
						if (bus[i].end <= bus[j].end) {
							int start = bus[i].start + n;
							same = bus[j].end - start + 1;
							if (same >= bus[i].stationCnt) {
								bus[i].setCancel(true);
							}
						}
					}
				}
				if (bus[i].isCancel)
					break;
			}
		}
	}
	
	private static void printAnswer(Bus[] bus) {
		// 취소되지 않은 노선 출력 
		StringBuffer buffer = new StringBuffer();
		for (int i=0; i<bus.length; i++) {
			if (!bus[i].isCancel) {
				if (buffer.length() > 0) {
					buffer.append(" ");
				}
				buffer.append(bus[i].index);
			}
		}
		System.out.println(buffer.toString());
	}
}
