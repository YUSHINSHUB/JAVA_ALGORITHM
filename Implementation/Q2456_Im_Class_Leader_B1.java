package Implementation;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2456_Im_Class_Leader_B1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int scr[][] = new int[3][3];

		for (int i = 0; i < 3; i++)
			Arrays.fill(scr[i], 0);

		for (int i = 0; i < n; i++) {
			String temp[] = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			int c = Integer.parseInt(temp[2]);
			scr[0][0] += a;
			scr[1][0] += b;
			scr[2][0] += c;

			switch (a) {
			case 3:
				scr[0][1]++;
				break;
			case 2:
				scr[0][2]++;
				break;
			default:
				break;
			}

			switch (b) {
			case 3:
				scr[1][1]++;
				break;
			case 2:
				scr[1][2]++;
				break;
			default:
				break;
			}

			switch (c) {
			case 3:
				scr[2][1]++;
				break;
			case 2:
				scr[2][2]++;
				break;
			default:
				break;
			}

		}

		int res = 1;
		int out = 1;
		int hig = scr[0][0];

		for (int i = 1; i < 3; i++) {
			if (hig < scr[i][0]) {
				res = i + 1;
				out = i + 1;
				hig = scr[i][0];
			} else if (hig == scr[i][0]) {
				if (scr[res - 1][1] != scr[i][1]) {
					if (scr[res - 1][1] < scr[i][1]) {
						res = i + 1;
						out = i + 1;
					}
				} else if (scr[res - 1][2] != scr[i][2]) {
					if (scr[res - 1][2] < scr[i][2]) {
						res = i + 1;
						out = i + 1;
					}
				} else {
					out = 0;
				}
			}
		}

		bw.write(out + " " + hig);

		bw.flush();
		bw.close();
	}
}
