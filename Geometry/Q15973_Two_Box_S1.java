package Geometry;

/*
commented by ChatGPT
This Java code determines the relationship between two given rectangles based on their coordinates and categorizes the interaction as NULL, POINT, LINE, or FACE.
�� Java �ڵ�� �־��� �� ���� �簢���� ��ǥ�� �������� �׵� ������ ���踦 NULL, POINT, LINE �Ǵ� FACE�� �з��մϴ�.
*/

import java.io.*;

public class Q15973_Two_Box_S1 {

	public static void main(String[] args) throws IOException {

		// Initializing input and output streams to read from and write to the console.
		// �ַܼκ��� �Է��� �ް� ����ϱ� ���� ��Ʈ���� �ʱ�ȭ�մϴ�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Reading coordinates for the first rectangle from input
		// ù ��° �簢���� ��ǥ�� �Է¿��� �н��ϴ�.
		String inp[] = br.readLine().split(" ");
		int x1 = Integer.parseInt(inp[0]);
		int y1 = Integer.parseInt(inp[1]);
		int p1 = Integer.parseInt(inp[2]);
		int q1 = Integer.parseInt(inp[3]);

		// Reading coordinates for the second rectangle from input
		// �� ��° �簢���� ��ǥ�� �Է¿��� �н��ϴ�.
		inp = br.readLine().split(" ");
		int x2 = Integer.parseInt(inp[0]);
		int y2 = Integer.parseInt(inp[1]);
		int p2 = Integer.parseInt(inp[2]);
		int q2 = Integer.parseInt(inp[3]);

		// Checking the relationship between the two rectangles and writing the
		// appropriate response
		// �� �簢�� ������ ���踦 Ȯ���ϰ� ������ ������ �ۼ��մϴ�.
		if (x1 > p2 || y1 > q2 || p1 < x2 || q1 < y2)
			bw.write("NULL");
		else if ((x1 == p2 && y1 == q2) || (p1 == x2 && y1 == q2) || (x1 == p2 && q1 == y2) || (p1 == x2 && q1 == y2))
			bw.write("POINT");
		else if ((x1 == p2) || (y1 == q2) || (p1 == x2) || (q1 == y2))
			bw.write("LINE");
		else
			bw.write("FACE");

		// Flushing and closing the output stream
		// ��� ��Ʈ���� ���� �ݽ��ϴ�.
		bw.flush();
		bw.close();
	}
}
