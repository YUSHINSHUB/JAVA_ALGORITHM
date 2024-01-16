package Geometry;

/*
commented by ChatGPT
This Java code determines the counter-clockwise orientation of three given points using the CCW (Counter ClockWise) formula and outputs 0, 1, or -1 based on the result.
이 Java 코드는 세 주어진 점의 반시계 방향 위치를 CCW(Counter ClockWise) 공식을 사용하여 판정하고, 결과에 따라 0, 1, 또는 -1을 출력합니다.
*/

import java.io.*;

public class Q11758_CCW_G5 {

	public static void main(String[] args) throws IOException {

		// Initializing input and output streams to read from and write to the console.
		// 콘솔에서 읽고 쓰기 위한 입출력 스트림을 초기화합니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Initializing arrays to store x and y coordinates of the three points
		// 세 점의 x와 y 좌표를 저장하기 위한 배열을 초기화합니다.
		int x[] = new int[3];
		int y[] = new int[3];

		// Reading the coordinates of the three points
		// 세 점의 좌표를 읽습니다.
		for (int i = 0; i < 3; i++) {
			String inp[] = br.readLine().split(" ");
			x[i] = Integer.parseInt(inp[0]);
			y[i] = Integer.parseInt(inp[1]);
		}

		// Applying the CCW formula to determine the orientation
		// CCW 공식을 적용하여 위치를 결정합니다.
		int ccw = (x[1] - x[0]) * (y[2] - y[0]) - (x[2] - x[0]) * (y[1] - y[0]);

		// Determining the orientation based on the result and writing the result
		// 결과를 기반으로 위치를 결정하고 결과를 작성합니다.
		if (ccw == 0)
			bw.write("0");
		else if (ccw > 0)
			bw.write("1");
		else
			bw.write("-1");

		// Flushing and closing the output stream
		// 출력 스트림을 비우고 닫습니다.
		bw.flush();
		bw.close();
	}
}
