package Arithmetic;

import java.io.*;

public class Q10950_AplusB_3_B5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int rep = Integer.parseInt(br.readLine());
		int res = 0;
		int[] out = new int[rep];
		//�迭�� ����. �ش� �ڵ忡���� rep�� ���� ���̷� ���� Integer ������ �迭�� ����Ǿ���.
		//�迭�� �� ����� ���� ���� �����ϰ� ���������� int[] out = {1, 2, 3, 4, 5}; ó�� �����ϸ� �ȴ�.
		
		for( int a = 0 ; a < rep ; a++ ) {
			
			String terms[] = br.readLine().split(" ");

			for( int b = 0 ; b < terms.length ; b++ ) {
				
				res = res + Integer.parseInt(terms[b]);
				
			}
			//�ش� ������ �ΰ��� �׸� �Է¹����� ������ �� �������� ���� ó���� �� �ֵ��� code�� �����Ͽ���.
			
			out[a] = res;
			res = 0;
		}
		//�迭 out[]�� �� ��ҿ� ������� ������� �������ִ� �ݺ���
		
		for( int a = 0 ; a < rep ; a++ ) {
			bw.write(out[a] + "\n");
		}
		// ��� �Է� -> ��� ����� ������� ����Ǿ� �ϱ� ������ ��/��� �ݺ����� ���� �ξ���.
		
		bw.flush();
		bw.close();
		
	}

}
