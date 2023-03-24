package Arithmetic;
import java.io.*;

public class Q2588_Multiplication_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		bw.write( a * (b % 10) + "\n");
		// a % b 는 a를 b로 나눈 나머지를 구해주는 연산자이다.
		bw.write( a * ( b % 100 / 10 ) + "\n" );
		bw.write( a * ( b / 100 ) + "\n" );
		// 괄호안의 값은 각각 b의 셋쨰자리 수, 둘쨰자리 수, 첫쨰자리 수를 의미한다.
		bw.write( a * b + "\n");
		
		bw.flush();
		bw.close();

	}

}
