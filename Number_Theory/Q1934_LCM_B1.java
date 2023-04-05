package Number_Theory;

import java.io.*;

public class Q1934_LCM_B1 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int tempa;
		int tempb;
		int res = 0;

		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");

			tempa = Integer.parseInt(temp[0]);
			tempb = Integer.parseInt(temp[1]);

			res = Math.max(tempa, tempb);

			while (res % tempa != 0 || res % tempb != 0) {
				res += Math.max(tempa, tempb);
			}

			bw.write(String.valueOf(res + "\n"));

		}
		bw.flush();
		bw.close();

	}
}