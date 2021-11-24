package com.backjoon.dp.t11066;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			int K = Integer.parseInt(br.readLine());
			int[] files = new int[K+1];
			int[] sum = new int[K+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=1; j<=K; j++) {
				files[j] = Integer.parseInt(st.nextToken());
				sum[j] = sum[j-1] + files[j];
			}
			
			solution(K, files, sum);
		}
	}

	private static void solution(int k, int[] files, int[] sum) {
		// dp[i][j] = i번 부터 j번까지 합치는데 드는 최소한의 비용 
		// sum[a] = 0부터 a번쨰 크기까지 더한 값
		// dp[a][a] = cost[a] 
		// dp[a][a] = sum[a]-sum[a-1]
		// dp[a][a+1] = sum[a+1]-sum[a-1]
		// dp[a][a+2] = min(dp[a][a]+dp[a+1][a+2], dp[a][a+1]+dp[a+2][a+2])
 		int dp[][] = new int[k+1][k+1];
		for (int i=1; i<k; i++) {
			for (int x=1; x<=k-i; x++) {
				int y = x + i;
				dp[x][y] = Integer.MAX_VALUE;
				
				for (int mid=x; mid<y; mid++) {
					dp[x][y] = Math.min(dp[x][y], dp[x][mid] + dp[mid+1][y] + sum[y] - sum[x-1]);
				}
			}
		}
		System.out.println(dp[1][k]);
	}
}
