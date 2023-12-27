package Binary_Search;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2805_Tree_S2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		long goal = Long.parseLong(inp[1]);
		long h = 0;
		long cut = 0;
		int idx = 0;

		inp = br.readLine().split(" ");
		int temp = 0;

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		HashSet<Integer> hset = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			temp = Integer.parseInt(inp[i]);
			hset.add(temp);
			hm.put(temp, hm.getOrDefault(temp, 0) + 1);
		}

		Integer trees[] = hset.toArray(new Integer[0]);
		Arrays.sort(trees, Collections.reverseOrder());

		for (int i = 0; i < trees.length - 1; i++) {
			idx += hm.get(trees[i]);
			if (cut + ((trees[i] - trees[i + 1]) * idx) <= goal) {
				cut += ((trees[i] - trees[i + 1]) * idx);
				h += trees[i] - trees[i + 1];
			} else {
				h += (goal - cut) / idx;
				cut += ((goal - cut) / idx) * idx;
				if (cut != goal) {
					h++;
				}
				cut = goal;
				break;
			}
		}

		if (trees.length == 1) {
			h = (goal / n);
			if (goal % n != 0)
				h++;
		} else if (cut != goal) {
			h += (goal - cut) / n;
			cut += ((goal - cut) / n) * n;
			if (cut != goal)
				h++;
		}

		bw.write((trees[0] - h) + "");

		bw.flush();
		bw.close();

	}
}