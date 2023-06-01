package Mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q4673_Self_Number_S5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = 1;
		int temp1, temp2, temp3, temp4;
		int d = 0;

		while (n <= 10000) {
			for (int i = n - 36; i <= n; i++) {
				if (i < 0) {
					i = 0;
				}
				temp1 = i / 1000;
				temp2 = (i % 1000) / 100;
				temp3 = (i % 100) / 10;
				temp4 = i % 10;
				d = i + temp1 + temp2 + temp3 + temp4;
				if (d == n) {
					break;
				} else if (i == n) {
					bw.write(String.valueOf(n) + "\n");
				}
			}
			n++;
		}

		bw.flush();
		bw.close();

	}
}