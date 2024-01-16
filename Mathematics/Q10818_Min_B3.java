package Mathematics;

import java.util.*;
import java.io.*;

class Q10818_Min_B3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a = Integer.parseInt(br.readLine());

		StringTokenizer tk = new StringTokenizer(br.readLine());

		int max = -1000000;
		int min = 1000000;
		for (int i = 0; i < a; i++) {
			int x = Integer.parseInt(tk.nextToken());
			if (max < x) {
				max = x;
			}
			if (x < min) {
				min = x;
			}
		}
		System.out.println(min + " " + max);

	}

}