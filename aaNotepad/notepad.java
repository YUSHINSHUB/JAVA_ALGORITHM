package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		HashMap<Integer, Integer> hm = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		int nums[] = new int[N];
		int res = 0;

		String inp[] = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(inp[i]);
		}

		for (int i = 0; i < N; i++) {
			int s = 0;
			int e = N - 1;
			while (true) {
				if (s == i)
					s++;
				if (e == i)
					e--;
				if (s >= e)
					break;

				if (nums[s] + nums[e] == nums[i]) {
					res++;
					break;
				} else if (nums[s] + nums[e] < nums[i])
					s++;
				else
					e--;

			}
		}

		bw.write(res + "");
		bw.flush();
		bw.close();

	}

}
