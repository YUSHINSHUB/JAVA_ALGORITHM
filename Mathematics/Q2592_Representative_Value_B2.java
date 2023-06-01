package Mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q2592_Representative_Value_B2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int nums[] = new int[10];
		for (int i = 0; i < 10; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(nums);

		int sum = nums[0];
		int mod = nums[0];
		int idx = 0;
		int hidx = 0;

		for (int i = 1; i < 10; i++) {
			if (nums[i] == nums[i - 1]) {
				idx++;
				if (idx > hidx) {
					hidx = idx;
					mod = nums[i];
				}
			} else {
				idx = 0;
			}
			sum += nums[i];
		}

		bw.write((sum / 10) + "\n" + (mod));
		bw.flush();
		bw.close();

	}
}
