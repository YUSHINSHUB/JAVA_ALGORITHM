package Number_Theory;
/*
commented by ChatGPT
This Java code calculates the year in which an event that occurs every 15, 28, and 19 years will coincide, given the current year's position in each cycle.
The input consists of three integers representing the current year's position in the Earth, Sun, and Moon cycles, and the output is the first year where all three cycles coincide.
이 Java 코드는 15년, 28년, 19년마다 일어나는 사건이 주어진 각 사이클에서 현재 연도의 위치를 기준으로 겹치는 연도를 계산합니다.
입력은 지구, 태양, 달 사이클에서 현재 연도의 위치를 나타내는 세 정수로 구성되며, 출력은 세 사이클이 모두 겹치는 첫 번째 연도입니다.
*/

import java.io.*;

public class Q1476_Calculate_Date_S5 {
	public static void main(String[] args) throws IOException {
		// Reader and writer to handle input/output
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the positions in the respective cycles
		String inp[] = br.readLine().split(" ");

		// Earth, Sun, and Moon cycles
		int e = Integer.parseInt(inp[0]);
		int s = Integer.parseInt(inp[1]);
		int m = Integer.parseInt(inp[2]);

		// The result starts from the position in the Sun cycle
		int res = s;

		// If any cycle is at its last year, reset it to 0
		if (e == 15)
			e = 0;
		if (s == 28)
			s = 0;
		if (m == 19)
			m = 0;

		// Iterate until the year matches all three cycles
		while (res % 15 != e || res % 28 != s || res % 19 != m) {
			res += 28; // Increment by the length of the Sun cycle
		}

		// Write the result year when all cycles coincide
		bw.write(res + "");

		// Flush and close the writer
		bw.flush();
		bw.close();
	}
}
