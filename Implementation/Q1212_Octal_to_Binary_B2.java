package Implementation;

import java.io.*;
import java.util.*;

public class Q1212_Octal_to_Binary_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String n = br.readLine();
		String temp;
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < n.length(); i++) {
			temp = Integer.toBinaryString(Integer.parseInt(String.valueOf(n.charAt(i))));

			if (i != 0) {
				switch (temp.length()) {
				case 1:
					res.append("00" + temp);
					break;
				case 2:
					res.append("0" + temp);
					break;
				default:
					res.append(temp);
				}
			} else {
				res.append(temp);
			}
		}

		bw.write(res.toString());

		bw.flush();
		bw.close();

	}
}
