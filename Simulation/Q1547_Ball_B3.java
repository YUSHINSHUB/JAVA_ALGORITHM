package Simulation;

import java.io.*;
import java.util.*;

public class Q1547_Ball_B3 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int ball = 1;
		int a, b, ak, bk;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		String[] temp;

		hm.put(1, 1);
		hm.put(2, 2);
		hm.put(3, 3);

		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			a = Integer.parseInt(temp[0]);
			b = Integer.parseInt(temp[1]);
			ak = hm.get(a);
			bk = hm.get(b);
			hm.put(a, bk);
			hm.put(b, ak);

		}

		for (int i = 1; i <= 3; i++) {
			if (hm.get(i) == 1)
				bw.write(i + "");
		}

		bw.flush();
		bw.close();

	}
}
