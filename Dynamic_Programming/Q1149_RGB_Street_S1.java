package Dynamic_Programming;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1149_RGB_Street_S1 {
	
	static int dp[] = new int[3001];
	
	static int recur(int fee[], int cnt) {
		
		while( cnt >= 0 ) {
			dp[cnt*3] = fee[cnt*3] + Math.min(dp[(cnt+1)*3+1], dp[(cnt+1)*3+2]);
			dp[cnt*3+1] = fee[cnt*3+1] + Math.min(dp[(cnt+1)*3+0], dp[(cnt+1)*3+2]);
			dp[cnt*3+2] = fee[cnt*3+2] + Math.min(dp[(cnt+1)*3+0], dp[(cnt+1)*3+1]);
			cnt--;
		}
		
		return Math.min(dp[0], Math.min(dp[1], dp[2]));
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int fee[] = new int[n*3];
		
		for( int i = 0 ; i < n ; i++ ) {
			String temp[] = br.readLine().split(" ");
			for( int z = 0 ; z < 3 ; z++ ) {
				fee[i*3+z] = Integer.parseInt(temp[z]);
			}
		}
		
		dp[(n-1)*3+0] = fee[(n-1)*3+0];
		dp[(n-1)*3+1] = fee[(n-1)*3+1];
		dp[(n-1)*3+2] = fee[(n-1)*3+2];
		
		int cnt = (n-2);
		
		int res = recur(fee, cnt);
		
		bw.write(res + "");
		
		bw.flush();
		bw.close();
	}
}
