package Hashing;

import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Q15829_Hashing_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int n = Integer.parseInt(br.readLine());
		String in = br.readLine();
		long res = 0;
		long temp = 1;
		
		for( int i = 0 ; i < n ; i++ ) {
			res += ((int)(in.charAt(i) - 96) * temp) % 1234567891;
			temp = temp * 31 % 1234567891;
		}
		//나머지를 구하는 모듈러 연산 (mod)의 성질
		// (a * b) mod M = ( (a mod M) * (b mod M) ) mod M 
		// 31의 n제곱은 지수에 따라서 int 혹은 long의 범위를 아득히 넘어가기 때문에 모듈러 연산의 성질을 활용해야 한다.
		
		bw.write(String.valueOf(res%1234567891));
		//(a + b) mod M = ( (a mod M) + (b mod M) ) mod M 을 활용한 것이기 때문에 마지막에 모듈러 연산을 한번더 해줘야 한다. 
		
		bw.flush();
		bw.close();
}
}
