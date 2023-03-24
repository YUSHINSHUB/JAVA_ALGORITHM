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
				//StringBuilder�� setCharAt �޼ҵ带 ����ϸ� Ư�� index�� ���ڸ� �����ϴ� ���� �����ϴ�.
				//�̸� �̿��ؼ� ���ڿ��� �������� ����־���.
			}
			for( int i = 0 ; i < temp ; i++ ) {
				res += sbres.charAt(i);
				//�������� ��� �� ������ ���ڴ� �ߺ��Ǳ� ������ �����Ѵ�.
				//�׷��Ƿ� length() - 2 ���� ������ �������ָ� �ȴ�.
			}
		}
		
		bw.write(res);
		
		bw.flush();
		bw.close();
		
}
	
}
