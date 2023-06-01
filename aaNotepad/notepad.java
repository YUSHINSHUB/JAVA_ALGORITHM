package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String inp[] = br.readLine().split(" ");
			String a = inp[0];
			String b = inp[1];

			if (a.length() < b.length()) {
				String temp = a;
				a = b;
				b = temp;
			}

			StringBuilder abu = new StringBuilder(a);
			StringBuilder bbu = new StringBuilder(b);

			abu.reverse();
			abu.append("0");
			bbu.reverse();
			while( bbu.length() != abu.length() ) bbu.append("0");
			
			int mod = 0, add = 0;

			for (int j = 0; j < bbu.length(); j++) {
				add = (abu.charAt(j) - '0') + (bbu.charAt(j) - '0')+mod;
				abu.setCharAt(j, (char)( (add%2)+ '0' ) );
				mod = add / 2;
			}

			abu.reverse();
			
			while( abu.length() != 1 ) {
				if (abu.charAt(0) == '0')
					abu.deleteCharAt(0);
				else
					break;
			}

			bw.write(abu.toString() + "\n");

		}

		bw.flush();
		bw.close();
	}
}
