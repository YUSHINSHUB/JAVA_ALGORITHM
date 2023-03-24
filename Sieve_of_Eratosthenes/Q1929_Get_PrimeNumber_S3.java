package Sieve_of_Eratosthenes;

import java.io.*;
import java.util.*;

public class Q1929_Get_PrimeNumber_S3 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String nums[] = br.readLine().split(" ");
		
		int s = Integer.parseInt(nums[0]);
		int e = Integer.parseInt(nums[1]);
		
		boolean res[] = new boolean[e+1];
		// res[i]기 true일 경우 i는 소수가 아니다
		
		for( int i = 2 ; i <= e ; i += 2 ) {
			res[i] = true;
			//2를 제외한 짝수는 모두 소수가 아님.
		}
		
		for( int i = 3 ; i <= e ; i += 2 ) {
			if( !res[i] ) {
				for( int z = i*2 ; z <= e ; z += i ) {
					res[z] = true;
					//소수가 아닌 값들은 어떤 소수의 배수이다.
					// 그러므로 res[z]가 true가 아닌 z의 모든 배수를 true (소수가 아닌것으로 확정)로 해주면
					// 소거법으로 소수만 남는다.
				}
			}
		}
		
		res[1] = true;
		res[2] = false;
		
		for( int i = s ; i <= e ; i++ ) {
			if( !res[i] ) bw.write(String.valueOf(i) + "\n");
		}
		
		
		
		
		bw.flush();
		bw.close();
		
}}
