package String;

import java.io.*;

public class Q2743_String_Length_B5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp = br.readLine();
		int res = inp.length();

		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();

	}

}
