package Dynamic_Programming;

import java.io.*;
import java.math.*;

public class Q17626_Four_Squares_S3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int rag[] = new int[n];
		int cnt = 1;
		int temp = 0;
		int res = 4;
		boolean end = false;

		while (true) {
			temp = (int) Math.pow(cnt, 2);
			if (temp <= n) {
				rag[cnt - 1] = temp;
				cnt++;
			} else {
				break;
			}
		}

		for (int i = 0; i < cnt; i++) {
			if (n == rag[i]) {
				res = 1;
				end = true;
				break;
			}
		}

		if (!end) {
			for (int i = 0; i < cnt; i++) {
				for (int j = i; j < cnt; j++) {
					if (n == rag[i] + rag[j]) {
						res = 2;
						end = true;
						break;
					}
				}
				if (end)
					break;
			}
		}

		if (!end) {
			for (int i = 0; i < cnt; i++) {
				for (int j = i; j < cnt; j++) {
					for (int k = j; k < cnt; k++) {
						if (n == rag[i] + rag[j] + rag[k]) {
							res = 3;
							end = true;
							break;
						}
					}
					if (end)
						break;
				}
				if (end)
					break;
			}
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}