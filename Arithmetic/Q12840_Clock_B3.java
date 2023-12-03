package Arithmetic;

/*
commented by ChatGPT
This Java code processes a series of queries on a digital clock. 
It reads the initial time in hours, minutes, and seconds, and the number of queries. 
For each query, the code updates the time by adding or subtracting seconds, ensuring that the time stays within the bounds of a day (24 hours). 
It handles three types of queries: adding seconds, subtracting seconds, and displaying the current time. 
The time is adjusted to stay within 0 to 86399 seconds (24 hours), and when displaying, it's converted back to the format of hours, minutes, and seconds.

이 Java 코드는 디지털 시계에 대한 일련의 쿼리를 처리합니다. 
초기 시간을 시, 분, 초로 읽고 쿼리의 수를 읽습니다. 
각 쿼리에 대해 코드는 시간을 초 단위로 더하거나 빼면서 하루(24시간)의 범위 내에서 시간을 유지합니다. 
세 가지 유형의 쿼리를 처리합니다: 초를 더하기, 초를 빼기, 현재 시간 표시하기. 시간은 0초에서 86399초(24시간) 사이로 조정되며 표시할 때는 시, 분, 초 형식으로 다시 변환됩니다.
*/

import java.io.*;

public class Q12840_Clock_B3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int h, m, s;
		int time;
		int q, T, c;

		// 시간을 초 단위로 초기화
		String inp[] = br.readLine().split(" ");
		h = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		s = Integer.parseInt(inp[2]);
		time = s + (m * 60) + (h * 3600);
		q = Integer.parseInt(br.readLine());

		for (int i = 0; i < q; i++) {
			inp = br.readLine().split(" ");
			T = Integer.parseInt(inp[0]);
			switch (T) {
			case 1: // 초를 더하는 쿼리 처리
				c = Integer.parseInt(inp[1]);
				time += c;
				time %= 86400; // 하루의 범위를 넘어가지 않도록 조정
				break;
			case 2: // 초를 빼는 쿼리 처리
				c = Integer.parseInt(inp[1]);
				time -= c;
				while (time < 0)
					time += 86400; // 음수가 되지 않도록 조정
				break;
			case 3: // 현재 시간 표시 쿼리 처리
				bw.write((time / 3600) + " " + (time % 3600 / 60) + " " + (time % 3600 % 60) + "\n");
				break;
			}
		}

		bw.flush();
		bw.close();
	}
}