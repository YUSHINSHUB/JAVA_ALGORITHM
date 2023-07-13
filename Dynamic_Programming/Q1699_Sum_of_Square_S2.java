package Dynamic_Programming;

import java.io.*;

public class Q1699_Sum_of_Square_S2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int square[] = new int[n + 1];
		square[0] = 0;

		for (int i = 1; i <= n; i++) {
			square[i] = i;
			// 1로만 채울 경우
			for (int j = 1; j * j <= i; j++) {
				if (square[i] > (square[i - (j * j)] + 1))
					square[i] = square[i - (j * j)] + 1;
				// j * j 는 제곱수이기 때문에 최소한의 제곱수를 사용하여 i를 만드는 방법은
				// 제곱수 한개 (j*j) 를 더하면 i가 되는 값 (i-j*j) 중에 최소의 제곱수로 만들 수 있는 값을
				// 찾는 것이다.
			}
		}

		bw.write(square[n] + "");

		bw.flush();
		bw.close();

	}
}