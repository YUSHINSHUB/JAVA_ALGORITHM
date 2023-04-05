package Mathematics;

import java.io.*;
import java.util.*;

public class Q1373_Binary_To_Octal_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String bin = br.readLine();
		int toth = 0;
		String temp = "";
		StringBuilder oct = new StringBuilder();

		switch (bin.length() % 3) {
		case (1):
			temp = String.valueOf((bin.charAt(0) - '0'));
			oct.append(temp);
			break;
		case (2):
			temp = String.valueOf((bin.charAt(0) - '0') * 2 + (bin.charAt(1) - '0'));
			oct.append(temp);
			break;
		default:
			break;
		}

		temp = "";

		for (int i = bin.length() % 3; i < bin.length(); i++) {
			temp += bin.charAt(i);
			toth++;
			if (toth == 3) {
				toth = 0;
				temp = String.valueOf((temp.charAt(0) - '0') * 4 + (temp.charAt(1) - '0') * 2 + (temp.charAt(2) - '0'));
				oct.append(temp);
				temp = "";
			}
		}

		bw.write(oct.toString());

		bw.flush();
		bw.close();

	}
}