package Sorting;

import java.util.*;
import java.io.*;

class Q11650_Sort_Coordinate_S5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		List<int[]> list = new ArrayList<int[]>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[2];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			list.add(arr);
		}

		Collections.sort(list, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				} else {
					return Integer.compare(o1[0], o2[0]);
				}
			}
		});

		for (int[] a : list) {
			System.out.println(a[0] + " " + a[1]);
		}
	}
}