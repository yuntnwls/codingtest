
package com.lecture.implementation.direction;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//		    동  북  서  남  
		int[] dx = {0, -1, 0, 1};
		int[] dy = {1, 0, -1, 0};
		String[] direction = {"R", "U", "L", "D"};
		int currX = 1;
		int currY = 1;
		while (st.hasMoreTokens()) {
			String dir = st.nextToken();
			for (int i=0; i<direction.length; i++) {
				if (dir.equals(direction[i])) {
					int x = currX + dx[i];
					int y = currY + dy[i];
					if (x >= 1 && x <= n && y >= 1 && y <= n) {
						currX = x;
						currY = y;
					}
					break;
				}
			}
		}
		System.out.println(String.format("%d %d", currX, currY));
	}
}

// 가장 왼쪽 위 1,1