package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		HashSet<String> hs = new HashSet<>();
		String in;
		int res = 0;

		for (int i = 0; i < n; i++) {
			in = br.readLine();
			if (!in.equals("ENTER")) {
				hs.add(in);
			} else {
				res += hs.size();
				hs.clear();
			}
		}

		res += hs.size();
		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}