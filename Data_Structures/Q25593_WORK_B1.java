package Data_Structures;

import java.io.*;
import java.util.*;

public class Q25593_WORK_B1 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		int high = Integer.MIN_VALUE;
		int low = Integer.MAX_VALUE;
		boolean res = true;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				String inp[] = br.readLine().split(" ");
				for (int k = 0; k < 7; k++) {
					if (!inp[k].equals("-")) {
						switch (j) {
						case 0:
							hm.put(inp[k], hm.getOrDefault(inp[k], 0) + 4);
							break;
						case 1:
							hm.put(inp[k], hm.getOrDefault(inp[k], 0) + 6);
							break;
						case 2:
							hm.put(inp[k], hm.getOrDefault(inp[k], 0) + 4);
							break;
						case 3:
							hm.put(inp[k], hm.getOrDefault(inp[k], 0) + 10);
							break;
						}
					}
				}
			}
		}

		for (int val : hm.values()) {
			if (val > high)
				high = val;
			if (val < low)
				low = val;
		}

		if (high - low > 12)
			bw.write("No");
		else
			bw.write("Yes");

		bw.flush();
		bw.close();

	}
}
