package Geometry;

import java.io.*;
import java.math.*;
import java.util.*;



public class Q16600_Contemporary_Art_B4 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long n = Long.parseLong(br.readLine());
		
		double d = Math.sqrt(n);
		d *= 4;
		
		bw.write(Math.round(d * 10000000) / 10000000.0 + "");
		//소수점 아래 7자리 이후로는 반올림한다.
		
		bw.flush();
		bw.close();
	}
}
