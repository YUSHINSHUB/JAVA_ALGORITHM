package Sorting;

import java.io.*;
import java.util.*;

public class Q2751_Sort_Numbers_2_S5 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		if (n > 1000000 || n < 1) {
			System.exit(0);
		}

		PriorityQueue<Integer> q = new PriorityQueue<Integer>();

		for (int i = 0; i < n; i++) {
			q.add(Integer.parseInt(br.readLine()));
		}

		for (int i = 0; i < n; i++) {
			sb.append(q.poll() + "\n");
		}

		System.out.println(sb);
	}
}