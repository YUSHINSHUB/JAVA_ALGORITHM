package Implementation;

import java.io.*;

public class Q10162_MICROWAVE_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int time = Integer.parseInt(br.readLine());

		int m5 = time / 300;
		int m1 = (time % 300) / 60;
		int s10 = (time % 60) / 10;

		if (time % 10 == 0) {
			bw.write(String.valueOf(m5) + " " + String.valueOf(m1) + " " + String.valueOf(s10));
		} else {
			bw.write("-1");
		}

		bw.flush();
		bw.close();

	}

}
