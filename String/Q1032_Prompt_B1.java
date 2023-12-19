package String;

import java.io.*;
import java.util.*;

public class Q1032_Prompt_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String[] in = new String[n];

		for (int i = 0; i < n; i++) {
			in[i] = br.readLine();
		}

		StringBuilder res = new StringBuilder("");

		for (int i = 0; i < in[0].length(); i++) {
			res.append(in[0].charAt(i));
			for (int z = 1; z < n; z++) {
				if (in[z].charAt(i) != res.charAt(i)) {
					res.setCharAt(i, '?');
					break;
				}
			}
		}

		bw.write(res.toString());

		bw.flush();
		bw.close();

	}
}
