package Implementation;

import java.io.*;
import java.math.*;

public class Q5893_Seventeen_Times_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String bin = br.readLine();
		String sev = "10001";

		BigInteger bi = new BigInteger(bin, 2);
		BigInteger bs = new BigInteger(sev, 2);

		bi = bi.multiply(bs);
		String out = "";

		while (bi.compareTo(new BigInteger("0")) == 1) {
			out = out + bi.mod(new BigInteger("2")).toString();
			bi = bi.divide(new BigInteger("2"));
		}

		StringBuilder sb = new StringBuilder(out);
		out = sb.reverse().toString();

		bw.write(out);

		bw.flush();
		bw.close();

	}

}