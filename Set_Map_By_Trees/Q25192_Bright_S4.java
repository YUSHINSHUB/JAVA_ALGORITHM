package Set_Map_By_Trees;

import java.io.*;
import java.util.*;

public class Q25192_Bright_S4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		HashSet<String> hs = new HashSet<>();
		String in;
		int res = 0;

		for (int i = 0; i < n; i++) {
			in = br.readLine();
			if (!in.equals("ENTER")) {
				hs.add(in);
			} else {
				res += hs.size();
				hs.clear();
			}
		}

		res += hs.size();
		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}