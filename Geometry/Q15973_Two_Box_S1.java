package Geometry;

/*
commented by ChatGPT
This Java code determines the relationship between two given rectangles based on their coordinates and categorizes the interaction as NULL, POINT, LINE, or FACE.
이 Java 코드는 주어진 두 개의 사각형의 좌표를 바탕으로 그들 사이의 관계를 NULL, POINT, LINE 또는 FACE로 분류합니다.
*/

import java.io.*;

public class Q15973_Two_Box_S1 {

	public static void main(String[] args) throws IOException {

		// Initializing input and output streams to read from and write to the console.
		// 콘솔로부터 입력을 받고 출력하기 위한 스트림을 초기화합니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Reading coordinates for the first rectangle from input
		// 첫 번째 사각형의 좌표를 입력에서 읽습니다.
		String inp[] = br.readLine().split(" ");
		int x1 = Integer.parseInt(inp[0]);
		int y1 = Integer.parseInt(inp[1]);
		int p1 = Integer.parseInt(inp[2]);
		int q1 = Integer.parseInt(inp[3]);

		// Reading coordinates for the second rectangle from input
		// 두 번째 사각형의 좌표를 입력에서 읽습니다.
		inp = br.readLine().split(" ");
		int x2 = Integer.parseInt(inp[0]);
		int y2 = Integer.parseInt(inp[1]);
		int p2 = Integer.parseInt(inp[2]);
		int q2 = Integer.parseInt(inp[3]);

		// Checking the relationship between the two rectangles and writing the
		// appropriate response
		// 두 사각형 사이의 관계를 확인하고 적절한 응답을 작성합니다.
		if (x1 > p2 || y1 > q2 || p1 < x2 || q1 < y2)
			bw.write("NULL");
		else if ((x1 == p2 && y1 == q2) || (p1 == x2 && y1 == q2) || (x1 == p2 && q1 == y2) || (p1 == x2 && q1 == y2))
			bw.write("POINT");
		else if ((x1 == p2) || (y1 == q2) || (p1 == x2) || (q1 == y2))
			bw.write("LINE");
		else
			bw.write("FACE");

		// Flushing and closing the output stream
		// 출력 스트림을 비우고 닫습니다.
		bw.flush();
		bw.close();
	}
}
