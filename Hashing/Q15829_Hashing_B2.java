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
		//�������� ���ϴ� ��ⷯ ���� (mod)�� ����
		// (a * b) mod M = ( (a mod M) * (b mod M) ) mod M 
		// 31�� n������ ������ ���� int Ȥ�� long�� ������ �Ƶ��� �Ѿ�� ������ ��ⷯ ������ ������ Ȱ���ؾ� �Ѵ�.
		
		bw.write(String.valueOf(res%1234567891));
		//(a + b) mod M = ( (a mod M) + (b mod M) ) mod M �� Ȱ���� ���̱� ������ �������� ��ⷯ ������ �ѹ��� ����� �Ѵ�. 
		
		bw.flush();
		bw.close();
}
}
