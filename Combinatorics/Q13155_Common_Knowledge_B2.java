package Combinatorics;

import java.io.*;

public class Q13155_Common_Knowledge_B2 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		long a = 1;
		long b = 1;
		
		//��ܺΰ� �ٸ� ���ڿ� �ߺ����� �ʴ� ���ڴ� 0, 1, 4, 7 �װ��̴�. �׷��Ƿ� Bob�� ���ھ�尡 
		// 'Fully Known' ���°� �Ǳ� ���� ������ ����� ���� 4�� n�����̴�.
		//���� ������ �ϴܺΰ� �ߺ����� �ʴ� ���ڴ� 0, 2 �ΰ��̴�. �׷��Ƿ� Alice�� ����� ���� 2�� n�����̴�.
		// ������ Bob�� Alice�� ���ھ���� ������ 4�� n���� * 2�� n������ �ȴ�.
		for( int i = 0 ; i < n ; i++ ) {
			a *= 4;
			b *= 2;
		}
		
		bw.write( (a*b) + "" );
		bw.flush();
		bw.close();
		
	}
}
