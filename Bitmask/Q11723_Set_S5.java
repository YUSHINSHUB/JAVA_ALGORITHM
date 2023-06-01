package Bitmask;

import java.io.*;

public class Q11723_Set_S5 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int m = Integer.parseInt(br.readLine());
		int bit = 0;
		String a[] = new String[2];
		int b;
		for (int i = 0; i < m; i++) {
			a = br.readLine().split(" ");
			if (a[0].equals("add")) {
				b = Integer.parseInt(a[1]);
				bit = bit | (1 << b - 1);
			} else if (a[0].equals("remove")) {
				b = Integer.parseInt(a[1]);
				if ((bit & (1 << (b - 1))) > 0)
					bit -= Math.pow(2, b - 1);
			} else if (a[0].equals("check")) {
				b = Integer.parseInt(a[1]);
				if ((bit & (1 << (b - 1))) > 0)
					bw.write("1\n");
				else
					bw.write("0\n");
			} else if (a[0].equals("toggle")) {
				b = Integer.parseInt(a[1]);
				if ((bit & (1 << (b - 1))) > 0)
					bit -= Math.pow(2, b - 1);
				else
					bit += Math.pow(2, b - 1);
			} else if (a[0].equals("all")) {
				bit = 1048575;
			} else if (a[0].equals("empty")) {
				bit = 0;
			}
		}

		bw.flush();
		bw.close();

	}
}