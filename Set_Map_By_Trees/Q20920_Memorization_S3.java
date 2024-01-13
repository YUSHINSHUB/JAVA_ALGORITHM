package Set_Map_By_Trees;

import java.io.*;
import java.util.*;

public class Q20920_Memorization_S3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);
		int idx = n;

		ArrayList<String> word = new ArrayList<String>();
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			if (temp.length() >= m) {
				hm.put(temp, hm.getOrDefault(temp, 0) + 1);
				if (hm.get(temp) == 1)
					word.add(temp);
				else
					idx--;
			} else
				idx--;
		}

		Collections.sort(word, new Comparator<String>() {
			public int compare(String o1, String o2) {
				if (hm.get(o1) < hm.get(o2))
					return 1;
				else if (hm.get(o1) == hm.get(o2)) {
					if (o1.length() < o2.length())
						return 1;
					else if (o1.length() == o2.length()) {
						return o1.compareTo(o2);
					} else
						return -1;
				} else
					return -1;

			}
		});

		for (int i = 0; i < idx; i++) {
			bw.write(word.get(i) + "\n");
		}

		bw.flush();
		bw.close();
	}
}