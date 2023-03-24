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
		//17의 이진법
		
		BigInteger bi = new BigInteger(bin, 2);
		BigInteger bs = new BigInteger(sev, 2);
		//int를 간편하게 2진법으로 변환해주는 메소드가 존재하지만 자릿수의 한계가 있기 때문에 string -> BigInteger를 활용한다.
		
		bi = bi.multiply(bs);
		String out = "";
		
		while( bi.compareTo(new BigInteger("0")) == 1 ) {
			out = out + bi.mod(new BigInteger("2")).toString();
			bi = bi.divide(new BigInteger("2"));
		}
		//BigInteger의 연산메소드를 사용하면 10진수 결과값을 리턴하기 때문에 2진법으로 변환하는 알고리즘을 구성하여 
		// out에 들어가게 해준다.
		
		StringBuilder sb = new StringBuilder(out);
		out = sb.reverse().toString();
		//위의 방식을 사용할 경우 거꾸로 들어가기 때문에 StringBuilder의  reverse메소드를 사용하여 뒤집어준다.
		
		bw.write(out);
		
		bw.flush();
		bw.close();

	}

}