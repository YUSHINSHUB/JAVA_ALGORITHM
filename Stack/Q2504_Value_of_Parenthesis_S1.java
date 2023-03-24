package Stack;

import java.io.*;
import java.math.BigInteger;
import java.util.*;



public class Q2504_Value_of_Parenthesis_S1 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String in = br.readLine();
		
		Stack<Character> stk = new Stack<Character>();
		
		int res = 0;
		int mul = 1;

		// a(b+c) = ab + ac 가 되는 분배법칙을 응용하여 mul에 곱할 값을 저장해둔 후 
		// 괄호가 () [] 의 형태로 닫힐떄 마다 모두 곱하여 구한다.
		for( int i = 0 ; i < in.length() ; i++ ) {
			if( in.charAt(i) == '(' ) {
					mul *= 2;
					stk.push(in.charAt(i));
			}else if( in.charAt(i) == '[' ) {
					mul *= 3;
					stk.push(in.charAt(i));
			}else if( in.charAt(i) == ')' ) {
				if( stk.isEmpty() || stk.peek() == '[' ) {
					res = 0;
					break;
				}else if( in.charAt(i-1) == '(' ) {
				mul /= 2;
				res += 2 * mul;
				stk.pop();
				}else {
					mul /= 2;
					stk.pop();
				}
			}else if( in.charAt(i) == ']' ) {
				if( stk.isEmpty() || stk.peek() == '(' ) {
					res = 0;
					break;
				}else if( in.charAt(i-1) == '[' ) {
					mul /= 3;
					res += 3 * mul;
					stk.pop();
				}else {
						mul /= 3;
						stk.pop();
				}
			}
		}
		
		if( !stk.isEmpty() ) res = 0;
		
		bw.write(String.valueOf(res));
		
		bw.flush();
		bw.close();
	}
}
