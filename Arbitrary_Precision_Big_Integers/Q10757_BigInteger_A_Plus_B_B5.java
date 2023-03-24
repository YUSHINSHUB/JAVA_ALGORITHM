package Arbitrary_Precision_Big_Integers;

import java.io.*;
import java.math.*;

public class Q10757_BigInteger_A_Plus_B_B5 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
				BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
				
				String elm[] = br.readLine().split(" ");
				
				BigInteger a = new BigInteger(elm[0]);
				BigInteger b = new BigInteger(elm[1]);
				//int�� ������ -2,147,483,648 ~ 2,147,483,647, 
				//long�� ������ -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807�̴�. 
				//�ش� ������ 9,223,372,036,854,775,808�� �����ؾ� �ϱ� ������ long�� ������ �ʰ��Ѵ�.
				//�׷��Ƿ� java.math ��Ű���� BigInteger Ŭ������ ����Ѵ�.
				//BigInteger�� ���ڿ��� ���·� �̷���� �־� ������ ������ �����ϴ�.
				
				a = a.add(b);
				//BigInteger�� ����޼ҵ�: add (���ϱ�), subtract (����), multiply (���ϱ�), divide (���ϱ�), mod (�����ڱ��ϱ�)
				
				
				bw.write(String.valueOf( a ) );

				
				bw.flush();
				bw.close();
	}

}
