package Implementation;

import java.io.*;
import java.util.*;

public class Q11328_Strfry_B2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		boolean pass = false;

		for (int i = 0; i < t; i++) {
			String inp[] = br.readLine().split(" ");
			String a = inp[0];
			String b = inp[1];
			pass = false;

			if (a.length() != b.length()) {
				pass = true;
			} else {
				int chk[] = new int[26];
				Arrays.fill(chk, 0);
				for (int j = 0; j < a.length(); j++) {
					chk[a.charAt(j) - 'a']++;
					chk[b.charAt(j) - 'a']--;
				}

				for (int j = 0; j < 26; j++) {
					if (chk[j] != 0) {
						pass = true;
						break;
					}
				}
			}

			if (!pass)
				bw.write("Possible\n");
			else
				bw.write("Impossible\n");
		}

		bw.flush();
		bw.close();
	}
}
