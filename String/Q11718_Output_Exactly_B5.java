package String;

import java.io.*;

public class Q11718_Output_Exactly_B5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String str = br.readLine();
			if (str == null || str.length() == 0) {
				break;
			}
			bw.write(str + "\n");
		}

		bw.flush();
		bw.close();

	}

}