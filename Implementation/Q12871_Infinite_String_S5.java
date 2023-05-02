package Implementation;

import java.io.*;

public class Q12871_Infinite_String_S5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s1 = br.readLine();
		String s2 = br.readLine();

		String r1 = "", r2 = "";

		for (int i = 0; i < s1.length(); i++) {
			r1 += s2;
		}

		for (int i = 0; i < s2.length(); i++) {
			r2 += s1;
		}

		if (r1.equals(r2))
			bw.write(1 + "");
		else
			bw.write(0 + "");

		bw.flush();
		bw.close();
	}
}
