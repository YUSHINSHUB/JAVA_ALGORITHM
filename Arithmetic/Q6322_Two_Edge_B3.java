package Arithmetic;

/*
commented by ChatGPT
This Java code calculates missing sides of right-angled triangles using the Pythagorean theorem. 
It reads multiple sets of inputs representing the sides of a triangle (a, b, c, where c is the hypotenuse), where -1 indicates a missing side. 
For each set, the program checks for possible scenarios: impossible triangle, missing hypotenuse, or missing one of the other sides. 
It prints the result for each triangle or declares it impossible if the conditions are not met (e.g., non-positive side lengths, a or b greater than or equal to c). 
The program terminates when an input set of 0 0 0 is received.

이 Java 코드는 피타고라스 정리를 사용하여 직각삼각형의 누락된 변을 계산합니다. 
삼각형의 변을 나타내는 여러 세트의 입력(변 a, b, c, 여기서 c는 빗변)을 읽으며, -1은 누락된 변을 나타냅니다. 
각 세트에 대해, 프로그램은 불가능한 삼각형, 누락된 빗변, 또는 다른 한 변의 누락 여부를 확인합니다. 
각 삼각형에 대한 결과를 출력하거나 조건이 충족되지 않으면 불가능하다고 선언합니다(예: 양수가 아닌 변 길이, a 또는 b가 c보다 크거나 같은 경우). 
0 0 0의 입력 세트가 수신되면 프로그램이 종료됩니다.
*/

import java.io.*;

public class Q6322_Two_Edge_B3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a, b, c;
		int idx = 0;

		while (true) {
			String inp[] = br.readLine().split(" ");
			a = Integer.parseInt(inp[0]);
			b = Integer.parseInt(inp[1]);
			c = Integer.parseInt(inp[2]);
			idx++;

			// 프로그램 종료 조건 확인
			if (a == 0 && b == 0 && c == 0)
				break;

			// 불가능한 삼각형 조건 확인
			else if (a == 0 || b == 0 || c == 0)
				bw.write("Triangle #" + idx + "\n" + "Impossible.\n\n");

			// 빗변 c가 누락된 경우
			else if (c == -1) {
				bw.write("Triangle #" + idx + "\n");
				bw.write("c = " + String.format("%.3f", Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2))) + "\n\n");
			}

			else if (a >= c || b >= c)
				bw.write("Triangle #" + idx + "\n" + "Impossible.\n\n");

			// 변 a가 누락된 경우
			else if (a == -1) {
				bw.write("Triangle #" + idx + "\n");
				bw.write(String.format("a = " + "%.3f", Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2))) + "\n\n");
			}

			// 변 b가 누락된 경우
			else if (b == -1) {
				bw.write("Triangle #" + idx + "\n");
				bw.write(String.format("b = " + "%.3f", Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2))) + "\n\n");
			}
		}

		bw.flush();
		bw.close();
	}
}