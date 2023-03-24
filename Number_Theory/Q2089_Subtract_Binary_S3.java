// -2진수

package Number_Theory;

import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Q2089_Subtract_Binary_S3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// https://m.blog.naver.com/dylan0301/221785998279 참고
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int num = Integer.parseInt(br.readLine());
		int temp = 0;
		int mul = 1;
		String res = "";
		String resrev = "";
		
		if( num == 0 ) {
			res = "0";
		}else {
			while(true) {
			if( num != 0 ) {
				if( num > 0 ) {
					res += num % 2;
					num = 0 - (num / 2);
				}else {
					temp = num;
					while( temp % 2 != 0 ) {
						temp--;
					}
					res += String.valueOf(num - temp);
					num = 0 - (temp / 2);
				}
			}else {
				break;
			}
		}
			
		}
		
		for( int i = res.length()-1 ; i >= 0 ; i-- ) {
			resrev += res.charAt(i);
		}
		
		bw.write(resrev);
		
		bw.flush();
		bw.close();
		
}
	
}
