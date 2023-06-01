package Mathematics;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q4344_Above_Average_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int sum = 0;
			int good = 0;
			double per;
			String[] scrs = br.readLine().split(" ");
			for (int z = 1; z <= Integer.parseInt(scrs[0]); z++) {
				sum += Integer.parseInt(scrs[z]);
			}
			float avr = (float) sum / Float.parseFloat(scrs[0]);
			for (int z = 1; z <= Integer.parseInt(scrs[0]); z++) {
				if (Integer.parseInt(scrs[z]) > avr) {
					good++;
				}
			}
			per = (float) 100.000 / Float.parseFloat(scrs[0]) * (float) good;
			bw.write(String.format("%.3f", per) + "%\n");
		}

		bw.flush();
		bw.close();
	}
}
