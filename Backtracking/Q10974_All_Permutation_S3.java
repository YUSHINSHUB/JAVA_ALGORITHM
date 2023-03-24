package Backtracking;

import java.io.*;
import java.math.*;
import java.util.*;




public class Q10974_All_Permutation_S3 {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int out[];
	static boolean chk[];
	
	static void bt(int cnt) throws IOException {
		if( cnt == n ) {
			for( int i = 0 ; i < n ; i++ ) {
				bw.write(out[i] + " " );
			}
			bw.write("\n");
			bw.flush();
			
		}else {
			for( int i = 0 ; i < n ; i++ ) {
				if( chk[i] ) continue;
				
				chk[i] = true;
				out[cnt] = i+1;
				bt(cnt+1);
				chk[i] = false;
				
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		out = new int[n];
		chk = new boolean[n];
		
		for( int i = 0 ; i < n ; i++ ) {
			chk[i] = false;
		}
		
		bt(0);
	
		}
}
