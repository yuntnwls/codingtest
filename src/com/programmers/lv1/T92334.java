package com.programmers.lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/92334
public class T92334 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().replaceAll(" ", "").replaceAll("\"", "");
		String[] id_list = line.split(",");
		
		line = br.readLine().replaceAll("\"", "");
		String[] report = line.split(",");
		
		int k = Integer.parseInt(br.readLine());
		
		int[] answer = solution(id_list, report, k);
		for (int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + ", ");
		}
	}
	
	public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> result = new HashMap<>();
        
        // key:신고 당한 사람, value:신고한 사람 리스트 
        Map<String, List<String>> map = new HashMap<>();
        for (int i=0; i<id_list.length; i++) {
        	map.put(id_list[i], new ArrayList<>());
        	result.put(id_list[i], 0);
        }
        
        for (int i=0; i<report.length; i++) {
        	String[] split = report[i].split(" ");
        	List<String> idList = map.get(split[1]);
        	if (!idList.contains(split[0])) {
            	map.get(split[1]).add(split[0]);
        	}
        }
        
        for (String key : map.keySet()) {
        	if (map.get(key).size() >= k) {
        		for (String id : map.get(key)) {
            		result.put(id, result.get(id)+1);
        		}
        	}
        }
        
        for (int i=0; i<id_list.length; i++) {
        	answer[i] = result.get(id_list[i]);
        }
        
        return answer;
    }
}
