package Sorting;

import java.io.*;
import java.util.*;

public class Q3845_Mower_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String inp[] = br.readLine().split(" ");
			int nx = Integer.parseInt(inp[0]);
			int ny = Integer.parseInt(inp[1]);
			double sz = Double.parseDouble(inp[2]) / 2;

			if (nx == 0 && ny == 0 && sz == 0.0) {
				break;
			}

			boolean cx = true;
			boolean cy = true;

			double xpos[] = new double[nx];
			double ypos[] = new double[ny];

			String xin[] = br.readLine().split(" ");

			for (int i = 0; i < nx; i++) {
				xpos[i] = Double.parseDouble(xin[i]);
			}

			Arrays.sort(xpos);

			double min = 0;

			for (int i = 0; i < nx; i++) {
				if (xpos[i] - sz > min) {
					cx = false;
					break;
				} else {
					min = xpos[i] + sz;
				}
			}

			if (cx == true && min < 75) {
				cx = false;
			}

			String yin[] = br.readLine().split(" ");

			for (int i = 0; i < ny; i++) {
				ypos[i] = Double.parseDouble(yin[i]);
			}

			Arrays.sort(ypos);

			min = 0;

			for (int i = 0; i < ny; i++) {
				if (ypos[i] - sz > min) {
					cy = false;
					break;
				} else {
					min = ypos[i] + sz;
				}
			}

			if (cy == true && min < 100) {
				cy = false;
			}

			if (cy == true && cx == true) {
				bw.write("YES" + "\n");
			} else {
				bw.write("NO" + "\n");
			}

		}

		bw.flush();
		bw.close();

	}
}