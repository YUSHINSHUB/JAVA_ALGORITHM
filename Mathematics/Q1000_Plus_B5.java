package Mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Q1000_Plus_B5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int in[] = new int[str.length];
		int res = 0;

		for (int i = 0; i < str.length; i++) {
			in[i] = Integer.parseInt(str[i]);
			res = res + in[i];
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(res + "\n");

		bw.flush();
		bw.close();

	}

}
