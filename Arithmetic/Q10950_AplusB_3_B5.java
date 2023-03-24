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
		//배열의 선언. 해당 코드에서는 rep의 값을 길이로 갖는 Integer 형태의 배열이 선언되었다.
		//배열의 각 요소의 값을 직접 대입하고 싶을떄에는 int[] out = {1, 2, 3, 4, 5}; 처럼 선언하면 된다.
		
		for( int a = 0 ; a < rep ; a++ ) {
			
			String terms[] = br.readLine().split(" ");

			for( int b = 0 ; b < terms.length ; b++ ) {
				
				res = res + Integer.parseInt(terms[b]);
				
			}
			//해당 문제는 두개의 항만 입력받으면 되지만 더 많은수의 항을 처리할 수 있도록 code를 구성하였다.
			
			out[a] = res;
			res = 0;
		}
		//배열 out[]의 각 요소에 출력해줄 결과값을 대입해주는 반복문
		
		for( int a = 0 ; a < rep ; a++ ) {
			bw.write(out[a] + "\n");
		}
		// 모두 입력 -> 모두 출력의 순서대로 진행되야 하기 떄문에 입/출력 반복문을 각각 두었다.
		
		bw.flush();
		bw.close();
		
	}

}
