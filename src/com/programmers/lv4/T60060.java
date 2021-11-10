package com.programmers.lv4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/60060?language=java
public class T60060 {
	// Trie 자료구조
	// 문자열에 특화된 트리 구조로, 문자 하나씩 깊이가 추가되는 구조 
	// 같은 구간에 반복되는 문자가 있으면 그 문자에 같이 포함시켜 count를 추가 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().replaceAll("\"", "").replaceAll(" ", "");
		String[] words = line.split(",");
		
		line = br.readLine().replaceAll("\"", "").replaceAll(" ", "");
		String[] queries = line.split(",");
		
		int[] answer = solution(words, queries);
		for (int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	private static int[] solution(String[] words, String[] queries) {
		Trie front = new Trie();
		Trie back = new Trie();
		
		for (String word : words) {
			front.insert(word);
			back.insert(reverse(word));
		}
		
		int[] answer = new int[queries.length];
		int index = 0;
		for (String query : queries) {
			if (query.charAt(0) == '?') {
				answer[index++] = back.find(reverse(query), 0); 
			} else {
				answer[index++] = front.find(query, 0);
			}
		}
		return answer;
	}
	
	private static String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}
	
	static class Trie {
		//key:삽입된 문자열, value:해당 길이의 문자열의 개수 
		Map<Integer, Integer> lenMap = new HashMap<>();
		Trie[] child = new Trie[26];
		
		public void insert(String str) {
			Trie node = this;
			int len = str.length();
			lenMap.put(len, lenMap.getOrDefault(len, 0)+1);
			
			for (char ch : str.toCharArray()) {
				int idx = ch-'a';
				if (node.child[idx] == null) {
					node.child[idx] = new Trie();
				}
				
				node = node.child[idx];
				node.lenMap.put(len, node.lenMap.getOrDefault(len, 0)+1);
			}
		}
		
		public int find(String str, int i) {
			if (str.charAt(i) == '?') {
				return lenMap.getOrDefault(str.length(), 0);
			}
			
			int idx = str.charAt(i) - 'a';
			return child[idx] == null? 0 : child[idx].find(str, i+1);
		}
	}

//	private static int[] solution(String[] words, String[] queries) {
//		int[] answer = new int[queries.length];
//		
//		int startIdx = 0;
//		int endIdx = 0;
//		for (int i=0; i<queries.length; i++) {
//			startIdx = queries[i].indexOf("?");
//			endIdx = queries[i].lastIndexOf("?");
//			
//			if (startIdx == 0) {
//				// 앞쪽에 물음표가 있는 경우 
//				startIdx = endIdx+1;
//				endIdx = queries[i].length()-1;
//			} else if (endIdx == queries[i].length()-1) {
//				// 뒤쪽에 물음표가 있는 경우 
//				endIdx = startIdx-1;
//				startIdx = 0;
//			}
//			
//			answer[i] = searchCount(words, startIdx, endIdx, queries[i]);
//		}
//		
//		return answer;
//	}
//	
//	private static int searchCount(String[] words, int startIdx, int endIdx, String query) {
//		String search = query.substring(startIdx, endIdx+1);
//		String word = "";
//		int count = 0;
//		for (int i=0; i<words.length; i++) {
//			if (query.length() != words[i].length()) {
//				continue;
//			}
//			word = words[i].substring(startIdx, endIdx+1);
//			if (word.equals(search)) {
//				count++;
//			}
//		}
//		return count;
//	}
}

// https://girawhale.tistory.com/110