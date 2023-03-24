package Implementation;

import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Q1076_Resistor_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = 0;
		String[] inp = new String[3];
		String res = "";
		
		for( int i = 0 ; i < 3 ; i++ ) {
			inp[i] = br.readLine();
		}
		
		while( cnt <= 2 ) {
			if( inp[cnt].equals("black") ) {
				if( cnt == 2 ) {
				}else {
					res += "0";
				}
			}else if( inp[cnt].equals("brown") ) {
				if( cnt == 2 ) {
					res += "0";
				}else {
					res += "1";
				}
			}else if( inp[cnt].equals("red") ) {
				if( cnt == 2 ) {
					res += "00";
				}else {
					res += "2";
				}
			}else if( inp[cnt].equals("orange") ) {
				if( cnt == 2 ) {
					res += "000";
				}else {
					res += "3";
				}
			}else if( inp[cnt].equals("yellow") ) {
				if( cnt == 2 ) {
					res += "0000";
				}else {
					res += "4";
				}
			}else if( inp[cnt].equals("green") ) {
				if( cnt == 2 ) {
					res += "00000";
				}else {
					res += "5";
				}
			}else if( inp[cnt].equals("blue") ) {
				if( cnt == 2 ) {
					res += "000000";
				}else {
					res += "6";
				}
			}else if( inp[cnt].equals("violet") ) {
				if( cnt == 2 ) {
					res += "0000000";
				}else {
					res += "7";
				}
			}else if( inp[cnt].equals("grey") ) {
				if( cnt == 2 ) {
					res += "00000000";
				}else {
					res += "8";
				}
			}else if( inp[cnt].equals("white") ) {
				if( cnt == 2 ) {
					res += "000000000";
				}else {
					res += "9";
				}
			}
			cnt++;
		}
		
		
		while( res.charAt(0) == '0' ) {
			StringBuilder sbres = new StringBuilder(res);
			if( res.length() == 1 ) {
				break;
			}
			int temp = res.length() - 1;
			res = "";
			for( int i = 1 ; i <= temp ; i++ ) {
				sbres.setCharAt(i-1, sbres.charAt(i));
				//StringBuilder의 setCharAt 메소드를 사용하면 특정 index의 문자를 수정하는 것이 가능하다.
				//이를 이용해서 문자열을 왼쪽으로 당겨주었다.
			}
			for( int i = 0 ; i < temp ; i++ ) {
				res += sbres.charAt(i);
				//왼쪽으로 당긴 후 마지막 문자는 중복되기 때문에 빼야한다.
				//그러므로 length() - 2 지점 까지만 대입해주면 된다.
			}
		}
		
		bw.write(res);
		
		bw.flush();
		bw.close();
		
}
	
}
