package aaNotepad;

import java.io.*;
import java.util.Arrays;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt[] = new int[26];
		int c = 0;
		int a = 0;

		Arrays.fill(cnt, 0);
		String inp[] = br.readLine().split("\\|");

		for (int i = 0; i < inp.length; i++) {
			cnt[inp[i].charAt(0) - 'A']++;
		}

		c += cnt[2];
		c += cnt[5];
		c += cnt[6];
		a += cnt[0];
		a += cnt[3];
		a += cnt[4];

		if (a > c)
			bw.write("A-minor");
		else if (c > a)
			bw.write("C-major");
		else {
			if (inp[inp.length - 1].charAt(inp[inp.length - 1].length() - 1) == 'A'
					|| inp[inp.length - 1].charAt(inp[inp.length - 1].length() - 1) == 'D'
					|| inp[inp.length - 1].charAt(inp[inp.length - 1].length() - 1) == 'E')
				bw.write("A-minor");
			else
				bw.write("C-major");
		}

		bw.flush();
		bw.close();

	}

}
