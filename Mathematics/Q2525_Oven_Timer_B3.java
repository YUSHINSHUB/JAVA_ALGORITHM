package Mathematics;

import java.io.*;

public class Q2525_Oven_Timer_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String time[] = br.readLine().split(" ");
		int hours, minutes;

		hours = Integer.parseInt(time[0]);
		minutes = Integer.parseInt(time[1]);

		int spent = Integer.parseInt(br.readLine());

		minutes += spent;

		while (minutes >= 60) {
			minutes -= 60;
			hours++;
		}

		while (hours >= 24) {
			hours -= 24;
		}

		bw.write(String.valueOf(hours) + " " + String.valueOf(minutes));

		bw.flush();
		bw.close();

	}

}