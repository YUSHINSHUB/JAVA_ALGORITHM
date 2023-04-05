package Sorting;

import java.io.*;
import java.util.*;

public class Q10814_Age_Sort_S5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		HashMap<Integer, String> hm = new HashMap<Integer, String>();

		int n = Integer.parseInt(br.readLine());
		int mem[][] = new int[n + 1][2];

		for (int i = 1; i <= n; i++) {
			String temp[] = br.readLine().split(" ");
			mem[i][0] = i;
			mem[i][1] = Integer.parseInt(temp[0]);
			hm.put(i, temp[1]);
		}

		Arrays.sort(mem, (o1, o2) -> {
			if (o1[1] != o2[1])
				return Integer.compare(o1[1], o2[1]);
			else
				return Integer.compare(o1[0], o2[0]);
		});

		for (int i = 1; i <= n; i++)
			bw.write(mem[i][1] + " " + hm.get(mem[i][0]) + "\n");

		bw.flush();
		bw.close();
	}
}