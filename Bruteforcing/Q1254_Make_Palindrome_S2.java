package Bruteforcing;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1254_Make_Palindrome_S2 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String in = br.readLine();
		int str = 0;
		if( in.length() != 0 ) str = in.length() / 2;
		int cnt = 1;
		boolean p1 = false;
		boolean p2 = false;
		int pls = 0;
		int res = in.length();
		
		
		if( in.length() == 1 || in.length() == 0 ) pls = 0;
		else {
		for( int i = str ; i < in.length() ; i++ ) {
			p1 = false;
			p2 = false;
			
			if( i != in.length() - 1 ) {
				
			cnt = 1;
			
			while( true ) {
				if( i + cnt > in.length()-1 || i - cnt < 0 ) break;
				if( in.charAt(i + cnt) != in.charAt(i - cnt) ) {
					p1 = true;
					break;
				}
				cnt++;
			}
			
			}else p1 = false;
			
			cnt = 0;
			
			if( in.length() % 2 == 0 || i > str ) {
			
			while( true ) {
				if( i + cnt > in.length()-1 || i - 1 - cnt < 0 ) break;
				if( in.charAt(i + cnt) != in.charAt(i - 1 - cnt) ) {
					p2 = true;
					break;
				}
				cnt++;
			}
			
			}else p2 = true;
			
			if( p1 == false && i == str && in.length() % 2 == 1 ) {
				pls = 0;
				break;
			}else if( p2 == false ) {
				pls = (i-1) - ( in.length() - i - 1 );
				break;
			}else if( i == in.length() - 1 || p1 == false ) {
				pls = i - ( in.length() - i - 1 );
				break;
			}
			
			
		}
		
		}
		
		res += pls;
		
		bw.write(res + "");
		
		bw.flush();
		bw.close();

	}}
