package Implementation;

import java.io.*;
import java.util.*;

public class Q8958_OX_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int scr[] = new int[n];

		for (int i = 0; i < n; i++) {
			String ox = br.readLine();
			int sum = 0;
			int add = 0;

			for (int a = 0; a < ox.length(); a++) {
				if (ox.charAt(a) == 'X') {
					add = 0;
				} else {
					add++;
					sum = sum + add;
				}
			}

			scr[i] = sum;
		}

		for (int i = 0; i < n; i++) {
			bw.write(String.valueOf(scr[i]) + '\n');
		}

		bw.flush();
		bw.close();
	}

}