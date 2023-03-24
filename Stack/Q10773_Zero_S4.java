package Stack;

import java.io.*;
import java.math.BigInteger;
import java.util.*;



public class Q10773_Zero_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int k = Integer.parseInt(br.readLine());
		int res = 0;
		
		Stack<Integer> stk = new Stack<Integer>();
		
		for( int i = 0 ; i < k ; i++ ) {
			int temp = Integer.parseInt(br.readLine());
			if( temp == 0 ) stk.pop();
			else stk.push(temp);
		}
		
		while( !stk.isEmpty() ) {
			res += stk.pop();
		}
		
		bw.write(res + "");
		
		bw.flush();
		bw.close();
	}
}
