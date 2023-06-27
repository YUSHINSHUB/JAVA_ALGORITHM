package Data_Structures;

import java.io.*;
import java.util.*;

public class Q12605_Words_Sequence_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Stack<String> stk = new Stack<String>();

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			StringTokenizer tt = new StringTokenizer(temp, " ");

			while (tt.hasMoreTokens()) {
				stk.push(tt.nextToken());
			}
			bw.write("Case #" + String.valueOf(i + 1) + ": ");
			while (!stk.isEmpty()) {
				bw.write(stk.pop() + " ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}