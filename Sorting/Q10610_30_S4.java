package Sorting;

import java.io.*;
import java.math.*;
import java.util.*;



public class Q10610_30_S4 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String in[] = br.readLine().split("");
		String str = "";
		
		Arrays.sort(in, Collections.reverseOrder());
		for( int i = 0 ; i < in.length ; i++ ) str += in[i];
		
		int cnt = 0;
		int pl = 2;
		int t = 0;
		String temp = "";
		
		while( cnt + 6 < str.length() ) {
			temp += str.substring(cnt, cnt+6);
			//문자열.substring(시작점 ,끝점)
			t = Integer.parseInt(temp);
			t %= 30;
			if( t == 0 ) temp = "";
			else temp = t + "";
			cnt += 6;
		}
		
		temp += str.substring(cnt);
		t = Integer.parseInt(temp);
		t %= 30;
		
		if( t == 0 ) bw.write(str);
		else bw.write("-1");
		
		bw.flush();
		bw.close();
	}
}
