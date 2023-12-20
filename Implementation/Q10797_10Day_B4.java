package Implementation;

import java.io.*;
import java.util.*;

public class Q10797_10Day_B4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int index = 0;
		int viol = 0;

		int day = Integer.parseInt(br.readLine());
		String cnums = br.readLine();

		StringTokenizer stk = new StringTokenizer(cnums, " ");
		index = stk.countTokens();

		for (int i = 0; i < index; i++) {
			if (day == Integer.parseInt(stk.nextToken())) {
				viol++;
			}
		}

		bw.write(String.valueOf(viol));

		bw.flush();
		bw.close();

	}

}