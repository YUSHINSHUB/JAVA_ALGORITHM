package Set_Map_By_Hashing;

import java.io.*;
import java.util.*;

public class Q10815_Card_S5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int nc[] = new int[n];
		String temp[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			nc[i] = Integer.parseInt(temp[i]);
		}
		int m = Integer.parseInt(br.readLine());
		int mc[] = new int[m];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
		temp = br.readLine().split(" ");
		for (int i = 0; i < m; i++) {
			mc[i] = Integer.parseInt(temp[i]);
			hm.put(mc[i], i);
			res.put(i, 0);
		}

		int cnt = 0;

		Arrays.sort(nc);
		Arrays.sort(mc);

		for (int i = 0; i < n; i++) {
			if (nc[i] == mc[cnt]) {
				res.put(hm.get(mc[cnt]), 1);
				cnt++;
			} else if (nc[i] > mc[cnt]) {
				while (nc[i] > mc[cnt]) {
					cnt++;
					if (cnt == m)
						break;
					if (mc[cnt] == nc[i]) {
						res.put(hm.get(mc[cnt]), 1);
						mc[cnt] = 1;
						cnt++;
						break;
					}
				}
			}

			if (cnt == m)
				break;

		}

		for (int i = cnt; i < m; i++) {
			res.put(hm.get(mc[i]), 0);
		}

		for (int i = 0; i < m; i++)
			bw.write(res.get(i) + " ");

		bw.flush();
		bw.close();
	}
}