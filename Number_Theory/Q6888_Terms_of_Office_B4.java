package Number_Theory;

/*
commented by ChatGPT
This Java program prints the years in which "all positions change" in a given range.
This is a reference to a tradition that occurs every 60 years.
이 Java 프로그램은 주어진 범위 안에서 "모든 위치가 변경되는" 연도를 출력합니다.
이것은 60년마다 일어나는 전통에 대한 참조입니다.
*/

import java.io.*;

public class Q6888_Terms_of_Office_B4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the starting year from input (시작 연도를 입력으로부터 읽음)
		int X = Integer.parseInt(br.readLine());
		// Read the ending year from input (끝 연도를 입력으로부터 읽음)
		int Y = Integer.parseInt(br.readLine());

		// Iterate from the starting year to the ending year (시작 연도부터 끝 연도까지 반복)
		while (X <= Y) {
			// Write to the output buffer the years when all positions change (모든 위치가 변경되는
			// 연도를 출력 버퍼에 작성)
			bw.write("All positions change in year " + X + "\n");
			// Increment the year by 60, as the tradition occurs every 60 years (전통이 60년마다
			// 일어나므로 연도를 60씩 증가)
			X += 60;
		}

		// Flush the output stream to ensure all data is written out (모든 데이터가 쓰여지도록 출력
		// 스트림을 플러시)
		bw.flush();
		// Close the BufferedWriter to free system resources (시스템 자원을 해제하기 위해
		// BufferedWriter를 닫음)
		bw.close();
	}
}
