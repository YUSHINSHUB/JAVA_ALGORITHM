package Mathematics;

import java.io.*;

public class Q24313_Asymptotic_1_S5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int a1 = Integer.parseInt(inp[0]);
		int a0 = Integer.parseInt(inp[1]);
		int c = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		if (a1 > c)
			bw.write("0");
		else {
			if (((a1 * n) + a0) > (c * n))
				bw.write("0");
			else
				bw.write("1");
		}

		bw.flush();
		bw.close();

	}
}