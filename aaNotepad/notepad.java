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
		int p1 = Integer.parseInt(inp[2]);
		int q1 = Integer.parseInt(inp[3]);

		inp = br.readLine().split(" ");
		int x2 = Integer.parseInt(inp[0]);
		int y2 = Integer.parseInt(inp[1]);
		int p2 = Integer.parseInt(inp[2]);
		int q2 = Integer.parseInt(inp[3]);

		if (x1 > p2 || y1 > q2 || p1 < x2 || q1 < y2)
			bw.write("NULL");
		else if ((x1 == p2 && y1 == q2) || (p1 == x2 && y1 == q2) || (x1 == p2 && q1 == y2) || (p1 == x2 && q1 == y2))
			bw.write("POINT");
		else if ((x1 == p2) || (y1 == q2) || (p1 == x2) || (q1 == y2))
			bw.write("LINE");
		else
			bw.write("FACE");

		bw.flush();
		bw.close();

	}
}
