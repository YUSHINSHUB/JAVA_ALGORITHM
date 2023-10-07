package Number_Theory;

/*
commented by ChatGPT
이 Java 코드는 상근이의 수학 게임을 해결하기 위한 것입니다. 주어진 N개의 숫자들 중에서 특정한 규칙을 만족하는 수 M을 찾는 문제입니다. 
N개의 숫자들을 M으로 나누었을 때 나머지가 모두 같게 되는 M을 찾아야 합니다. M은 1보다 커야 합니다.
*/

import java.io.*;
import java.util.*;

public class Q2981_CHECK_G4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int cards[] = new int[n];
		int nums[] = new int[n - 1];

		// N개의 숫자를 입력 받는다. (Receive N numbers)
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(br.readLine());
		}

		// 숫자들을 정렬한다. (Sort the numbers)
		Arrays.sort(cards);

		// 연속된 숫자들 사이의 차이를 계산한다. (Calculate the difference between consecutive numbers)
		for (int i = 1; i < n; i++) {
			nums[i - 1] = cards[i] - cards[i - 1];
		}

		// 차이값들을 정렬한다. (Sort the difference values)
		Arrays.sort(nums);

		boolean out = true;
		int gdc = 0;

		// 가능한 M의 값들 중 최대공약수를 찾는다. (Finding the greatest common divisor among possible
		// values of M)
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

		// 최대공약수의 약수들을 찾아 출력한다. (Finding and printing the divisors of the greatest
		// common divisor)
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
