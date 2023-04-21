package Implementation;

import java.io.*;
import java.util.*;
import java.text.*;

public class Q1769_Multiple_of_3_S5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String x = br.readLine();
		int y = 0;
		int idx = 0;

		while (x.length() != 1) {
			y = 0;
			idx++;
			for (int i = 0; i < x.length(); i++) {
				y += Integer.parseInt(x.charAt(i) + "");
			}
			x = y + "";
		}

		if (Integer.parseInt(x) % 3 == 0)
			bw.write(idx + "\nYES");
		else
			bw.write(idx + "\nNO");

		bw.flush();
		bw.close();

	}
}
