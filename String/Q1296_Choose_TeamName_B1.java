package String;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1296_Choose_TeamName_B1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String y = br.readLine();
		int n = Integer.parseInt(br.readLine());

		ArrayList<String> pl = new ArrayList<String>();
		HashMap<String, Integer> rate = new HashMap<String, Integer>();

		for (int i = 0; i < n; i++) {
			int lc = 0, oc = 0, vc = 0, ec = 0;
			String temp = br.readLine();
			pl.add(temp);

			for (int j = 0; j < y.length(); j++) {
				if (y.charAt(j) == 'L')
					lc++;
				else if (y.charAt(j) == 'O')
					oc++;
				else if (y.charAt(j) == 'V')
					vc++;
				else if (y.charAt(j) == 'E')
					ec++;
			}

			for (int j = 0; j < temp.length(); j++) {
				if (temp.charAt(j) == 'L')
					lc++;
				else if (temp.charAt(j) == 'O')
					oc++;
				else if (temp.charAt(j) == 'V')
					vc++;
				else if (temp.charAt(j) == 'E')
					ec++;
			}

			int res = (lc + oc) * (lc + vc) * (lc + ec) * (oc + vc) * (oc + ec) * (vc + ec);
			res %= 100;
			rate.put(temp, res);

		}

		Collections.sort(pl, new Comparator<String>() {
			public int compare(String o1, String o2) {
				if (rate.get(o1) < rate.get(o2))
					return 1;
				else if (rate.get(o1) == rate.get(o2)) {
					return o1.compareTo(o2);
				} else
					return -1;
			}
		});

		bw.write(pl.get(0));

		bw.flush();
		bw.close();
	}
}
