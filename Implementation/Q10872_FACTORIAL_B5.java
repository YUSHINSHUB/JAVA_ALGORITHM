//이 프로그램은 사용자로부터 입력받은 수에 대한 팩토리얼(factorial)을 계산합니다. 
//팩토리얼은 주어진 수에서 1까지의 모든 정수를 곱한 것을 의미합니다. 
//예를 들어, 5의 팩토리얼은 5 * 4 * 3 * 2 * 1 = 120 입니다. 
//이 프로그램에서는 for문을 사용하여 이 곱셈을 수행하고 결과를 출력합니다.

package Implementation;

import java.io.*;

public class Q10872_FACTORIAL_B5 {
	public static void main(String[] args) throws IOException {
		// BufferedReader와 BufferedWriter 객체를 생성합니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 사용자로부터 입력을 받아서 int로 변환합니다.
		int n = Integer.parseInt(br.readLine());

		// 팩토리얼 연산을 위해 초기값 1을 가지는 변수를 선언합니다.
		int res = 1;

		// for문을 사용하여 1부터 n까지의 숫자를 모두 곱합니다.
		for (int i = 1; i <= n; i++) {
			res *= i;
		}

		// 계산된 팩토리얼 값을 문자열로 변환하여 출력합니다.
		bw.write(String.valueOf(res));

		// BufferedWriter를 flush하여 버퍼에 남아있는 데이터를 모두 출력하고, BufferedWriter를 닫습니다.
		bw.flush();
		bw.close();
	}
}