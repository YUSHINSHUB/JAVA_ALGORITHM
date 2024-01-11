package Mathematics;

import java.io.*;

public class Q11005_Notation_2_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in[] = br.readLine().split(" ");

		int a = Integer.parseInt(in[0]);
		int b = Integer.parseInt(in[1]);

		String res = "";

		while (a != 0) {
			int temp = a % b;
			if (temp >= 10) {
				res += Character.toString((char) (temp + 55));
			} else {
				res += String.valueOf(temp);
			}
			a /= b;
		}

		for (int i = res.length() - 1; i >= 0; i--) {
			bw.write(Character.toString(res.charAt(i)));
		}

		bw.flush();
		bw.close();

	}
}