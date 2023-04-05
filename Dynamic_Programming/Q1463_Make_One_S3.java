package Dynamic_Programming;

import java.io.*;
import java.util.*;


public class Q1463_Make_One_S3 {
	
	static int dp[] = new int[1000001];
	static boolean chk[] = new boolean[1000001];
	static int task(int a) {
		
		if( chk[a] == false ) {
			if( a % 6 == 0 ) {
				dp[a] = Math.min(task(a-1), Math.min(task(a / 3), task(a / 2)) ) + 1;
			}else if( a % 3 == 0 ) {
				dp[a] = Math.min(task(a / 3), task(a-1)) + 1;
			}else if( a % 2 == 0 ) {
				dp[a] = Math.min(task(a / 2), task(a-1)) + 1;
			}else {
				dp[a] = task(a-1) + 1;
			}
		}
		
		chk[a] = true;
		return dp[a];
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		dp[1] = 0;
		chk[1] = true;
		
		bw.write(String.valueOf(task(n)));
		
		
		bw.flush();
		bw.close();
		
	}
}