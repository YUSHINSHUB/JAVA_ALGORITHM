package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int a = Integer.parseInt(inp[0]);
		int b = Integer.parseInt(inp[1]);

		int nums[] = new int[b];

		int idx = 0;

		
		for (int i = 1; i <= b; i++) {
			for (int j = 0; j < i; j++) {
				nums[idx] = i;
				idx++;
				if (idx == b)
					break;
			}
			if (idx == b)
				break;
		}

		int res = 0;

		for (int i = a - 1; i < b; i++) {
			res += nums[i];
		}

		bw.write(res + "");

		bw.flush();
		bw.close();
	}
}
