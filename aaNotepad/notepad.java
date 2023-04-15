package aaNotepad;

import java.io.*;
import java.util.*;
import java.text.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int stick[] = new int[n];
		int hig = 0;
		int res = 0;
		
		for( int i = 0 ; i < n ; i++ ) {
			stick[i] = Integer.parseInt(br.readLine());
		}
		
		for( int i = n-1 ; i >= 0 ; i-- ) {
			if( stick[i] > hig ) {
				hig = stick[i];
				res++;
			}
		}
		
		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}
