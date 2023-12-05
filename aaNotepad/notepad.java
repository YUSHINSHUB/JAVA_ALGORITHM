package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, M;

		while (true) {
			HashMap<Integer, Boolean> hm = new HashMap<>();
			int res = 0;

			String inp[] = br.readLine().split(" ");
			N = Integer.parseInt(inp[0]);
			M = Integer.parseInt(inp[1]);

			if (N + M == 0)
				break;

			for (int i = 0; i < N; i++) {
				int cd = Integer.parseInt(br.readLine());
				hm.put(cd, true);
			}
			for (int i = 0; i < M; i++) {
				int cd = Integer.parseInt(br.readLine());
				if (hm.getOrDefault(cd, false))
					res++;
			}

			bw.write(res + "\n");
		}

		bw.flush();
		bw.close();

	}

}
