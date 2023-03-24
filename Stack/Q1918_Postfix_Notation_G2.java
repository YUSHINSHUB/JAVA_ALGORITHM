package Stack;

import java.io.*;
import java.util.*;

public class Q1918_Postfix_Notation_G2 {
	
	public static int check(char c) {
		if( c == '/' || c == '*' ) {
			return 3;
		}else if( c == '+' || c == '-' ) {
			return 2;
		}else {
			return 1;
		}
		//연산자의 우선순위를 반환하는 메소드. 나누기, 곱셈이 가장 우선순위가 높고 +, -가 그 다음이다.
		// (가 들어올 수도 있기 떄문에 그 경우에는 가장 낮은 1을 반환한다.
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		Stack<Character> stk = new Stack<Character>();
		StringBuilder sb = new StringBuilder("");
		//연산자는 스택에 우선 담은 후 우선순위에 따라 결과값 sb에 담아주고 
		// 피연산자는 순서대로 결과값에 담아준다.
		
		for( int i = 0 ; i < s.length() ; i++ ) {
			if( (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
				sb.append(s.charAt(i));
				//A~Z는 순서대로 담아주면 된다.
			}else if( s.charAt(i) == '(') {
				stk.push(s.charAt(i));
			}else if( s.charAt(i) == ')') {
				while( stk.peek() != '(') {
					sb.append(stk.pop());
					//괄호가 끝나는 )를 만날경우 스택에서 괄호 내부의 연산자를 꺼낸 후
				}
				stk.pop();
				// 스택의 (를 제거한다.
			}else {
				while( !stk.isEmpty() && check(stk.peek()) >= check(s.charAt(i)) ) {
					sb.append(stk.pop());
					//스택에 먼저 담겨있던 연산자의 우선순위가 높을 경우 스택의 연산자를 먼저 꺼낸 후에 다음 연산자를 append해준다.
					//예시: *가 +보다 먼저 스택에 들어가 있을 경우에 *의 우선순위(3)가 +의 우선순위(2)보다 더 높기때문에 *부터 결과값으로
					//꺼내줘서 최종적으로 AB*+와 같은 형태가 되게 만든다.
				}
				stk.push(s.charAt(i));
			}
		}
		while( !stk.isEmpty() ) {
			sb.append(stk.pop());
			//스택 내에 남아있는 연산자들을 모두 결과값으로 꺼내준다.
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
}}
