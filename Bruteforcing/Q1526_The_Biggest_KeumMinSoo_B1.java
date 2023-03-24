package Bruteforcing;

import java.io.*;
import java.math.BigInteger;
import java.util.*;



public class Q1526_The_Biggest_KeumMinSoo_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String n = br.readLine();
		boolean chk = true;
		
		while ( true ) {
			for( int i = 0 ; i < n.length() ; i++ ) {
				if( n.charAt(i) != '4' && n.charAt(i) != '7') {
					chk = false;
					break;
				}
			}
			
			if( chk == true ) {
				break;
			}
			
			chk = true;
			n = String.valueOf(Integer.parseInt(n) - 1);
		}
		
		bw.write(n + "");
		
		bw.flush();
		bw.close();
	}
}
