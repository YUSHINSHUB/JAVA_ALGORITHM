package Mathematics;

import java.io.*;
import java.util.*;

public class Q1546_Average_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		float scr[] = new float[n];
		float sum = 0;
		float max = 0;

		for (int i = 0; i < n; i++) {
			scr[i] = Integer.parseInt(st.nextToken());
			if (max < scr[i]) {
				max = scr[i];
			}
		}

		for (int i = 0; i < n; i++) {
			sum = sum + ((scr[i] / max) * 100);
		}

		float avr = sum / n;

		bw.write(String.valueOf(avr));

		bw.flush();
		bw.close();
	}

}