package Sorting;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q17224_Subtask_Competition_B1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int n = Integer.parseInt(inp[0]);
		int l = Integer.parseInt(inp[1]);
		int k = Integer.parseInt(inp[2]);

		int res = 0;

		ArrayList<Integer> q = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			if (k == 0)
				break;
			inp = br.readLine().split(" ");
			if (Integer.parseInt(inp[1]) <= l) {
				res += 140;
				k--;
			} else
				q.add(Integer.parseInt(inp[0]));
		}

		Collections.sort(q);

		for (int i = 0; i < q.size(); i++) {
			if (k == 0 || q.get(i) > l)
				break;
			res += 100;
			k--;
		}

		bw.write(res + "");

		bw.flush();
		bw.close();
	}
}
