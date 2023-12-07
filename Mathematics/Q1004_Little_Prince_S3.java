package Mathematics;

/*
commented by ChatGPT
This Java program calculates the number of planetary systems that must be crossed when traveling between two points in space. 
Each test case consists of the starting and ending points, and the planetary systems represented as circles. 
The program determines if either or both points are inside each planetary system, incrementing the count of crossings accordingly.
이 Java 프로그램은 우주의 두 점 사이를 여행할 때 거쳐야 하는 행성계의 수를 계산합니다. 
각 테스트 케이스는 시작점과 끝점, 그리고 원으로 표현된 행성계로 구성됩니다. 
프로그램은 두 점 중 하나 또는 둘 다 각 행성계 내부에 있는지를 결정하고, 그에 따라 교차하는 횟수를 증가시킵니다.
*/

import java.io.*;

public class Q1004_Little_Prince_S3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T; // Number of test cases (테스트 케이스의 수)
		int x1, y1, x2, y2; // Coordinates of start and end points (시작점과 끝점의 좌표)
		int x, y, r; // Coordinates and radius of each planetary system (각 행성계의 좌표 및 반지름)
		int pdistance, ddistance; // Distances from start and end points to the center of a planetary system (시작점과
									// 끝점에서 행성계 중심까지의 거리)
		int prince = 0; // Count of crossings for the prince's start point (왕자의 시작점의 교차 횟수)
		int dist = 0; // Count of crossings for the destination point (목적지점의 교차 횟수)

		T = Integer.parseInt(br.readLine()); // Read number of test cases (테스트 케이스 수 읽기)

		for (int idx = 0; idx < T; idx++) {
			prince = 0;
			dist = 0;
			String inp[] = br.readLine().split(" ");
			x1 = Integer.parseInt(inp[0]);
			y1 = Integer.parseInt(inp[1]);
			x2 = Integer.parseInt(inp[2]);
			y2 = Integer.parseInt(inp[3]);
			int n = Integer.parseInt(br.readLine()); // Number of planetary systems (행성계의 수)

			for (int i = 0; i < n; i++) {
				inp = br.readLine().split(" ");
				x = Integer.parseInt(inp[0]);
				y = Integer.parseInt(inp[1]);
				r = (int) Math.pow(Integer.parseInt(inp[2]), 2); // Squared radius (제곱된 반지름)

				// Calculate squared distances from start and end points to the center of the
				// planetary system
				pdistance = (int) (Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2));
				ddistance = (int) (Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));

				// Check if the start and/or end points are inside the planetary system
				if (pdistance < r && ddistance < r)
					continue; // Both points inside, no crossing
				else if (pdistance < r) // Start point inside, one crossing
					prince++;
				else if (ddistance < r) // End point inside, one crossing
					dist++;
			}

			// Write the total count of crossings
			bw.write(prince + dist + "\n");
		}

		bw.flush(); // Flush the buffer (버퍼 플러시)
		bw.close(); // Close the writer (쓰기 닫기)

	}

}
