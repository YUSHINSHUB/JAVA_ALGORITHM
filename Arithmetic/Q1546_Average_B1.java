package Arithmetic;

import java.io.*;
import java.util.*;



public class Q1546_Average_B1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		float scr[] = new float[n];
		float sum = 0;
		float max = 0;
		
		
		for( int i = 0 ; i < n ; i++ ) {
			scr[i] = Integer.parseInt(st.nextToken());
			if( max < scr[i] ) {
				max = scr[i];
			}
		}
		
		for( int i = 0 ; i < n ; i++ ) {
			sum = sum + ( (scr[i] / max) * 100 );
			//sum이 float형이라도 scr[i]가 int형이라면 나누기의 결과값이 정수형태로 산출되기 때문에 알맞은 결과를 얻을 수 없다.
		}
		
		float avr = sum / n;
		
		bw.write(String.valueOf(avr));
		//avr의 결과값을 문자열 형태로 출력
		
		bw.flush();
		bw.close();
		

	}

}
