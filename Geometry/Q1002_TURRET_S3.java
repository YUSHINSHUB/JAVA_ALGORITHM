package Geometry;

import java.io.*;
import java.math.*;

public class Q1002_TURRET_S3 {

	public static void main(String[] args) throws IOException {
		// 두 좌표를 기준으로 각각 반지름이 r1, r2인 원이 있다 가정하여 접점을 찾는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String inp[] = br.readLine().split(" ");
			int x1 = Integer.parseInt(inp[0]);
			int y1 = Integer.parseInt(inp[1]);
			int r1 = Integer.parseInt(inp[2]);
			int x2 = Integer.parseInt(inp[3]);
			int y2 = Integer.parseInt(inp[4]);
			int r2 = Integer.parseInt(inp[5]);

			if (x1 == x2 && y1 == y2 && r1 == r2) {
				// 두 원이 일치 (접점이 무한)
				bw.write("-1\n");
			} else {

				if (r2 > r1) {
					int temp = x1;
					x1 = x2;
					x2 = temp;

					temp = y1;
					y1 = y2;
					y2 = temp;

					temp = r1;
					r1 = r2;
					r2 = temp;
				}

				int dis = (int) (Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
				// 두 좌표간의 거리는 해당 값의 제곱근을 구해야 하지만 sqrt를 사용하면 실수형의 오차가 발생할 수 있기 때문에
				// 제곱근을 구하지 않고 그대로 사용한다.

				if (dis < Math.pow(r1 - r2, 2)) {
					// 작은 원이 큰 원 안에 들어있고 접하지 않음.
					bw.write("0\n");
				} else if (dis == Math.pow(r1 - r2, 2)) {
					// 두 원이 내접함.
					bw.write("1\n");
				} else if (Math.pow(r2 + r1, 2) > dis) {
					// 두 원이 겹침
					bw.write("2\n");
				} else if (Math.pow(r2 + r1, 2) < dis) {
					// 두 원이 따로 떨어져있음
					bw.write("0\n");
				} else {
					// 두 원이 외접함
					bw.write("1\n");
				}
			}

		}

		bw.flush();
		bw.close();

	}
}