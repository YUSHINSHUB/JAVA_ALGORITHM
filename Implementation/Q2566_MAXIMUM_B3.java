package Implementation;

import java.io.*;
import java.util.*;

public class Q2566_MAXIMUM_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int y = 0;
		int x = 0;
		int max = Integer.MIN_VALUE;
		int temp;

		for (int i = 0; i < 9; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				temp = Integer.parseInt(stk.nextToken());
				if (temp > max) {
					max = temp;
					x = j + 1;
					y = i + 1;
				}
			}
		}

		bw.write(max + "\n" + y + " " + x);

		bw.flush();
		bw.close();

	}
}
