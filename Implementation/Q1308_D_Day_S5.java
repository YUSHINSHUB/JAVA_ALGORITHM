package Implementation;

/*
commented by ChatGPT
This Java program calculates the number of days between two given dates. 
It accounts for leap years and considers a 1000-year difference as a special case, outputting "gg" for such scenarios.
이 Java 프로그램은 주어진 두 날짜 사이의 일수를 계산합니다. 
윤년을 고려하며, 1000년의 차이가 있는 경우에는 특별한 경우로 간주하고 "gg"를 출력합니다.
*/

import java.io.*;

public class Q1308_D_Day_S5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int y1, m1, d1, y2, m2, d2; // Variables for storing two dates (두 날짜를 저장하기 위한 변수들)
		int res = 0; // Variable to store the result (결과를 저장하는 변수)
		int mon[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // Days in each month (각 월의 일수)

		// Read and parse the first date
		String inp[] = br.readLine().split(" ");
		y1 = Integer.parseInt(inp[0]);
		m1 = Integer.parseInt(inp[1]);
		d1 = Integer.parseInt(inp[2]);

		// Read and parse the second date
		inp = br.readLine().split(" ");
		y2 = Integer.parseInt(inp[0]);
		m2 = Integer.parseInt(inp[1]);
		d2 = Integer.parseInt(inp[2]);

		// Check for the special 1000-year difference case
		if (y2 > y1 + 1000 || (y2 == y1 + 1000 && (m2 > m1 || (m2 == m1 && d2 >= d1)))) {
			bw.write("gg");
		} else {
			// Calculate the number of days between the two dates
			while (true) {
				res += mon[m1]; // Add days of the current month (현재 월의 일수 추가)
				// Check for leap year in February (2월에 윤년 확인)
				if (m1 == 2) {
					if (y1 % 400 == 0 || (y1 % 100 != 0 && y1 % 4 == 0))
						res++; // Add an extra day for leap years (윤년에는 하루 추가)
				}
				m1++;
				// Reset month and increment year (월을 초기화하고 연도 증가)
				if (m1 == 13) {
					m1 = 1;
					y1++;
				}
				// Break if reached the second date (두 번째 날짜에 도달하면 중단)
				if (y1 == y2 && m1 == m2)
					break;
			}
			res += d2 - d1; // Add the difference in days of the two dates (두 날짜의 일수 차이 추가)
			bw.write("D-" + res); // Output the result (결과 출력)
		}

		bw.flush(); // Flush the buffer (버퍼 플러시)
		bw.close(); // Close the writer (쓰기 닫기)

	}

}
