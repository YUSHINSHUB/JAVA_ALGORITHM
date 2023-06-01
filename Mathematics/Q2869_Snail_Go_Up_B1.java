package Mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2869_Snail_Go_Up_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in[] = br.readLine().split(" ");
		int a = Integer.parseInt(in[0]);
		int b = Integer.parseInt(in[1]);
		int v = Integer.parseInt(in[2]);

		int c = a - b;

		int res = ((v - a) / c) + 1;
		if ((v - a) % c != 0) {
			res++;
		}

		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();

	}
}