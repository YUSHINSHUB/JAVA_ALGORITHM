package Number_Theory;

import java.io.*;

public class Q13241_LCM_S5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		long a = Integer.parseInt(inp[0]);
		long b = Integer.parseInt(inp[1]);

		if (a < b) {
			long temp = a;
			a = b;
			b = temp;
		}

		long res = a;

		while (res % b != 0) {
			res += a;
		}

		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}