package Parsing;

import java.io.*;
import java.math.*;
import java.util.*;



public class Q1541_Lost_Bracket_S2 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//파싱이란 구문분석이라고도 하며 일련의 문자열을 의미있는 토큰으로 분해하고 그것들로 이루어진 Parsing Tree로 만드는 과정이다.
		//해당 문제는 더하기를 모두 먼저하고 뺴기를 나중에 하면 해결되기 때문에 - 기호가 나오기 전까지의 수를 모두 더하여 토큰화 한 후 큐에 담아주고
		//이를 첫번째 값에서 하나씩 빼나가면 된다.
		StringBuilder in = new StringBuilder(br.readLine());
		int pos = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		int temp = 0;
		String t = "";
		int st = 0;
		
		
		while(  pos < in.length() ) {
			if( in.charAt(pos) == '-' ) break;
			if( in.charAt(pos) == '+' ) {
				st += Integer.parseInt(t);
				t = "";
			}else {
				t += in.charAt(pos);
			}
			pos++;
		}
		
		if( pos == in.length() ) bw.write( (st + Integer.parseInt(t)) + "");
		else {
		if( in.charAt(pos) == '-' ) {
			st += Integer.parseInt(t);
			t = "";
		}
		pos++;
		
		for( int i = pos ; i < in.length() ; i++ ) {
			if( in.charAt(i) == '+' ) {
				temp += Integer.parseInt(t);
				t = "";
			}else if( in.charAt(i) == '-' ) {
				temp += Integer.parseInt(t);
				t = "";
				q.offer(temp);
				temp = 0;
			}else {
				t += in.charAt(i);
			}
		}
		if( !t.equals("") ) temp += Integer.parseInt(t);
		q.offer(temp);
		
		while( !q.isEmpty() ) {
			st -= q.poll();
		}
		
		bw.write(st + "");
		}
		
		bw.flush();
		bw.close();
	}
}
