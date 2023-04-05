package Sorting;

import java.io.*;
import java.util.*;

public class Q1920_Search_Number_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int cnt = 0;

		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>(n);
		String in[] = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			hmap.put(Integer.parseInt(in[i]), 1);
		}

		int m = Integer.parseInt(br.readLine());
		String s[] = br.readLine().split(" ");

		for (int i = 0; i < m; i++) {
			if (hmap.containsKey(Integer.parseInt(s[i])))
				bw.write("1\n");
			else
				bw.write("0\n");
		}

		bw.flush();
		bw.close();

	}
}
