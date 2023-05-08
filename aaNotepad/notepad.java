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
		int road[] = new int[n];

		for (int i = 0; i < n; i++) {
			road[i] = Integer.parseInt(inp[i]);
		}

		int cur = 0;
		int max = 0;

		for (int i = 1; i < n; i++) {
			if (road[i] > road[i - 1]) {
				cur += road[i] - road[i - 1];
				max = Math.max(max, cur);
			} else {
				cur = 0;
			}
		}
		
		bw.write(max + "");

		bw.flush();
		bw.close();
	}
}
