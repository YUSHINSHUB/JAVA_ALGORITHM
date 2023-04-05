package Implementation;

import java.io.*;
import java.util.*;

public class Q2445_Print_Star_8_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			for (int z = i; z > 0; z--) {
				bw.write("*");
			}
			for (int z = (n - i) * 2; z > 0; z--) {
				bw.write(" ");
			}
			for (int z = i; z > 0; z--) {
				bw.write("*");
			}
			bw.write("\n");

		}

		for (int i = n - 1; i >= 1; i--) {
			for (int z = i; z > 0; z--) {
				bw.write("*");
			}
			for (int z = (n - i) * 2; z > 0; z--) {
				bw.write(" ");
			}
			for (int z = i; z > 0; z--) {
				bw.write("*");
			}
			bw.write("\n");

		}

		bw.flush();
		bw.close();

	}
}
