package Mathematics;

import java.io.*;

public class Q10950_AplusB_3_B5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int rep = Integer.parseInt(br.readLine());
		int res = 0;
		int[] out = new int[rep];

		for (int a = 0; a < rep; a++) {

			String terms[] = br.readLine().split(" ");

			for (int b = 0; b < terms.length; b++) {

				res = res + Integer.parseInt(terms[b]);

			}

			out[a] = res;
			res = 0;
		}

		for (int a = 0; a < rep; a++) {
			bw.write(out[a] + "\n");
		}

		bw.flush();
		bw.close();

	}

}