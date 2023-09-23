package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int lx1 = Integer.parseInt(inp[0]);
		int ly1 = Integer.parseInt(inp[1]);
		int lx2 = Integer.parseInt(inp[2]);
		int ly2 = Integer.parseInt(inp[3]);

		int lxlen = lx2 - lx1;
		int lylen = ly2 - ly1;
		int res = lxlen * lylen;

		inp = br.readLine().split(" ");

		int fx1 = Integer.parseInt(inp[0]);
		int fy1 = Integer.parseInt(inp[1]);
		int fx2 = Integer.parseInt(inp[2]);
		int fy2 = Integer.parseInt(inp[3]);

		int fxlen = fx2 - fx1;
		int fylen = fy2 - fy1;

		if (fy1 <= ly1 && fy2 >= ly2) {
			if (fx1 <= lx1 && fx2 >= lx2) {
				res = 0;
			} else if (fx1 >= lx1 && fx1 <= lx2 && fx2 >= lx2) {
				res = lylen * (fx1 - lx1);
			} else if (fx1 <= lx1 && fx2 <= lx2 && fx2 >= lx1) {
				res = lylen * (lx2 - fx2);
			}
		} else if (fx1 <= lx1 && fx2 >= lx2) {
			if (fy1 >= ly1 && fy1 <= ly2 && fy2 >= ly2) {
				res = lxlen * (fy1 - ly1);
			} else if (fy1 <= ly1 && fy2 <= ly2 && fy2 >= ly1) {
				res = lxlen * (ly2 - fy2);
			}
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}
