package Two_Pointer;

import java.io.*;
import java.util.*;

public class Q11728_Merge_Array_S5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String nums[] = br.readLine().split(" ");

		int n = Integer.parseInt(nums[0]);
		int m = Integer.parseInt(nums[1]);

		int arr[] = new int[n + m];

		String ns[] = br.readLine().split(" ");
		String ms[] = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(ns[i]);
		}

		for (int i = n; i < n + m; i++) {
			arr[i] = Integer.parseInt(ms[i - n]);
		}

		Arrays.sort(arr);

		for (int i : arr) {
			bw.write(i + " ");
		}

		bw.flush();
		bw.close();

	}
}