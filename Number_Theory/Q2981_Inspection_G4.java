package Number_Theory;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2981_Inspection_G4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int cards[] = new int[n];
		int nums[] = new int[n - 1];

		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(cards);

		for (int i = 1; i < n; i++) {
			nums[i - 1] = cards[i] - cards[i - 1];
		}

		// 오름차 정렬된 a, b, c의 최대공약수는 b-a. c-b의 최대공약수와 같다.

		Arrays.sort(nums);

		boolean out = true;

		int gdc = 0;

		for (int j = nums[0]; j >= 0; j--) {
			out = true;
			for (int i = 0; i < n - 1; i++) {
				if (nums[i] % j != 0) {
					out = false;
					break;
				}
			}
			if (out) {
				gdc = j;
				break;
			}
		}

		for (int i = 2; i < Math.sqrt(gdc); i++) {
			if (gdc % i == 0)
				bw.write(i + " ");
		}

		for (int i = (int) Math.sqrt(gdc); i >= 1; i--) {
			if (gdc % i == 0)
				bw.write(gdc / i + " ");
		}

		bw.flush();
		bw.close();

	}
}
