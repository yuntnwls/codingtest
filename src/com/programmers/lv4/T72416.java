package com.programmers.lv4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/72416?language=java
// 그냥 DFS로 풀 경우 시간초과 발생 
// DP를 사용해서 풀어야 통과 
public class T72416 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().replaceAll(" ", "");
		String[] split = line.split(",");
		int[] sales = new int[split.length];
		for (int i=0; i<split.length; i++) {
			sales[i] = Integer.parseInt(split[i]);
		}
		int n = Integer.parseInt(br.readLine());
		int[][] links = new int[n][2];
		for (int i=0; i<n; i++) {
			line = br.readLine().replaceAll(" ", "");
			split = line.split(",");
			links[i][0] = Integer.parseInt(split[0]);
			links[i][1] = Integer.parseInt(split[1]);
		}
		
		int answer = solution(sales, links);
		System.out.println(answer);
	}
	
	private static int min = Integer.MAX_VALUE;
	private static List<Staff> staffList = null;
	private static List<Staff> teamLeaderList = null;
	
	private static int[][] dp = new int[300001][2];	//1:참가, 0:불참 

	private static int solution(int[] sales, int[][] links) {
		staffList = new ArrayList<>();
		staffList.add(new Staff(0, 0));
		for (int i=0; i<sales.length; i++) {
			staffList.add(new Staff(i+1, sales[i]));
		}
		
		teamLeaderList = new ArrayList<>();
		for (int i=0; i<links.length; i++) {
			Staff leader = staffList.get(links[i][0]);
			Staff member = staffList.get(links[i][1]);
			leader.addMember(member);
			member.setLeader(leader);
			
			if (!teamLeaderList.contains(leader)) {
				teamLeaderList.add(leader);	
			}
		}
		
		
		dfs(1);
		
		return dp[1][0] > dp[1][1] ? dp[1][1] : dp[1][0];
	}
	
	
	private static void dfs(int idx) {
		Staff now = staffList.get(idx);
		dp[now.no][1] = now.sale;
		
		if (now.members.size() > 0) {// 팀장인 경우 자식노드가 있음을 이용 
			for (Staff member : now.members) {
				dfs(member.no);
			}
			
			int min = Integer.MAX_VALUE;
			for (Staff member : now.members) {
				if (dp[member.no][0] < dp[member.no][1]) {
					dp[now.no][0] += dp[member.no][0];
					dp[now.no][1] += dp[member.no][0];

					// 참가 여부에 따른 차이의 최소 비용 
					min = Math.min(dp[member.no][1] - dp[member.no][0], min);
				} else {
					dp[now.no][0] += dp[member.no][1];
					dp[now.no][1] += dp[member.no][1];
					min = 0;	// 자식노드에 참가한 인원이 생기면 0으로 변경 
				}
			}
			
			if (min != Integer.MAX_VALUE) {
				//모든 자식노드가 참가하지 않았다면 최소비용을 더해 강제로 하나의 팀에 참여시킴 
				dp[now.no][0] += min;
			}
		}
	}

	static class Staff {
		int no;
		int sale;
		
		Staff leader = null;
		List<Staff> members = new ArrayList<>();
		
		public Staff(int no, int sale) {
			this.no = no;
			this.sale = sale;
		}
		
		public void setLeader(Staff leader) {
			this.leader = leader;
		}
		
		public void addMember(Staff member) {
			members.add(member);
		}
	}
}
