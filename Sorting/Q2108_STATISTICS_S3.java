package Sorting;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2108_Statistics_S3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int nums[] = new int[n];
		int hap = 0;
		int hig = Integer.MIN_VALUE;
		int low = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			hap += nums[i];
			hig = Math.max(nums[i], hig);
			low = Math.min(nums[i], low);
		}

		int hidx = 0;
		HashMap<Integer, Integer> m = new HashMap<>();
		ArrayList<Integer> hnum = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);

			if (m.get(nums[i]) > hidx) {
				hidx++;
				hnum.clear();
				hnum.add(nums[i]);
			} else if (m.get(nums[i]) == hidx)
				hnum.add(nums[i]);

		}

		int vcnt = hnum.size();

		Arrays.sort(nums);
		Collections.sort(hnum);

		double a = (double) hap / (double) n;
		if (a > 0)
			a = Math.floor(a + 0.5);
		else if (a < 0)
			a = Math.ceil(a - 0.5);
		if (a == 0)
			bw.write("0\n");
		else
			bw.write((int) a + "\n");
		bw.write(nums[n / 2] + "\n");

		if (vcnt == 1)
			bw.write(hnum.get(0) + "");
		else
			bw.write(hnum.get(1) + "");

		bw.write("\n" + (hig - low));

		bw.flush();
		bw.close();

	}
}