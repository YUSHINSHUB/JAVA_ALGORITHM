package Set_Map_By_Hashing;

import java.io.*;
import java.util.*;

public class Q11652_Card_S4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Integer.parseInt(br.readLine());

		HashMap<Long, Integer> hm = new HashMap<>();

		int hig = 0;
		long res = Long.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			long temp = Long.parseLong(br.readLine());
			hm.put(temp, hm.getOrDefault(temp, 0) + 1);

			if (hm.get(temp) > hig) {
				hig = hm.get(temp);
				res = temp;
			} else if (hm.get(temp) == hig && res > temp) {
				res = temp;
			}
		}

		bw.write(res + "");

		bw.flush();
		bw.close();
	}
}
