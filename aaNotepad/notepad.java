package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);

		if (n >= m)
			bw.write(n-m + "");
		else {

			int search[] = new int[m + 3];
			Arrays.fill(search, Integer.MAX_VALUE-1);

			search[0] = n;
			for (int i = n; i >= 1; i--) {
				search[i] = n - i;
				for (int j = i * 2; j <= m+1; j *= 2) {
					if( search[j] > search[i] ) search[j] = search[i];
					else break;
				}
			}

			for (int i = n + 1; i <= m; i++) {
					if (i % 2 == 1)
						search[i] = Math.min(search[i], Math.min(search[i + 1] + 1,
								Math.min(search[i - 1] + 1, Math.min(search[i / 2] + 1, search[i / 2 + 1] + 1))));
					else
						search[i] = Math.min(search[i],
								Math.min(search[i + 1] + 1, Math.min(search[i - 1] + 1, search[i / 2])));
					
					for (int j = i * 2; j <= m+1; j *= 2) {
						if( search[j] > search[i] ) search[j] = search[i];
						else break;
					}
			}

			bw.write(search[m] + "");
		}

		bw.flush();
		bw.close();

	}
}
