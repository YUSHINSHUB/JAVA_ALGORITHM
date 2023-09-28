package Geometry;

/*
commented by ChatGPT
This Java code computes the area of a polygon given its vertices using the Shoelace formula. 
The area is outputted as a decimal value.
이 Java 코드는 주어진 꼭지점을 사용하여 다각형의 면적을 신발끈 공식을 사용하여 계산합니다. 
면적은 소수점 값으로 출력됩니다.
*/

import java.io.*;
import java.math.*;

public class Q2166_Area_of_Polygon_G5 {

	public static void main(String[] args) throws IOException {

		// Initializing input and output streams to read from and write to the console.
		// 콘솔에서 읽고 쓰기 위해 입출력 스트림을 초기화합니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Reading the number of vertices
		// 꼭지점의 수를 읽습니다.
		int n = Integer.parseInt(br.readLine());
		double x[] = new double[n];
		double y[] = new double[n];
		double xs = 0;
		double ys = 0;

		// Reading the vertices
		// 꼭지점을 읽습니다.
		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			x[i] = Double.parseDouble(inp[0]);
			y[i] = Double.parseDouble(inp[1]);
		}

		// Applying the Shoelace formula to calculate the area
		// 신발끈 공식을 적용하여 면적을 계산합니다.
		for (int i = 0; i < n - 1; i++) {
			xs += x[i] * y[i + 1];
			ys += y[i] * x[i + 1];
		}

		xs += x[n - 1] * y[0];
		ys += y[n - 1] * x[0];

		xs = Math.abs(xs - ys);

		// Formatting and outputting the result
		// 결과를 형식화하고 출력합니다.
		long res = (long) xs;
		if (res % 2 == 0)
			bw.write(res / 2 + ".0");
		else
			bw.write(res / 2 + ".5");

		// Flushing and closing the output stream
		// 출력 스트림을 비우고 닫습니다.
		bw.flush();
		bw.close();
	}
}
