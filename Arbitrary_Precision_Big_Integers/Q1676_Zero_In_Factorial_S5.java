package Arbitrary_Precision_Big_Integers;

import java.io.*;
import java.util.*;

public class Q1676_Zero_In_Factorial_S5 {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		char[] fac = new char[3000];
		int index = 10;
		int cnt = 0;
		int temp = 0;
		boolean bp = true;
		
		for( int i = 1 ; i <= n ; i++ ) {
			if( i == 1 ) {
				fac[0] = '1';
			}else {
				for( int z = 0 ; z < fac.length ; z++ ) {
					if( fac[z] == '\0' ) {
						break;
					}
					fac[z] = (char)(((fac[z] - '0') * i) + '0');
					
				}
				bp = true;
				while( bp == true ) {
					bp = false;
					for( int z = 0 ; z < fac.length ; z++ ) {
						if( fac[z] == '\0' ) {
							break;
						}
						if( fac[z] > '9' ) {
							bp = true;
							if( fac[z+1] == '\0') {
								fac[z+1] = '0';
							}
							fac[z+1] += 1;
							fac[z] -= 10;
						}
					}
				}
			}
		}
		
		if( n != 0 ) {
		for( int i = 0 ; i < fac.length ; i++ ) {
			if( fac[i] != '0' ) {
				break;
			}
			cnt++;
		}
		}
		
		bw.write(String.valueOf(cnt));
		
		
		bw.flush();
		bw.close();
		
	}
}
