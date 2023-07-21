package Number_Theory;

import java.io.*;
import java.math.*;

public class Q1735_Fraction_Sum_S3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int fden, ffra, sden, sfra;

		String inp[] = br.readLine().split(" ");
		fden = Integer.parseInt(inp[0]);
		ffra = Integer.parseInt(inp[1]);

		inp = br.readLine().split(" ");
		sden = Integer.parseInt(inp[0]);
		sfra = Integer.parseInt(inp[1]);

		int hi = Math.max(ffra, sfra);
		int lo = Math.min(ffra, sfra);

		if (hi == ffra) {
			while (hi % ffra != 0 || hi % sfra != 0)
				hi += ffra;
		} else {
			while (hi % ffra != 0 || hi % sfra != 0)
				hi += sfra;
		}

		fden *= hi / ffra;
		sden *= hi / sfra;

		fden += sden;

		for (int i = 2; i <= Math.min(fden, hi); i++) {
			if (fden % i == 0 && hi % i == 0) {
				fden /= i;
				hi /= i;
				i = 1;
			}
		}

		bw.write(fden + " " + hi);

		bw.flush();
		bw.close();

	}
}