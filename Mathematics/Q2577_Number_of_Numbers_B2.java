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
		// int -> string 형변환은 String 클래스의 valueOf 메소드 사용
		
		int arr[] = new int[10];
		
		for ( int i = 0 ; i < str.length() ; i++ ) {
			++arr[Character.getNumericValue(str.charAt(i))];
			//Char -> Int 형변환은 Character 클래스의 getNumericValue 메소드 사용
		}
		
		for( int i = 0 ; i < 10 ; i++ ) {
			bw.write( String.valueOf(arr[i]) + '\n' );
			// BufferedWriter은 정수 출력시 오류가 나는 경우가 있다. String 클래스의 valueOf 메소드를 사용하여
			// int -> string 형변환을 해주면 해결가능.
		}
		
		bw.flush();
		bw.close();
		
	}

}