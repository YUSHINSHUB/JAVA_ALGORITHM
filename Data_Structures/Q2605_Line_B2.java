package Data_Structures;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q2605_LINE_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String num[] = br.readLine().split(" ");
		Queue<Integer> q = new LinkedList<>();

		int[] nums = new int[n + 1];
		int temp = 0;

		for (int i = 1; i <= n; i++) {
			nums[i] = i - Integer.parseInt(num[i - 1]);
			for (int z = 1; z < i; z++) {
				if (nums[z] >= nums[i]) {
					nums[z]++;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int z = 1; z <= n; z++) {
				if (nums[z] == i) {
					bw.write(String.valueOf(z) + " ");
					continue;
				}
			}
		}

		bw.flush();
		bw.close();
	}
}
