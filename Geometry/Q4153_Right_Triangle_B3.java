package Mathematics;

import java.io.*;
import java.math.*;

public class Q4153_Right_Triangle_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String out = "";

		while (true) {

			String[] nums = br.readLine().split(" ");

			int[] num = { Integer.parseInt(nums[0]), Integer.parseInt(nums[1]), Integer.parseInt(nums[2]) };
			if (num[0] == 0 && num[1] == 0 && num[2] == 0) {
				break;
			}
			int max = Math.max(Math.max(num[0], num[1]), num[2]);

			if (max == num[0]) {
				if (Math.pow(max, 2) == Math.pow(num[1], 2) + Math.pow(num[2], 2)) {
					out = "right";
				} else {
					out = "wrong";
				}
			} else if (max == num[1]) {
				if (Math.pow(max, 2) == Math.pow(num[0], 2) + Math.pow(num[2], 2)) {
					out = "right";
				} else {
					out = "wrong";
				}
			} else {
				if (Math.pow(max, 2) == Math.pow(num[0], 2) + Math.pow(num[1], 2)) {
					out = "right";
				} else {
					out = "wrong";
				}
			}
			;

			bw.write(out + "\n");

		}

		bw.flush();
		bw.close();
	}
}
