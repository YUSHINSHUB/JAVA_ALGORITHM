package Arbitrary_Precision_Big_Integers;

import java.io.*;
import java.math.*;

public class Q5893_Mul_17_B3 {
	


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String bin = br.readLine();
		String sev = "10001";
		//17�� ������
		
		BigInteger bi = new BigInteger(bin, 2);
		BigInteger bs = new BigInteger(sev, 2);
		//int�� �����ϰ� 2�������� ��ȯ���ִ� �޼ҵ尡 ���������� �ڸ����� �Ѱ谡 �ֱ� ������ string -> BigInteger�� Ȱ���Ѵ�.
		
		bi = bi.multiply(bs);
		String out = "";
		
		while( bi.compareTo(new BigInteger("0")) == 1 ) {
			out = out + bi.mod(new BigInteger("2")).toString();
			bi = bi.divide(new BigInteger("2"));
		}
		//BigInteger�� ����޼ҵ带 ����ϸ� 10���� ������� �����ϱ� ������ 2�������� ��ȯ�ϴ� �˰����� �����Ͽ� 
		// out�� ���� ���ش�.
		
		StringBuilder sb = new StringBuilder(out);
		out = sb.reverse().toString();
		//���� ����� ����� ��� �Ųٷ� ���� ������ StringBuilder��  reverse�޼ҵ带 ����Ͽ� �������ش�.
		
		bw.write(out);
		
		bw.flush();
		bw.close();

	}

}