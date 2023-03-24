package String;

import java.io.*;
import java.util.*;

public class Q1212_OctalToBinary_B2 {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String n = br.readLine();
		String temp;
		StringBuilder res = new StringBuilder();
		//일반 String을 사용하여 append 대신 + 연산자를 사용해도 되지만 그럴경우 해당 문제에서는 시간초과가 발생하므로 
		// 더 효율좋은 StringBuilder의 append 메소드를 활용한다.
		
		for( int i = 0 ; i < n.length() ; i++ ) {
			temp = Integer.toBinaryString(Integer.parseInt(String.valueOf(n.charAt(i))));
			// JAVA에는 Integer 클래스에 정수를 문자열형태 이진수로 변환해주는 메소드인 toBinaryString()이 존재한다.
			
			
			if( i != 0 ) {
			switch (temp.length()){
			case 1:
				res.append("00" + temp);
				break;
			case 2:
				res.append("0" + temp);
				break;
				default:
					res.append(temp);
			}
			}else {
				res.append(temp);
			}
		}
		
		// 8은 2의 세제곱이기 떄문에 8진수에서 2진수로 변환할 경우 8진수의 각 자릿수가 2진수에서는 세자리의 수로 치환된다.
		// ex) 8 -> 111    1 -> 001
		
		
		
		bw.write(res.toString());
		
		bw.flush();
		bw.close();
		
	}
}
