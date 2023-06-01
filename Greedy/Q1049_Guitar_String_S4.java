package Mathematics;

import java.io.*;
import java.math.*;

public class Q1049_Guitar_String_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);

		int sf = Integer.MAX_VALUE;
		int of = Integer.MAX_VALUE;

		for (int i = 0; i < m; i++) {
			inp = br.readLine().split(" ");
			sf = Math.min(Integer.parseInt(inp[0]), sf);
			of = Math.min(Integer.parseInt(inp[1]), of);
		}
		int res;

		if (sf < of) {
			res = (n / 6) * sf;
			if (n % 6 != 0) {
				res += sf;
			}
		} else if (sf > of * 6) {
			res = of * n;
		} else {
			res = (n / 6) * sf;
			res += Math.min(sf, (n % 6) * of);
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}
