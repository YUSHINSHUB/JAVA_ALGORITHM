package Bruteforcing;

import java.io.*;
import java.util.*;


public class Q2309_Seven_Dwarfs_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] in = new int[9];
		int sum = 0;
		boolean chk = false;
		
		for( int i = 0 ; i < 9 ; i++ ) {
			in[i] = Integer.parseInt(br.readLine());
			sum += in[i];
		}
		
		for( int i = 0 ; i < 9 ; i++ ) {
			for( int z = i+1 ; z < 9 ; z++ ) {
				if( in[i] + in[z] == sum - 100 ) {
					in[i] = 0;
					in[z] = 0;
					chk = true;
					break;
				}
			}
			if( chk == true ) {
				break;
			}
		}
		
		Arrays.sort(in);
		
		for( int i = 2 ; i < 9 ; i++ ) {
			bw.write(in[i] + "\n");
		}
		
			
		bw.flush();
		bw.close();
	
}
}