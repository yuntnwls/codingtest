package com.programmers.lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://programmers.co.kr/learn/courses/30/lessons/72412?language=java
public class T72412 {
	
	private static Map<String, ArrayList<Integer>> allInfoMap;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] info = new String[n];
		for (int i=0; i<n; i++) {
			info[i] = br.readLine();
		}
		int m = Integer.parseInt(br.readLine());
		String[] query = new String[m];
		for (int i=0; i<m; i++) {
			query[i] = br.readLine();
		}
		
		int[] answers = solution(info, query);
		for (int i=0; i<answers.length; i++) {
			System.out.println(answers[i]);
		}
	}

	private static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		
		allInfoMap = new HashMap<>();
		// info를 통해 나올수 있는 모든 경우의 수를 map에 저장 
		for (int i=0; i<info.length; i++) {
			dfs("", 0, info[i].split(" "));
		}
		
		// map에 저장된 점수 리스트를 오름차순으로 정렬 
		for (String key : allInfoMap.keySet()) {
			List<Integer> scoreList = allInfoMap.get(key);
			Collections.sort(scoreList);
		}
		
		for (int i=0; i<query.length; i++) {
			query[i] = query[i].replaceAll(" and ", "");
			String[] split = query[i].split(" ");
			int score = Integer.parseInt(split[1]);
			
			// 이분 탐색으로 확인 
			answer[i] = search(split[0], score);
		}
		return answer;
	}

	private static int search(String condition, int score) {
		List<Integer> scoreList = allInfoMap.get(condition);
		if (scoreList == null) {
			return 0;
		}
		int start = 0;
		int end = scoreList.size()-1;
		while (start <= end) {
			int mid = (start+end)/2;
			if (scoreList.get(mid) < score) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		return scoreList.size()-start;
	}

	private static void dfs(String pos, int depth, String[] info) {
		if (depth == 4) {
			if (!allInfoMap.containsKey(pos)) {
				ArrayList<Integer> scoreList = new ArrayList<>();
				scoreList.add(Integer.parseInt(info[4]));
				allInfoMap.put(pos, scoreList);
			} else {
				allInfoMap.get(pos).add(Integer.parseInt(info[4]));
			}
			return;
		}
		// -인 경우와 조건이 있는 경우 
		dfs(pos+"-", depth+1, info);
		dfs(pos+info[depth], depth+1, info);
	}
}
