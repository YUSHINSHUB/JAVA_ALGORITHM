package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> qs = new ArrayList<>();
		int num[] = new int[n];

		String inp[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			int t = Integer.parseInt(inp[i]);
			if (t == 0)
				qs.add(i);
		}

		inp = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(inp[i]);

		int m = Integer.parseInt(br.readLine());
		inp = br.readLine().split(" ");

		Collections.reverse(qs);

		for (int i : qs) {
			bw.write(num[i] + " ");
			m--;
			if (m == 0)
				break;
		}

		if (m > 0) {
			for (String i : inp) {
				bw.write(i + " ");
				m--;
				if (m == 0)
					break;
			}
		}

		bw.flush();
		bw.close();

	}
}