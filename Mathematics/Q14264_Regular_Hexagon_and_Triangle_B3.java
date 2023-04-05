package Mathematics;

import java.io.*;

public class Q14264_Regular_Hexagon_and_Triangle_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int l = Integer.parseInt(br.readLine());

		double s = Math.pow(l, 2) * Math.sqrt(3) / 4;

		bw.write(s + "");

		bw.flush();
		bw.close();

	}
}