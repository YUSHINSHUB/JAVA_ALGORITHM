package Implementation;

import java.io.*;

public class Q1357_Reversed_Addition_B1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		String x = new StringBuilder(inp[0]).reverse().toString();
		String y = new StringBuilder(inp[1]).reverse().toString();

		int res = Integer.parseInt(x) + Integer.parseInt(y);
		res = Integer.parseInt(new StringBuilder(res + "").reverse().toString());

		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}
