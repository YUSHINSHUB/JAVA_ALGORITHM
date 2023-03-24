package Implementation;

import java.io.*;
import java.math.*;

public class Q14935_FA_B4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		String s1 = "";
		s1 += s.charAt(0);
		//Integer.parseInt에 매개변수로 char타입이 들어갈 수 없기 때문에 빈 문자열 s1에 s의 첫자리 수를 담아준다.
		
		int fa = s.length() * Integer.parseInt(s1);
		
		while( fa / 10 != 0 ) {
			fa = ( fa / 10 ) * (int)(Math.log10(fa) + 1);
			//logx(a)는 x로 a를 표현하려면 몇제곱을 해야하는지를 반환한다. x가 10일경우 10의 n제곱이기 때문에
			// 1을 더하고 int형으로 치환하여 1을 더하면 a의 자릿수가 나온다.
			// https://namu.wiki/w/%EB%A1%9C%EA%B7%B8%ED%95%A8%EC%88%98 꺼무위키 참고
		}
		
		if( fa / 10 == 0 ) {
			bw.write("FA");
		}else {
			bw.write("NFA");
		}
		
		bw.flush();
		bw.close();

	}

}
