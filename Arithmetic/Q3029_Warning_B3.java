package Arithmetic;

/*
commented by ChatGPT
This Java code calculates the time difference between two given times in a 24-hour format. 
It takes two time inputs in HH:MM:SS format, calculates the difference, and outputs it in the same format. 
If the start and end times are the same, it outputs 24:00:00, representing a full day. 
The code handles scenarios where the end time is the next day or when subtracting smaller units (seconds, minutes) results in negative values by adjusting the larger units (minutes, hours) accordingly.

이 Java 코드는 24시간 형식으로 주어진 두 시간 사이의 시간 차이를 계산합니다. 
HH:MM:SS 형식의 두 시간 입력을 받아 차이를 계산하고 동일한 형식으로 출력합니다. 
시작 시간과 종료 시간이 동일한 경우, 하루 전체를 나타내는 24:00:00을 출력합니다. 
코드는 종료 시간이 다음 날인 경우나 더 작은 단위(초, 분)를 빼서 음수가 되는 경우를 처리하여, 더 큰 단위(분, 시)를 적절히 조정합니다.
*/

import java.io.*;

public class Q3029_Warning_B3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int sh, sm, ss; // 시작 시간의 시, 분, 초
		int eh, em, es; // 종료 시간의 시, 분, 초

		// 시작 시간 입력 받기
		String[] inp = br.readLine().split(":");
		sh = Integer.parseInt(inp[0]);
		sm = Integer.parseInt(inp[1]);
		ss = Integer.parseInt(inp[2]);

		// 종료 시간 입력 받기
		inp = br.readLine().split(":");
		eh = Integer.parseInt(inp[0]);
		em = Integer.parseInt(inp[1]);
		es = Integer.parseInt(inp[2]);

		// 시작 시간과 종료 시간이 동일한 경우 24시간으로 설정
		if (eh == sh && em == sm && es == ss) {
			eh = 24;
			em = 0;
			es = 0;
		} else {
			// 시간 차이 계산
			eh -= sh;
			em -= sm;
			es -= ss;

			// 초 계산 시 음수가 되는 경우 분에서 조정
			if (es < 0) {
				em--;
				es += 60;
			}

			// 분 계산 시 음수가 되는 경우 시에서 조정
			if (em < 0) {
				eh--;
				em += 60;
			}

			// 시 계산 시 음수가 되는 경우 24시간에서 조정
			if (eh < 0) {
				eh += 24;
			}
		}

		// 결과 출력
		bw.write(String.format("%02d:%02d:%02d", eh, em, es));
		bw.flush();
		bw.close();
	}
}