package String;

import java.io.*;

public class Q27866_Character_And_String_B5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		int n = Integer.parseInt(br.readLine());

		bw.write(s.charAt(n - 1) + "");
		bw.flush();
		bw.close();
	}
}
