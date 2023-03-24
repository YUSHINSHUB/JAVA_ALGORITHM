package Sorting;

import java.io.*;
import java.math.BigInteger;
import java.util.*;



public class Q1181_Sort_Words_S5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String in[] = new String[n];

		for( int i = 0 ; i < n ; i++ ) in[i] = br.readLine();
		
		HashSet<String> temp = new HashSet<String>(Arrays.asList(in));
		//HashSet은 중복되는 값이 들어가지 않는다. 이를 응용해서 Array -> Set -> Array순으로 변환해주면 중복값이 제거된다.
		
		in = temp.toArray(new String[0]);
		
		Arrays.sort(in, (o1, o2) ->{
			if( o1.length() == o2.length() ) {
				for( int i = 0 ; i < o1.length() ; i++ ) {
					if( o1.charAt(i) != o2.charAt(i) ) return Integer.compare(o1.charAt(i), o2.charAt(i));
				}
			}
			return Integer.compare(o1.length(), o2.length());
		});
		
		for( int i = 0 ; i < in.length ; i++ ) {
			bw.write(in[i] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
