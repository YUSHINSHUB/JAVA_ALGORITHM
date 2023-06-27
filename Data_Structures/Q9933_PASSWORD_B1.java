package Data_Structures;

import java.io.*;
import java.util.*;

public class Q9933_PASSWORD_B1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int res = 0;
		char mid = '.';

		StringBuilder pass[] = new StringBuilder[n];

		for (int i = 0; i < n; i++) {
			pass[i] = new StringBuilder(br.readLine());
		}

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (new StringBuilder(pass[i].toString()).reverse().toString().equals(pass[j].toString())) {
					res = pass[i].length();
					mid = pass[i].charAt(res / 2);
					break;
				}
			}
			if (res != 0)
				break;
		}

		bw.write(res + " " + mid);

		bw.flush();
		bw.close();
	}
}