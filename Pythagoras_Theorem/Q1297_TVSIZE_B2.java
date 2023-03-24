package Pythagoras_Theorem;

import java.io.*;

public class Q1297_TVSIZE_B2 {

		public static void main(String[] args) throws IOException{
			// TODO Auto-generated method stub
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String str[] = br.readLine().split(" ");
			int    inp[] = new int[3];
			
			for( int i = 0 ; i < 3 ; i++) {
				inp[i] = Integer.parseInt(str[i]);
			}
			
			Double index = Math.sqrt(Math.pow(inp[0], 2) / ( Math.pow(inp[1], 2) + Math.pow(inp[2], 2) ));
			//java.lang 패키지의 Math클래스의 메소드 sqrt를 사용하면 루트 (제곱근) 값을 반환한다. pow(x, y)는 x의 y제곱을 반환한다.
			// 소수점까지 포함하여 Double 형태로 반환된다.
			
			bw.write(String.valueOf((int)(index * inp[1])) + " " + String.valueOf((int)(index * inp[2])));
			// 소수점은 뺴야되기 떄문에 (int)를 사용하여 형변환 해준다.
			
			bw.flush();
			bw.close();
			
		}


}
