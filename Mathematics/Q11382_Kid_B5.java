package Mathematics;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q11382_Kid_B5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in[] = br.readLine().split(" ");

		BigInteger a = new BigInteger(in[0]);
		BigInteger b = new BigInteger(in[1]);
		BigInteger c = new BigInteger(in[2]);

		BigInteger res = a.add(b.add(c));

		bw.write(res.toString());

		bw.flush();
		bw.close();

	}
}
