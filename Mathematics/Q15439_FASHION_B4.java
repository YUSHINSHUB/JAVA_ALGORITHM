//이 코드는 주어진 숫자 n에 대해 nP2를 계산하고 그 결과를 출력합니다. nP2는 n개의 서로 다른 원소에서 2개를 선택하여 일렬로 나열하는 
//경우의 수를 나타냅니다. 이 계산은 nPr 함수를 통해 수행되며, 시작점은 n - r + 1로 계산되고, 그 값부터 n까지의 모든 숫자를 곱하여 
//결과를 얻습니다.

package Mathematics;

import java.io.*;
import java.util.*;

public class Q15439_FASHION_B4 {

	// nPr을 계산하는 함수입니다.
	// nPr은 n개의 서로 다른 원소에서 r개를 선택하여 일렬로 나열하는 경우의 수를 나타냅니다.
	static long npr(int n, int r) {

		int t = n - r + 1; // nPr의 계산을 시작할 시작점을 결정합니다.
		long res = 1; // 결과값을 저장할 변수입니다.

		// 시작점에서 n까지의 모든 숫자를 곱합니다. 이것이 nPr의 정의에 따른 계산 결과입니다.
		for (int i = t; i <= n; i++) {
			res *= i;
		}
		return res; // 결과를 반환합니다.

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력을 받아와 n에 저장합니다.
		int n = Integer.parseInt(br.readLine());

		// nP2를 계산하고, 결과를 문자열로 변환하여 출력합니다.
		bw.write(npr(n, 2) + "");

		bw.flush();
		bw.close();
	}
}