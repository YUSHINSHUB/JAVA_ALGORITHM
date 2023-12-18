package Greedy;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1931_Conference_S1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int ca[][] = new int[n][2];

		for (int i = 0; i < n; i++) {
			String[] c = br.readLine().split(" ");
			ca[i][0] = Integer.parseInt(c[0]);
			ca[i][1] = Integer.parseInt(c[1]);
		}

		Arrays.sort(ca, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			} else {
				return o1[1] - o2[1];
			}
		});

		int cnt = 1;
		int stime = ca[0][1];

		for (int i = 1; i < n; i++) {
			if (ca[i][0] >= stime) {
				stime = ca[i][1];
				cnt++;
			}

		}

		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();

	}

}
