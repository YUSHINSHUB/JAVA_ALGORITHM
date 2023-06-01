package Binary_Search;

import java.io.*;

public class Q1654_Cut_Lan_Cable_S2 {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int k, n;
		long cnt, mid;
		long low = 0, hig = 0;
		
		String in[] = br.readLine().split(" ");
		k = Integer.parseInt(in[0]);
		n = Integer.parseInt(in[1]);
		
		int lans[] = new int[k];

		for (int i = 0; i < k; i++) {
			lans[i] = Integer.parseInt(br.readLine());
			if (hig < lans[i]) hig = lans[i];
		}
		hig++;

		while (low < hig) {
			cnt = 0;
			mid = (low + hig) / 2;
			for (int i = 0; i < k; i++) {
				cnt += lans[i] / mid;
			}

			if (cnt < n) {
				hig = mid;
			}
			else {
				low = mid + 1;
			}
		}

		bw.write((low - 1) + "");
		
		bw.flush();
		bw.close();

	}
}