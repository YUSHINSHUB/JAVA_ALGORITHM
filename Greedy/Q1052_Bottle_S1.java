package Greedy;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1052_Bottle_S1 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String in[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(in[0]);
		int k = Integer.parseInt(in[1]);
		
		int cnt = 0; //n���� 2�� ������ ������ ������ Ȧ���� ����
		
		Queue<Integer> q = new LinkedList<Integer>(); // Ȧ�� ����
		int res = n;
		
		int n2 = n;
		while( n2 != 0 ) {
			if( n2 % 2 == 0 ) {
				n2 /= 2;
			}else {
				q.offer(n2); 
				n2 /= 2;
				cnt++; //n�� Ȧ���� ������ ���Űܴ�� ���� �ϳ��� �����.
			}
		}
		
		if( cnt > k ) {
			cnt -= k;
			for( int i = 0 ; i < cnt ; i++ ) q.poll(); //cnt-k��°�� ū Ȧ������ q���� ���� �� �� �ں��� �����Ѵ�.
			while( !q.isEmpty() ) {
				int temp = q.poll();
				temp++;
				while( temp < n ) {
					temp *= 2;
				}
				res = Math.min(temp-n, res);
			}
		}else res = 0;
		
		bw.write(res + "");
		
		
		bw.flush();
		bw.close();
	}
}
