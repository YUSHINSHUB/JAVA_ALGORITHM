package Arithmetic;

import java.io.*;

public class Q4299_AFC_B4 {

	public static boolean wheint(double win, double los) {

		if (win != (int) win || win < 0) {
			return false;
		} else if (los != (int) los || los < 0) {
			return false;
		}

		return true;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String sumgap[] = br.readLine().split(" ");

		double sum = Integer.parseInt(sumgap[0]);
		double gap = Integer.parseInt(sumgap[1]);

		double win = (sum / 2) + (gap / 2);
		double los = (sum / 2) - (gap / 2);

		if (wheint(win, los) == true) {
			bw.write(String.valueOf((int) (win)) + " " + String.valueOf((int) (los)));
		} else {
			bw.write("-1");
		}
		bw.flush();
		bw.close();

	}

}