package Primality_Test;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q4134_Next_S4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		// 소수가 아닌 수는 소수의 배수이다. 또한 n의 소수여부를 확인하기 위해 하나하나 나누어 보는 방식을 행할 때에는
		// n-1까지 모두 나눠볼 필요 없이 2부터 소숫점을 버린 n의 제곱근 까지만 나누어 보아도 된다.
		// 최댓값인 40억의 제곱근이 63245.553...임을 이용해서 배열에 63246 이하의 모든 소수를 저장해서 이용한다.
		ArrayList<Integer> prime = new ArrayList<>();
		int pri[] = new int[63247];
		Arrays.fill(pri, 0);
		pri[1] = 1;
		prime.add(2);
		for (int i = 4; i < 63247; i += 2) {
			pri[i] = 1;
		}

		for (int i = 3; i < 63247; i += 2) {
			if (pri[i] == 0) {
				prime.add(i);
				for (int j = i * 2; j < 63247; j += i)
					pri[i] = 1;
			}
		}

		for (int i = 0; i < t; i++) {
			long n = Long.parseLong(br.readLine());
			if (n < 2)
				n = 2;
			for (int j = 0; j < prime.size(); j++) {
				if (prime.get(j) > Math.sqrt(n))
					break;
				if (n % prime.get(j) == 0) {
					j = -1;
					n++;
				}
			}
			bw.write(n + "\n");
		}
		bw.flush();
		bw.close();

	}
}