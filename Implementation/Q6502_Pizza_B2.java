package Implementation;

import java.io.*;
import java.util.*;

public class Q6502_Pizza_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int r;
		double x, y;
		String temp;
		int index = 0;

		while (true) {
			temp = br.readLine();
			if (temp.equals("0")) {
				break;
			}
			index++;
			StringTokenizer stk = new StringTokenizer(temp, " ");

			r = Integer.parseInt(stk.nextToken());
			x = Double.parseDouble(stk.nextToken());
			y = Double.parseDouble(stk.nextToken());

			if (Math.sqrt(Math.pow(x / 2, 2) + Math.pow(y / 2, 2)) <= r) {
				bw.write("Pizza " + String.valueOf(index) + " fits on the table.\n");
			} else {
				bw.write("Pizza " + String.valueOf(index) + " does not fit on the table.\n");
			}
		}

		bw.flush();
		bw.close();
	}
}