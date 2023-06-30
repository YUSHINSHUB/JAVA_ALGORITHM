package Implementation;

import java.io.*;
import java.math.*;

public class Q10757_Big_AplusB_B5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String elm[] = br.readLine().split(" ");

		BigInteger a = new BigInteger(elm[0]);
		BigInteger b = new BigInteger(elm[1]);

		a = a.add(b);

		bw.write(String.valueOf(a));

		bw.flush();
		bw.close();
	}

}