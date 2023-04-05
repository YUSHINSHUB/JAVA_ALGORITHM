package Mathematics;

import java.io.*;
import java.math.*;

public class Q1085_Escape_from_Rectangle_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] nums = br.readLine().split(" ");

		int x = Integer.parseInt(nums[0]);
		int y = Integer.parseInt(nums[1]);
		int w = Integer.parseInt(nums[2]);
		int h = Integer.parseInt(nums[3]);

		int xr;
		int yr;
		int res;

		if (x >= w && y >= h) {
			xr = x - w;
			yr = y - h;
			res = xr + yr;
		} else if (x >= w && y < h) {
			res = x - w;
		} else if (x < w && y >= h) {
			res = y - h;
		} else {
			xr = Math.min(x, w - x);
			yr = Math.min(y, h - y);
			res = Math.min(xr, yr);
		}

		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();

	}

}