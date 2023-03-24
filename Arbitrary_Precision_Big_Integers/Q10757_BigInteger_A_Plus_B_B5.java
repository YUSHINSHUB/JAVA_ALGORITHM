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
				//int의 범위는 -2,147,483,648 ~ 2,147,483,647, 
				//long의 범위는 -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807이다. 
				//해당 문제는 9,223,372,036,854,775,808을 연산해야 하기 때문에 long의 범위를 초과한다.
				//그러므로 java.math 패키지의 BigInteger 클래스를 사용한다.
				//BigInteger은 문자열의 형태로 이루어져 있어 숫자의 범위가 무한하다.
				
				a = a.add(b);
				//BigInteger의 연산메소드: add (더하기), subtract (빼기), multiply (곱하기), divide (몫구하기), mod (나머자구하기)
				
				
				bw.write(String.valueOf( a ) );

				
				bw.flush();
				bw.close();
	}

}
