package Number_Theory;

import java.io.*;

public class Q2004_Number_of_Zero_S2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] nm = br.readLine().split(" ");

		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		int nmm = n - m;

		// 조합 nCm은 (n!) / m!(n-m)! 로 구할 수 있다.

		int fcnt = 0;
		int tcnt = 0;

		while (n >= 5) {
			fcnt += n / 5;
			n /= 5;
		}
		// 해당 공식은 n의 팩토리얼을 소인수분해 했을 떄 특정 인수의 승수(제곱한 횟수)를 구해준다.
		// n이 25일 떄 fcnt는 5 + 1 = 6이 되므로 25!를 소인수 분해하면 5^6 * ... 의 형태를 갖는다.

		while (m >= 5) {
			fcnt -= m / 5;
			m /= 5;
		}

		while (nmm >= 5) {
			fcnt -= nmm / 5;
			nmm /= 5;
		}

		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		nmm = n - m;

		while (n >= 2) {
			tcnt += n / 2;
			n /= 2;
		}

		while (m >= 2) {
			tcnt -= m / 2;
			m /= 2;
		}

		while (nmm >= 2) {
			tcnt -= nmm / 2;
			nmm /= 2;
		}

		// 결과값의 뒷자리가 0이라는 것은 소인수 분해를 했을때 2 * 5가 0의 갯수만큼 쌍으로 존재한다는 것이다.
		// 결과값이 ...00일 경우 소인수 분해 하면 ... * 2^2 * 5*2이 된다.
		// 그러므로 n!을 소인수분해 하였을 떄 5의 승수에서 m!, (n-m)!의 5의 승수를 빼주고
		// 2의 승수로도 똑같이 해준 후 둘중 작은 값을 구하면 조합의 수에서 2와 5가 몇쌍인지 알 수 있으며 이는 0의 개수가 된다.

		bw.write(String.valueOf(Math.min(fcnt, tcnt)));

		bw.flush();
		bw.close();

	}

}