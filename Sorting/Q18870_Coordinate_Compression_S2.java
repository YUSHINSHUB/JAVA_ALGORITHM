package Sorting;

import java.io.*;
import java.util.*;

public class Q18870_Coordinate_Compression_S2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String inp[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(inp[i]);
		}

		int sor[] = arr.clone();
		int idx = 1;

		Arrays.sort(sor);
		HashMap<Integer, Integer> hm = new HashMap<>();

		hm.put(sor[0], 0);
		for (int i = 1; i < n; i++) {
			if (sor[i] != sor[i - 1]) {
				hm.put(sor[i], idx);
				idx++;
			}
		}

		for (int i = 0; i < n; i++) {
			bw.write(hm.get(arr[i]) + " ");
		}

		bw.flush();
		bw.close();

	}
}