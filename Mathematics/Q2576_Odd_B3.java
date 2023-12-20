package Mathematics;

import java.io.*;
import java.util.*;

public class Q2576_Odd_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n;
		int sum = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < 7; i++) {
			n = Integer.parseInt(br.readLine());
			if (n % 2 == 1) {
				if (min > n)
					min = n;
				sum += n;
			}
		}

		if (sum == 0)
			bw.write("-1");
		else
			bw.write(sum + "\n" + min);

		bw.flush();
		bw.close();

	}
}
