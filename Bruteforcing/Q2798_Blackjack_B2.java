package Bruteforcing;

import java.io.*;
import java.util.*;

public class Q2798_Blackjack_B2 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String nums[] = br.readLine().split(" ");

		int m = Integer.parseInt(nums[0]);
		int n = Integer.parseInt(nums[1]);

		int num[] = new int[m + 1];

		String s[] = br.readLine().split(" ");

		for (int i = 0; i < m; i++) {
			num[i] = Integer.parseInt(s[i]);
		}

		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int x = 0; x < m; x++) {
			for (int y = x + 1; y < m; y++) {
				for (int z = y + 1; z < m; z++) {
					q.add(num[x] + num[y] + num[z]);
				}
			}
		}

		int res = n + 1;

		while (res > n) {
			res = q.poll();
		}

		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();

	}
}