package Set_Map_by_Hashing;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1269_Symmetric_Difference_S4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);
		int res = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		int arr[] = new int[n + m];

		inp = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(inp[i]);
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
		}

		inp = br.readLine().split(" ");
		for (int i = 0; i < m; i++) {
			arr[n + i] = Integer.parseInt(inp[i]);
			hm.put(arr[n + i], hm.getOrDefault(arr[n + i], 0) + 1);
		}

		for (int i = 0; i < n + m; i++) {
			if (hm.get(arr[i]) == 1)
				res++;
		}

		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}