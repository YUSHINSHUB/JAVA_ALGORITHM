package Sorting;

import java.io.*;
import java.util.*;

public class Q11004_Kth_Number_S5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int n = Integer.parseInt(inp[0]);
		int k = Integer.parseInt(inp[1]);

		String temp[] = br.readLine().split(" ");
		int nums[] = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(temp[i]);
		}

		Arrays.sort(nums);

		bw.write(nums[k - 1] + "");

		bw.flush();
		bw.close();
	}
}