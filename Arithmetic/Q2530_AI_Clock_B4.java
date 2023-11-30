package Arithmetic;

import java.io.*;

public class Q2530_AI_Clock_B4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String times[] = br.readLine().split(" ");
		int time[] = new int[3];

		int spent = Integer.parseInt(br.readLine());

		for (int i = 0; i < 3; i++) {
			time[i] = Integer.parseInt(times[i]);
		}

		time[2] = time[2] + spent;

		while (time[2] >= 60) {
			time[2] -= 60;
			time[1]++;
		}

		while (time[1] >= 60) {
			time[1] -= 60;
			time[0]++;
		}

		while (time[0] >= 24) {
			time[0] -= 24;
		}

		bw.write(String.valueOf(time[0]) + " " + String.valueOf(time[1]) + " " + String.valueOf(time[2]));

		bw.flush();
		bw.close();

	}

}