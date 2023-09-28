package Data_Structures;

/*
commented by ChatGPT
Summary: This program performs union-find operations on disjoint sets using path compression. 
It can either unite two sets or check if two elements belong to the same set.
*/

import java.io.*;
import java.util.*;

public class Q1717_Expression_of_Set_G5 {

// HashMap to store the parent of each node in the union-find structure.
	static HashMap<Integer, Integer> hm = new HashMap<>();

// Recursive function to find the representative of a set.
	static int findparent(int n) {
		// If n is not its own parent, update its parent to the representative of the
		// set.
		if (hm.get(n) != n) {
			hm.put(n, findparent(hm.get(n)));
		}
		return hm.get(n);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Parsing the first line to get the number of elements 'n' and the number of
		// operations 'm'.
		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);

		// Initially, every element is its own parent.
		for (int i = 0; i <= n; i++) {
			hm.put(i, i);
		}

		// Processing each operation.
		for (int i = 0; i < m; i++) {
			inp = br.readLine().split(" ");
			int comm = Integer.parseInt(inp[0]); // Command type: 0 (union) or 1 (find)
			int a = Integer.parseInt(inp[1]); // First element
			int b = Integer.parseInt(inp[2]); // Second element

			if (comm == 0) {
				// If command type is 0, attempt to unite the sets containing 'a' and 'b'.
				if (findparent(a) != findparent(b)) {
					hm.put(findparent(b), findparent(a));
				}
			} else {
				// If command type is 1, check if 'a' and 'b' belong to the same set.
				if (findparent(a) == findparent(b))
					bw.write("YES\n");
				else
					bw.write("NO\n");
			}
		}

		// Closing the buffered writer after processing all operations.
		bw.flush();
		bw.close();
	}
}
