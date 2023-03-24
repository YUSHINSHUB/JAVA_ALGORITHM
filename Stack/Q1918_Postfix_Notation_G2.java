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
		//�������� �켱������ ��ȯ�ϴ� �޼ҵ�. ������, ������ ���� �켱������ ���� +, -�� �� �����̴�.
		// (�� ���� ���� �ֱ� ������ �� ��쿡�� ���� ���� 1�� ��ȯ�Ѵ�.
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		Stack<Character> stk = new Stack<Character>();
		StringBuilder sb = new StringBuilder("");
		//�����ڴ� ���ÿ� �켱 ���� �� �켱������ ���� ����� sb�� ����ְ� 
		// �ǿ����ڴ� ������� ������� ����ش�.
		
		for( int i = 0 ; i < s.length() ; i++ ) {
			if( (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
				sb.append(s.charAt(i));
				//A~Z�� ������� ����ָ� �ȴ�.
			}else if( s.charAt(i) == '(') {
				stk.push(s.charAt(i));
			}else if( s.charAt(i) == ')') {
				while( stk.peek() != '(') {
					sb.append(stk.pop());
					//��ȣ�� ������ )�� ������� ���ÿ��� ��ȣ ������ �����ڸ� ���� ��
				}
				stk.pop();
				// ������ (�� �����Ѵ�.
			}else {
				while( !stk.isEmpty() && check(stk.peek()) >= check(s.charAt(i)) ) {
					sb.append(stk.pop());
					//���ÿ� ���� ����ִ� �������� �켱������ ���� ��� ������ �����ڸ� ���� ���� �Ŀ� ���� �����ڸ� append���ش�.
					//����: *�� +���� ���� ���ÿ� �� ���� ��쿡 *�� �켱����(3)�� +�� �켱����(2)���� �� ���⶧���� *���� ���������
					//�����༭ ���������� AB*+�� ���� ���°� �ǰ� �����.
				}
				stk.push(s.charAt(i));
			}
		}
		while( !stk.isEmpty() ) {
			sb.append(stk.pop());
			//���� ���� �����ִ� �����ڵ��� ��� ��������� �����ش�.
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
}}
