package Number_Theory;

import java.io.*;
import java.math.*;

public class Q13909_Close_S5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 제곱수가 아닌 창문들은 약수가 쌍을 이루기 때문에 모두 닫힌다.
		// 예시: 6의 약수는 1 - 6, 2 - 3
		// 그러므로 같은 수 끼리의 곱인 제곱수가 약수의 개수가 홀수가 되어서 열린 상태가 된다.

		// 입력받은 정수 n을 읽어옵니다.
		int n = Integer.parseInt(br.readLine());
		int idx = 1;

		// n이 idx의 제곱보다 작을 때까지 idx 값을 증가시킵니다.
		// 즉, idx는 n의 제곱근 이하의 가장 큰 정수를 찾는 과정입니다.
		while (Math.pow(idx, 2) < n) {
			idx++;
		}

		// 위의 while loop에서 idx가 n의 제곱근 이상의 값을 가질 수 있으므로,
		// n이 idx의 제곱이 아닐 경우 idx를 하나 감소시킵니다.
		if ((int) Math.pow(idx, 2) != n)
			idx--;

		// n의 제곱근 이하의 가장 큰 정수인 idx를 출력합니다.
		bw.write(idx + "");

		bw.flush();
		bw.close();

	}
}