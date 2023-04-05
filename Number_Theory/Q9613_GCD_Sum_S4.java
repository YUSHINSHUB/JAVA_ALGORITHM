package Number_Theory;

import java.io.*;
import java.util.*;

public class Q9613_GCD_Sum_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		String s[] = new String[t];

		for (int i = 0; i < t; i++) {
			s[i] = br.readLine();
		}

		for (int i = 0; i < t; i++) {
			StringTokenizer stk = new StringTokenizer(s[i], " ");
			int cnt = Integer.parseInt(stk.nextToken());
			int temp[] = new int[stk.countTokens()];
			long res = 0;
			for (int z = 0; z < cnt; z++) {
				temp[z] = Integer.parseInt(stk.nextToken());
			}
			for (int z = 0; z < cnt - 1; z++) {
				for (int x = z + 1; x < cnt; x++) {
					for (int c = Math.min(temp[z], temp[x]); c >= 1; c--) {
						if (temp[z] % c == 0 && temp[x] % c == 0) {
							res += c;
							break;
						}
					}
				}
			}
			bw.write(String.valueOf(res) + "\n");
		}

		bw.flush();
		bw.close();

	}
}