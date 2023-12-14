package String;

import java.io.*;
import java.util.*;

public class Q1316_Checker_S5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int res = 0;

		for (int i = 0; i < n; i++) {
			boolean boo = true;
			boolean chk[] = new boolean[26];
			String in = br.readLine();
			chk[in.charAt(0) - 97] = true;
			for (int z = 1; z < in.length(); z++) {
				if (in.charAt(z) != in.charAt(z - 1) && chk[in.charAt(z) - 97] == true) {
					boo = false;
					break;
				} else {
					chk[in.charAt(z) - 97] = true;
				}
			}
			if (boo == true) {
				res++;
			}
		}

		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();

	}
}
