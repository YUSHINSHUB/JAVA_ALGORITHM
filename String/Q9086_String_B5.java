package String;

import java.io.*;

public class Q9086_String_B5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < T; i++) {
			String in = br.readLine();
			sb.append(in.charAt(0));
			sb.append(in.charAt(in.length()-1));
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}