package Dynamic_Programming;

import java.io.*;
import java.math.*;

public class Q1003_Fibonacci_S3 {

	int zindex;
	int oindex;

	public Q1003_Fibonacci_S3(int zindex, int oindex) {
		this.zindex = zindex;
		this.oindex = oindex;
	}

	public static int fibonacci(int n, Q1003_Fibonacci_S3 a) {
		int temp = 0;
		if (n == 0) {
			a.zindex++;
			return 0;
		} else if (n == 1) {
			a.oindex++;
			return 1;
		} else {
			a.oindex = 1;
			for (int i = 1; i < n; i++) {
				temp = a.zindex + a.oindex;
				a.zindex = a.oindex;
				a.oindex = temp;
			}
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			Q1003_Fibonacci_S3 a = new Q1003_Fibonacci_S3(0, 0);
			int n = Integer.parseInt(br.readLine());
			int z = fibonacci(n, a);
			bw.write(String.valueOf(a.zindex) + " " + String.valueOf(a.oindex) + "\n");
		}

		bw.flush();
		bw.close();

	}

}