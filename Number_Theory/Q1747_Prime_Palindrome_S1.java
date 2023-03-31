package Number_Theory;

import java.io.*;


public class Q1747_Prime_Palindrome_S1 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int res = 0;
		
		boolean chk[] = new boolean[1003002];
		boolean end = false;
		
		chk[0] = true;
		chk[1] = true;
		chk[2] = false;
		
		for( int i = 4 ; i <= 1003001 ; i+=2 ) chk[i] = true;
		
		for( int i = 3 ; i <= 1003001 ; i+=2 ) {
			if( chk[i] == false ) {
				for( int z = i*2 ; z <= 1003001 ; z += i ) chk[z] = true;
			}
		}
		
		if( n <= 2 ) res = 2;
		else {
		if( n % 2 == 0) n++;
		
		for( int i = n ; i <= 1003001 ; i+=2 ) {
			if( chk[i] == false ) { 
				end = true;
				String temp = String.valueOf(i);
				for( int z = 0 ; z < temp.length()/2 ; z++ ) {
					if( temp.charAt(z) != temp.charAt(temp.length()-1-z) ) {
						end = false;
						break;
					}
				}
				if( end == true ) {
					res = Integer.parseInt(temp);
					break;
				}
			}
		}
		}
		
		bw.write(String.valueOf(res));
		
		bw.flush();
		bw.close();
	}
}