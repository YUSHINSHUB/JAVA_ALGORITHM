package Set_Map_By_Hashing;

import java.io.*;
import java.util.*;

public class Q1620_Pokemon_S4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);

		HashMap<Integer, String> name = new HashMap<>();
		HashMap<String, Integer> no = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			String temp = br.readLine();
			name.put(i, temp);
			no.put(temp, i);
		}

		for (int i = 0; i < m; i++) {
			String in = br.readLine();
			if (in.charAt(0) >= '0' && in.charAt(0) <= '9') {
				int tmp = Integer.parseInt(in);
				bw.write(name.get(tmp) + "\n");
			} else {
				bw.write(no.get(in) + "\n");
			}
		}

		bw.flush();
		bw.close();

	}
}