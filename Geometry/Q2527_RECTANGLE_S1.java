package Geometry;

/*
commented by ChatGPT
이 코드는 두 개의 사각형의 좌표를 바탕으로 그들 사이의 관계를 판단하는 Java 구현입니다.
*/

import java.io.*;

public class Q2527_RECTANGLE_S1 {

	public static void main(String[] args) throws IOException {

		// 콘솔로부터 입력을 받기 위한 BufferedReader 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 콘솔에 출력하기 위한 BufferedWriter 초기화
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 4개의 사각형 좌표 세트를 반복 처리
		for (int i = 0; i < 4; i++) {
			// 입력받은 줄을 공백 기준으로 분리
			String inp[] = br.readLine().split(" ");

			// 첫 번째 사각형의 좌표 값을 파싱
			int x1 = Integer.parseInt(inp[0]);
			int y1 = Integer.parseInt(inp[1]);
			int p1 = Integer.parseInt(inp[2]);
			int q1 = Integer.parseInt(inp[3]);
			// 두 번째 사각형의 좌표 값을 파싱
			int x2 = Integer.parseInt(inp[4]);
			int y2 = Integer.parseInt(inp[5]);
			int p2 = Integer.parseInt(inp[6]);
			int q2 = Integer.parseInt(inp[7]);

			// 사각형들이 서로 떨어져 있는 경우
			if (x1 > p2 || y1 > q2 || p1 < x2 || q1 < y2)
				bw.write("d\n");
			// 사각형들이 점에서 만나는 경우
			else if ((x1 == p2 && y1 == q2) || (p1 == x2 && y1 == q2) || (x1 == p2 && q1 == y2)
					|| (p1 == x2 && q1 == y2))
				bw.write("c\n");
			// 사각형들이 선에서 만나는 경우
			else if ((x1 == p2) || (y1 == q2) || (p1 == x2) || (q1 == y2))
				bw.write("b\n");
			// 사각형들이 서로 겹치는 경우
			else
				bw.write("a\n");
		}

		// 출력 스트림을 비우고 닫음
		bw.flush();
		bw.close();
	}
}
