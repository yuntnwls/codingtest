package com.programmers.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class T42885 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().replaceAll(" ", "");
		String[] split = line.split(",");
		int[] people = new int[split.length];
		for (int i=0; i<split.length; i++) {
			people[i] = Integer.parseInt(split[i]);
		}
		int limit = Integer.parseInt(br.readLine());
		
		int answer = solution(people, limit);
		System.out.println(answer);
	}

	private static int solution(int[] people, int limit) {
		Arrays.sort(people);
		
		int answer = 0;
		int firstIdx = 0;
        int lastIdx = people.length-1;
        
        while (firstIdx <= lastIdx) {
        	if (people[firstIdx] + people[lastIdx] <= limit) {
        		firstIdx++;
        		lastIdx--;
        	} else {
        		lastIdx--;
        	}
        	answer++;
        }
		
		return answer;
	}
}
