package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int x1 = Integer.parseInt(inp[0]);
		int y1 = Integer.parseInt(inp[1]);
		int x2 = Integer.parseInt(inp[2]);
		int y2 = Integer.parseInt(inp[3]);
		int x3 = Integer.parseInt(inp[4]);
		int y3 = Integer.parseInt(inp[5]);

		if((x2-x1)*(y3-y1)==(x3-x1)*(y2-y1)){
	         System.out.println(-1);
	         return;
	      }

		else {
			double sx, sy, mx, my, ex, ey, x4, y4;
			double len1, len2;
			double res1, res2, res3;

			sx = x2;
			sy = y2;
			mx = x1;
			my = y1;
			ex = x3;
			ey = y3;

			x4 = sx + (ex - mx);
			y4 = sy + (ey - my);
			len1 = Math.sqrt(Math.pow(Math.abs(mx - sx), 2) + Math.pow(Math.abs(my - sy), 2));
			len2 = Math.sqrt(Math.pow(Math.abs(sx - x4), 2) + Math.pow(Math.abs(sy - y4), 2));
			res1 = len1 + len1 + len2 + len2;

			sx = x1;
			sy = y1;
			mx = x2;
			my = y2;
			ex = x3;
			ey = y3;

			x4 = sx + (ex - mx);
			y4 = sy + (ey - my);
			len1 = Math.sqrt(Math.pow(Math.abs(mx - sx), 2) + Math.pow(Math.abs(my - sy), 2));
			len2 = Math.sqrt(Math.pow(Math.abs(sx - x4), 2) + Math.pow(Math.abs(sy - y4), 2));
			res2 = len1 + len1 + len2 + len2;

			sx = x1;
			sy = y1;
			mx = x3;
			my = y3;
			ex = x2;
			ey = y2;

			x4 = sx + (ex - mx);
			y4 = sy + (ey - my);
			len1 = Math.sqrt(Math.pow(Math.abs(mx - sx), 2) + Math.pow(Math.abs(my - sy), 2));
			len2 = Math.sqrt(Math.pow(Math.abs(sx - x4), 2) + Math.pow(Math.abs(sy - y4), 2));
			res3 = len1 + len1 + len2 + len2;

			double r1 = Math.min(res1, Math.min(res2, res3));
			double r2 = Math.max(res1, Math.max(res2, res3));

			bw.write(r2 - r1 + "");
		}

		bw.flush();
		bw.close();

	}
}
