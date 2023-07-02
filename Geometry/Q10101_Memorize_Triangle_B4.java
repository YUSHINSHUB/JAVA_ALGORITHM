package Geometry;

import java.io.*;

public class Q10101_Memorize_Triangle_B4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int angle[] = new int[3];

		for (int i = 0; i < 3; i++) {
			angle[i] = Integer.parseInt(br.readLine());
		}

		String triangle;

		if (angle[0] + angle[1] + angle[2] == 180) {
			if (angle[0] == 60 && angle[1] == 60 && angle[2] == 60) {
				triangle = "Equilateral";
			} else if (angle[0] == angle[1] || angle[0] == angle[2] || angle[1] == angle[2]) {
				triangle = "Isosceles";
			} else {
				triangle = "Scalene";
			}
		} else {
			triangle = "Error";
		}

		bw.write(triangle);

		bw.flush();
		bw.close();

	}

}
