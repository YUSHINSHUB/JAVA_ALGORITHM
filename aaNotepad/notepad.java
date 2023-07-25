package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int res = 0;
		HashMap<String, Integer> hm = new HashMap<>();
		String a, b;
		hm.put("ChongChong", 1);

		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			a = inp[0];
			b = inp[1];

			if (!hm.containsKey(a)) {
				hm.put(a, 0);
			}
			if (!hm.containsKey(b)) {
				hm.put(b, 0);
			}

			if (hm.get(a) == 1)
				hm.put(b, 1);
			else if (hm.get(b) == 1)
				hm.put(a, 1);

		}

		for (Map.Entry<String, Integer> en : hm.entrySet()) {
			if (en.getValue() == 1)
				res++;
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}