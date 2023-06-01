package String;

import java.io.*;
import java.util.*;

public class Q9093_Reverse_Words_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		String s[] = new String[n];

		for (int i = 0; i < n; i++) {
			s[i] = br.readLine();
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer stk = new StringTokenizer(s[i]);
			while (stk.hasMoreTokens()) {
				String temp = stk.nextToken();
				for (int z = temp.length() - 1; z >= 0; z--) {
					bw.write(temp.charAt(z));
				}
				bw.write(" ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}

}
