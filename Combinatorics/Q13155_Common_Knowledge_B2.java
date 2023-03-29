package Combinatorics;

import java.io.*;

public class Q13155_Common_Knowledge_B2 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		long a = 1;
		long b = 1;
		
		//상단부가 다른 숫자와 중복되지 않는 숫자는 0, 1, 4, 7 네개이다. 그러므로 Bob의 스코어보드가 
		// 'Fully Known' 상태가 되기 위해 가능한 경우의 수는 4의 n제곱이다.
		//같은 원리로 하단부가 중복되지 않는 숫자는 0, 2 두개이다. 그러므로 Alice의 경우의 수는 2의 n제곱이다.
		// 가능한 Bob과 Alice의 스코어보드의 조합은 4의 n제곱 * 2의 n제곱이 된다.
		for( int i = 0 ; i < n ; i++ ) {
			a *= 4;
			b *= 2;
		}
		
		bw.write( (a*b) + "" );
		bw.flush();
		bw.close();
		
	}
}
