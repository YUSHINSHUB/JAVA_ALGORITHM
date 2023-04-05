package Implementation;

import java.io.*;

public class Q2577_Number_of_Numbers_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		int res = a * b * c;
		
		String str = String.valueOf(res);
		// int -> string ����ȯ�� String Ŭ������ valueOf �޼ҵ� ���
		
		int arr[] = new int[10];
		
		for ( int i = 0 ; i < str.length() ; i++ ) {
			++arr[Character.getNumericValue(str.charAt(i))];
			//Char -> Int ����ȯ�� Character Ŭ������ getNumericValue �޼ҵ� ���
		}
		
		for( int i = 0 ; i < 10 ; i++ ) {
			bw.write( String.valueOf(arr[i]) + '\n' );
			// BufferedWriter�� ���� ��½� ������ ���� ��찡 �ִ�. String Ŭ������ valueOf �޼ҵ带 ����Ͽ�
			// int -> string ����ȯ�� ���ָ� �ذᰡ��.
		}
		
		bw.flush();
		bw.close();
		
	}

}