package Sieve_of_Eratosthenes;

import java.io.*;

public class Q6588_Conjecture_of_Goldbach_S1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean chk[] = new boolean[1000001];
		chk[0] = true;
		chk[1] = true;
		for( int i = 2 ; i <= 1000000 ; i++ ) {
			if( chk[i] != true ) {
				chk[i] = false;
				for( int z = i * 2 ; z <= 1000000 ; z += i ) {
					chk[z] = true;
				}
			}
		}
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if( n == 0 ) {
				break;
			}
			int temp1 = n / 2, temp2 = n / 2;
			if( temp1 % 2 == 0 ) {
				temp1--;
				temp2++;
			}
			int res1 = 0, res2 = 0;
			while(true) {
				if( chk[temp1] == false && chk[temp2] == false ) {
					res1 = temp1; res2 = temp2;
				}
				
				if( temp1 == 3 ) {
					if( res1 == 0 ) {
					bw.write("Goldbach's conjecture is wrong\n");
					break;
					}else {
						bw.write(String.valueOf(n) + " = " + String.valueOf(res1) + " + " + String.valueOf(res2) + "\n");
						break;
					}
				}
				temp1 -= 2;
				temp2 += 2;
			}
			
		}
		
		bw.flush();
		bw.close();
}
	
}
