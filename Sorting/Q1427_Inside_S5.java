package Sorting;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1427_Inside_S5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String nums[] = br.readLine().split("");
		Integer num[] = new Integer[nums.length];

		for (int i = 0; i < nums.length; i++) {
			num[i] = Integer.parseInt(nums[i]);
		}

		Arrays.sort(num, (o1, o2) -> {
			return o2 - o1;
		});

		for (int i = 0; i < num.length; i++) {
			bw.write(String.valueOf(num[i]));
		}

		bw.flush();
		bw.close();

	}

}