package Data_Structures;

import java.io.*;

public class Q17608_Stick_B2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int stick[] = new int[n];
		int hig = 0;
		int res = 0;

		for (int i = 0; i < n; i++) {
			stick[i] = Integer.parseInt(br.readLine());
		}

		for (int i = n - 1; i >= 0; i--) {
			if (stick[i] > hig) {
				hig = stick[i];
				res++;
			}
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}
