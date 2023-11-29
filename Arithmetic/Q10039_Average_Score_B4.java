package Arithmetic;

import java.io.*;

public class Q10039_Average_Score_B4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int score[] = new int[5];
		int sum = 0;

		for (int i = 0; i < 5; i++) {
			score[i] = Integer.parseInt(br.readLine());
			if (score[i] < 40) {
				score[i] = 40;
			}
			sum += score[i];
		}

		int avr = sum / 5;

		bw.write(String.valueOf(avr));

		bw.flush();
		bw.close();

	}

}
