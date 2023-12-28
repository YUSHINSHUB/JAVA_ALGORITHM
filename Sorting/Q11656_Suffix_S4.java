package Sorting;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q11656_Suffix_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in = br.readLine();
		String sr[] = new String[in.length()];

		for (int i = 0; i < in.length(); i++) {
			sr[i] = "";
			for (int z = i; z < in.length(); z++) {
				sr[i] += in.charAt(z);
			}
		}

		Arrays.sort(sr);

		for (int i = 0; i < sr.length; i++) {
			bw.write(sr[i] + "\n");
		}

		bw.flush();
		bw.close();

	}
}
