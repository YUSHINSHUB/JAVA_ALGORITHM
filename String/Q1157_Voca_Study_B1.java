package String;

import java.io.*;
import java.util.*;

	import java.io.*;

	public class Q1157_Voca_Study_B1 {

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int[] cnt = new int[27];
			String in = br.readLine();
			
			for( int i = 0 ; i < in.length() ; i++ ) {
				if( in.charAt(i) >= 'a' && in.charAt(i) <= 'z' ) {
					cnt[in.charAt(i) - 96]++;
				}else {
					cnt[in.charAt(i) - 64]++;
				}
			}
			
			int max = 1;
			String res = "A";
			for( int i = 2 ; i <= 26 ; i++ ) {
				if( cnt[i] > cnt[max] ) {
					max = i;
					res = Character.toString((char)(i+64));
				}else if( cnt[i] == cnt[max]) {
					max = i;
					res = "?";
				}
			}
			
			bw.write(res);
			
				
			bw.flush();
			bw.close();
		
	}
	}