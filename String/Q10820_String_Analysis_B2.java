package String;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q10820_String_Analysis_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp;

		while ((inp = br.readLine()) != null) {

			int sm = 0, bi = 0, nu = 0, sp = 0;
			for (int i = 0; i < inp.length(); i++) {
				if (inp.charAt(i) >= 'a' && inp.charAt(i) <= 'z') {
					sm++;
				} else if (inp.charAt(i) >= 'A' && inp.charAt(i) <= 'Z') {
					bi++;
				} else if (inp.charAt(i) >= '0' && inp.charAt(i) <= '9') {
					nu++;
				} else if (inp.charAt(i) == ' ') {
					sp++;
				}
			}

			bw.write(String.valueOf(sm) + " " + String.valueOf(bi) + " " + String.valueOf(nu) + " " + String.valueOf(sp)
					+ "\n");

			bw.flush();

		}

		bw.close();
	}

}
