package Implementation;

import java.io.*;
import java.util.*;

public class Q2563_Paper_S5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int pap[][] = new int[100][100];
		int res = 0;

		for (int i = 0; i < 100; i++) {
			Arrays.fill(pap[i], 0);
		}

		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			int v = Integer.parseInt(inp[0]);
			int h = Integer.parseInt(inp[1]);
			for (int j = v; j < v + 10; j++) {
				for (int k = h; k < h + 10; k++) {
					if (pap[j][k] == 1)
						continue;
					else {
						pap[j][k] = 1;
						res++;
					}
				}
			}
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}