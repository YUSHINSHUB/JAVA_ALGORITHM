package Bruteforcing;

import java.io.*;
import java.math.*;
import java.util.*;

class place {
	int x;
	int y;

	place(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Q15686_Chicken_Delivery_G5 {

	static int n;
	static int m;
	static ArrayList<place> chp = new ArrayList<place>();
	static ArrayList<place> hop = new ArrayList<place>();
	static boolean[] pick;
	static int res;

	static void bt(int sidx, int cnt) {
		int sum = 0;
		int temp = 0;
		int min = Integer.MAX_VALUE;
		if (cnt == m) {
			for (int z = 0; z < hop.size(); z++) {
				min = Integer.MAX_VALUE;
				for (int i = 0; i < chp.size(); i++) {
					if (pick[i]) {
						temp = Math.abs(hop.get(z).x - chp.get(i).x) + Math.abs(hop.get(z).y - chp.get(i).y);
						min = Math.min(temp, min);
					}
				}
				sum += min;
			}
			res = Math.min(sum, res);
			return;
		} else {
			for (int i = sidx; i < chp.size(); i++) {
				if (!pick[i]) {
					pick[i] = true;
					bt(i + 1, cnt + 1);
					pick[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in[] = br.readLine().split(" ");
		n = Integer.parseInt(in[0]);
		m = Integer.parseInt(in[1]);
		res = Integer.MAX_VALUE;
		int chc = 0;
		int hom = 0;

		for (int i = 0; i < n; i++) {
			in = br.readLine().split(" ");
			for (int z = 0; z < n; z++) {
				if (in[z].equals("1")) {
					hop.add(new place(z, i));
					hom++;
				} else if (in[z].equals("2")) {
					chp.add(new place(z, i));
					chc++;
				}
			}
		}

		pick = new boolean[chp.size()];
		bt(0, 0);

		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}