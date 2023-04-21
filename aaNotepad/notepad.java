package aaNotepad;

import java.io.*;
import java.util.*;
import java.text.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String pas = br.readLine();
		String res = "";

		for (int i = 0; i < pas.length(); i++) {
			char c = (char) ((int) (pas.charAt(i)) - 3);
			if (c < 'A')
				c = (char) ('Z' + (c - 'A') + 1);
			res += c;
		}

		bw.write(res);

		bw.flush();
		bw.close();

	}
}
