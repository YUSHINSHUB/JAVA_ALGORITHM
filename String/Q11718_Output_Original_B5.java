package String;

import java.io.*;

public class Q11718_Output_Original_B5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str;
		while ((str = br.readLine()) != null) {
			bw.write(str + "\n");
		}

		bw.flush();
		bw.close();

	}

}
