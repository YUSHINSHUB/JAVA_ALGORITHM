package Geometry;

import java.io.*;
import java.util.*;

public class Q5073_Equilateral_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {

			String inp[] = br.readLine().split(" ");
			int len[] = new int[3];
			len[0] = Integer.parseInt(inp[0]);
			len[1] = Integer.parseInt(inp[1]);
			len[2] = Integer.parseInt(inp[2]);

			if (len[0] == len[1] && len[0] == len[2] && len[0] == 0)
				break;

			Arrays.sort(len);

			if (len[0] + len[1] <= len[2])
				bw.write("Invalid\n");
			else if (len[0] == len[1] && len[0] == len[2])
				bw.write("Equilateral\n");
			else if (len[0] == len[1] || len[0] == len[2] || len[1] == len[2])
				bw.write("Isosceles\n");
			else
				bw.write("Scalene\n");
		}

		bw.flush();
		bw.close();
	}
}
