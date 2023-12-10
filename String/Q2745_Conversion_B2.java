package String;

import java.io.*;

public class Q2745_Conversion_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		String num = inp[0];
		int ant = Integer.parseInt(inp[1]);
		int temp = 0;
		int res = 0;

		for (int i = num.length() - 1; i >= 0; i--) {
			if (num.charAt(i) >= 'A') {
				res += (num.charAt(i) - 55) * Math.pow(ant, temp);
				temp++;
			} else {
				res += (num.charAt(i) - 48) * Math.pow(ant, temp);
				temp++;
			}
		}

		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();
	}

}
