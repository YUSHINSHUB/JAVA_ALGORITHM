package Mathematics;

import java.io.*;

public class Q2033_Rounding_B1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int idx = 10;

		while (n > idx) {
			n = (n + (idx / 10 * 5)) / idx * idx; // 예를들어 10의 자리에서 반올림할경우 5를 더하면 올림할 숫자는 앞자리가 바뀌게 된다.
			idx *= 10;
		}

		bw.write(n + "");

		bw.flush();
		bw.close();
	}
}
