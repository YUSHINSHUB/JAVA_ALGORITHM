package String;

import java.io.*;

public class Q15098_No_Duplicates_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in[] = br.readLine().split(" ");

		String out = "yes";

		for (int i = 0; i < in.length; i++) {
			for (int z = i + 1; z < in.length; z++) {
				if (in[i].equals(in[z])) {
					out = "no";
					break;
				}
			}
		}

		bw.write(out);
		bw.flush();
		bw.close();

	}
}
