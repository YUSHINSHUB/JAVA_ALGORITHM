package Data_Structures;

import java.io.*;
import java.util.*;



public class Q1935_Postfix_Notation_2_S3 {
	
	static double calc(double a, double b, char c) {
		switch(c) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;
			default:
				return 0;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		double temp1 = 0;
		double temp2 = 0;
		
		int index = 0;
		
		
		Stack<Double> stk = new Stack();
		
		double nums[] = new double[n+1];
		
		for( int i = 0 ; i < n ; i++ ) {
			nums[i] = Double.parseDouble(br.readLine());
		}
		
		for( int i = 0 ; i < s.length() ; i++ ) {
			if( s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' ) {
				stk.push(nums[(s.charAt(i) - 65)]);
			}else {
				temp2 = stk.pop();
				temp1 = stk.pop();
				stk.push(calc(temp1, temp2, s.charAt(i)));
			}
		}
		
		
		double res = stk.pop();
		
		bw.write(String.format("%.2f", res));
		
		bw.flush();
		bw.close();
		
}
	
}
