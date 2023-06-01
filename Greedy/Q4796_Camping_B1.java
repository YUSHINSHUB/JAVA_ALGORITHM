package Mathematics;

import java.io.*;

public class Q4796_Camping_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int ca = 0;

		while (true) {

			String inp[] = br.readLine().split(" ");

			if (inp[0].equals("0") && inp[1].equals("0") && inp[2].equals("0")) {
				break;
			}
			ca++;
			int l = Integer.parseInt(inp[0]);
			int p = Integer.parseInt(inp[1]);
			int v = Integer.parseInt(inp[2]);

			int out = ((v / p) * l);
			if (v % p > l) {
				out += l;
			} else {
				out += v % p;
			}

			bw.write("Case " + String.valueOf(ca) + ": " + String.valueOf(out) + "\n");
		}

		bw.flush();
		bw.close();
	}
}