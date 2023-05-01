package aaNotepad;

import java.io.*;
import java.util.*;
import java.text.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		ArrayList<String> list = new ArrayList<String>();
		
		for( int i = 0 ; i < s.length()-2 ; i++ ) {
			for( int j = i+1 ; j < s.length()-1 ; j++ ) {
					StringBuilder a = new StringBuilder(s.substring(0, i+1)).reverse();
					StringBuilder b = new StringBuilder(s.substring(i+1, j+1)).reverse();
					StringBuilder c = new StringBuilder(s.substring(j+1, s.length())).reverse();
					a.append(b);
					a.append(c);
					list.add(a.toString());
			}
		}
		
		Collections.sort(list);
		
		bw.write(list.get(0));

		bw.flush();
		bw.close();
	}
}
