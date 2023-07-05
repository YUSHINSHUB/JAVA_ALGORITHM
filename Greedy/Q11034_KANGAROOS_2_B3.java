package Greedy;

import java.io.*;
import java.util.*;

public class Q11034_KANGAROOS_2_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp;
		int kan[] = new int[3];

		while ((inp = br.readLine()) != null) {
			StringTokenizer stk = new StringTokenizer(inp, " ");
			kan[0] = Integer.parseInt(stk.nextToken());
			kan[1] = Integer.parseInt(stk.nextToken());
			kan[2] = Integer.parseInt(stk.nextToken());

			if (kan[1] - kan[0] > kan[2] - kan[1])
				bw.write((kan[1] - kan[0] - 1) + "\n");
			else
				bw.write((kan[2] - kan[1] - 1) + "\n");

		}

		bw.flush();
		bw.close();

	}
}