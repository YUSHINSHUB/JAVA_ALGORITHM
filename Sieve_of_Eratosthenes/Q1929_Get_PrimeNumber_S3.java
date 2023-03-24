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
		// res[i]�� true�� ��� i�� �Ҽ��� �ƴϴ�
		
		for( int i = 2 ; i <= e ; i += 2 ) {
			res[i] = true;
			//2�� ������ ¦���� ��� �Ҽ��� �ƴ�.
		}
		
		for( int i = 3 ; i <= e ; i += 2 ) {
			if( !res[i] ) {
				for( int z = i*2 ; z <= e ; z += i ) {
					res[z] = true;
					//�Ҽ��� �ƴ� ������ � �Ҽ��� ����̴�.
					// �׷��Ƿ� res[z]�� true�� �ƴ� z�� ��� ����� true (�Ҽ��� �ƴѰ����� Ȯ��)�� ���ָ�
					// �ҰŹ����� �Ҽ��� ���´�.
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
