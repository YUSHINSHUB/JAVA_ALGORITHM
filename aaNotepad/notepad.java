package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String inp[] = br.readLine().split(" ");
		Integer ship[] = new Integer[n];

		for (int i = 0; i < n; i++)
			ship[i] = Integer.parseInt(inp[i]);

		Arrays.sort(ship, Collections.reverseOrder());

		int m = Integer.parseInt(br.readLine());
		ArrayList<Integer> bag = new ArrayList<>();
		inp = br.readLine().split(" ");

		for (int i = 0; i < m; i++)
			bag.add(Integer.parseInt(inp[i]));
		Collections.sort(bag, Collections.reverseOrder());

		if (bag.get(0) > ship[0])
			bw.write("-1");
		else {
			int res = 0;
			while (!bag.isEmpty()) {
				int idx = 0;
				for (int j = 0; j < m; j++) {
					if (ship[idx] >= bag.get(j)) {
						bag.remove(j);
						j--;
						m--;
						idx++;
						if (idx == n)
							break;
					}
				}

				n = idx;
				res++;
			}

			bw.write(res + "");
		}

		bw.flush();
		bw.close();

	}
}
