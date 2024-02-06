package aaNotepad;

import java.io.*;
import java.util.*;
import java.math.*;

public class notepad {

	static class party {
		ArrayList<Integer> mem = new ArrayList<>();

		party() {

		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, M;
		Boolean know[] = new Boolean[51];
		String inp[];
		ArrayList<party> plist = new ArrayList<>();

		Arrays.fill(know, false);
		inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);

		inp = br.readLine().split(" ");
		for (int i = 1; i <= Integer.parseInt(inp[0]); i++) {
			know[Integer.parseInt(inp[i])] = true;
		}

		for (int i = 0; i < M; i++) {
			party p = new party();
			Boolean b = false;
			inp = br.readLine().split(" ");
			for (int j = 1; j <= Integer.parseInt(inp[0]); j++) {
				p.mem.add(Integer.parseInt(inp[j]));
				if (know[Integer.parseInt(inp[j])])
					b = true;
			}
			if (b) {
				for (int j = 1; j <= Integer.parseInt(inp[0]); j++) {
					know[Integer.parseInt(inp[j])] = true;
				}
				M--;
				i--;
			} else {
				plist.add(p);
			}
		}

		for (int i = 0; i < M; i++) {
			party p = plist.get(i);
			Boolean b = false;
			for (int j = 0; j < p.mem.size(); j++) {
				if (know[p.mem.get(j)]) {
					b = true;
					break;
				}
			}
			if (b) {
				for (int j = 0; j < p.mem.size(); j++) {
					know[p.mem.get(j)] = true;
				}
				plist.remove(i);
				M--;
				i = -1;
			}
		}

		bw.write(M + "");
		bw.flush();
		bw.close();
	}
}