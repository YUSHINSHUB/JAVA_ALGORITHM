package Implementation;

import java.io.*;

public class Q2920_SCALE_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] nums = br.readLine().split(" ");

		String out = "mixed";

		if (Integer.parseInt(nums[0]) == 1) {
			out = "ascending";
			for (int i = 1; i < 8; i++) {
				if (Integer.parseInt(nums[i]) != i + 1) {
					out = "mixed";
					break;
				}
			}
		} else if (Integer.parseInt(nums[0]) == 8) {
			out = "descending";
			for (int i = 1; i < 8; i++) {
				if (Integer.parseInt(nums[i]) != 8 - i) {
					out = "mixed";
					break;
				}
			}
		}

		bw.write(out);

		bw.flush();
		bw.close();

	}

}
