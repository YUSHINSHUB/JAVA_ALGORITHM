package Implementation;

import java.io.*;
import java.util.*;

public class Q2490_Yutnori_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 3; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			int res = 0;
			for (int j = 0; j < 4; j++) {
				res += Integer.parseInt(stk.nextToken());
			}
			switch (res) {
			case 0:
				bw.write("D\n");
				break;
			case 1:
				bw.write("C\n");
				break;
			case 2:
				bw.write("B\n");
				break;
			case 3:
				bw.write("A\n");
				break;
			case 4:
				bw.write("E\n");
				break;
			}
		}

		bw.flush();
		bw.close();

	}
}
