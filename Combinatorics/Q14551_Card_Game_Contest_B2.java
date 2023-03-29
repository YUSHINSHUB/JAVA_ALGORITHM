package Combinatorics;

import java.io.*;
import java.util.*;

public class Q14551_Card_Game_Contest_B2 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int res = 1;
		int a = 0;
		// (A*B)%M == ( (A%M) * (B%M) ) % M
		for( int i = 0 ; i < n ; i ++ ) {
			a = Integer.parseInt(br.readLine());
			if(a == 0) a = 1;
			a %= m;
			res *= a;
			res %= m;
		}
		
		bw.write( (res%m) + "" );
		bw.flush();
		bw.close();
		
	}
}
