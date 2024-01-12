package Mathematics;

import java.io.*;
import java.util.*;

public class Q2587_Representative_2_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int p[] = new int[5];
		int sum = 0;

		for (int i = 0; i < 5; i++) {
			p[i] = Integer.parseInt(br.readLine());
			sum += p[i];
		}
		sum /= 5;
		Arrays.sort(p);
		bw.write(String.valueOf(sum) + "\n" + String.valueOf(p[2]));

		bw.flush();
		bw.close();
	}
}
