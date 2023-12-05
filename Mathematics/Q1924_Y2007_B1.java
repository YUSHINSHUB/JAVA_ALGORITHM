package Mathematics;

import java.io.*;
import java.util.*;

public class Q1924_Y2007_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String day[] = br.readLine().split(" ");

		int m = Integer.parseInt(day[0]);
		int d = Integer.parseInt(day[1]);

		switch (m) {
		case 1:
			break;
		case 2:
			d += 31;
			break;
		case 3:
			d += 59;
			break;
		case 4:
			d += 90;
			break;
		case 5:
			d += 120;
			break;
		case 6:
			d += 151;
			break;
		case 7:
			d += 181;
			break;
		case 8:
			d += 212;
			break;
		case 9:
			d += 243;
			break;
		case 10:
			d += 273;
			break;
		case 11:
			d += 304;
			break;
		case 12:
			d += 334;
			break;
		}

		int wd = d % 7;

		switch (wd) {
		case 1:
			bw.write("MON");
			break;
		case 2:
			bw.write("TUE");
			break;
		case 3:
			bw.write("WED");
			break;
		case 4:
			bw.write("THU");
			break;
		case 5:
			bw.write("FRI");
			break;
		case 6:
			bw.write("SAT");
			break;
		case 0:
			bw.write("SUN");
			break;
		}

		bw.flush();
		bw.close();

	}
}
