package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static ArrayList<Character> sym = new ArrayList<>();
	static int K;
	static long low = Long.MAX_VALUE, hig = Long.MIN_VALUE;
	static String lout, hout;
	static boolean visited[] = new boolean[10];

	static void bt(int idx, String res, int cur) {

		if (idx == K) {
			long temp = Long.parseLong(res);
			if (low > temp) {
				lout = res;
				low = temp;
			}

			if (hig < temp) {
				hout = res;
				hig = temp;
			}
			return;
		}

		if (sym.get(idx) == '>') {
			for (int i = cur - 1; i >= 0; i--) {
				if (visited[i])
					continue;
				visited[i] = true;
				bt(idx + 1, res + i, i);
				visited[i] = false;
			}
		} else {
			for (int i = cur + 1; i <= 9; i++) {
				if (visited[i])
					continue;
				visited[i] = true;
				bt(idx + 1, res + i, i);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Arrays.fill(visited, false);
		K = Integer.parseInt(br.readLine());
		String in = br.readLine();
		for (int i = 0; i <= K * 2 - 2; i += 2) {
			sym.add(in.charAt(i));
		}

		for (int i = 0; i <= 9; i++) {
			visited[i] = true;
			bt(0, "" + i, i);
			visited[i] = false;
		}

		bw.write(hout + "\n" + lout);
		bw.flush();
		bw.close();

	}

}
