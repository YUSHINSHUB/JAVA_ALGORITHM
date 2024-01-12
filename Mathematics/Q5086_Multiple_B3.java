package Mathematics;

import java.io.*;

public class Q5086_Multiple_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a, b;

		while (true) {

			String inp[] = br.readLine().split(" ");
			a = Integer.parseInt(inp[0]);
			b = Integer.parseInt(inp[1]);
			if (a == 0 && b == 0)
				break;

			if (b % a == 0)
				bw.write("factor\n");

			else if (a % b == 0)
				bw.write("multiple\n");

			else
				bw.write("neither\n");
		}

		bw.flush();
		bw.close();

	}
}