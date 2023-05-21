package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int idx = 10;
		
		while( n > idx ) {
			n = (n + (idx/10*5) ) / idx * idx;
			idx *= 10;
		}
		
		bw.write(n + "");

		bw.flush();
		bw.close();
	}
}
