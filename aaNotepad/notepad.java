package aaNotepad;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.math.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];
		long low, hig;
		int res = 0;
		Boolean era[] = new Boolean[1000001];
		
		inp = br.readLine().split(" ");
		low = Long.parseLong(inp[0]);
		hig = Long.parseLong(inp[1]);
		Arrays.fill(era, false);

		for (long i = 2; i * i <= hig; i++) {
			if (low % (i * i) == 0)
				era[0] = true;
			for (long j = low + (i * i) - (low % (i * i)); j <= hig; j += i * i) {
				era[(int) (j - low)] = true;
			}

		}

		for (int i = 0; i <= hig - low; i++) {
			if (!era[i])
				res++;
		}

		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}