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
		int N = Integer.parseInt(br.readLine());
		int sequence[] = new int[1000001];
		int mem[] = new int[1000001];
		int res[] = new int[1000001];
		int idx = 1;
		ArrayList<Integer> arr = new ArrayList<>();

		Arrays.fill(sequence, 0);
		inp = br.readLine().split(" ");

		for (int i = 0; i < N; i++)
			sequence[i] = Integer.parseInt(inp[i]);
		res[0] = sequence[0];

		for (int i = 1; i < N; i++) {
			if (sequence[i] > res[idx - 1]) {
				res[idx] = sequence[i];
				mem[i] = idx;
				idx++;
				continue;
			}
			int low = 0;
			int hig = idx;
			int mid = hig / 2;

			while (low < hig) {
				if (res[mid] < sequence[i]) {
					low = mid + 1;
					mid = (low + hig) / 2;
				} else {
					hig = mid;
					mid = (low + hig) / 2;
				}
			}
			res[low] = sequence[i];
			mem[i] = low;
		}

		bw.write(idx + "\n");
		int cur = idx - 1;
		for (int i = N - 1; i >= 0; i--) {
			if (mem[i] == cur) {
				arr.add(sequence[i]);
				cur--;
				if (cur < 0)
					break;
			}
		}

		for (int i = idx-1; i >= 0; i--)
			bw.write(arr.get(i) + " ");

		bw.flush();
		bw.close();
	}
}