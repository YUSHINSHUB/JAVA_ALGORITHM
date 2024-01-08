package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N;
		int A[];
		int mem[];
		int hig = 1;
		int end = 0;
		ArrayList<Integer> list = new ArrayList<>();

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		mem = new int[N];
		Arrays.fill(mem, 1);

		String inp[] = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(inp[i]);
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i])
					mem[i] = Math.max(mem[i], mem[j] + 1);
			}
			if (mem[i] > hig) {
				hig = mem[i];
				end = i;
			}
		}

		bw.write(hig + "\n");
		list.add(A[end]);
		for (int i = end; i >= 0; i--) {
			if (mem[i] == hig - 1) {
				list.add(A[i]);
				hig--;
			}
		}

		for (int i = list.size() - 1; i >= 0; i--)
			bw.write(list.get(i) + " ");
		bw.flush();
		bw.close();

	}

}
