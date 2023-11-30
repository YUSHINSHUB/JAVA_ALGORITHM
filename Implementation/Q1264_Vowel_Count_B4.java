package Implementation;

import java.io.*;

public class Q1264_Vowel_Count_B4 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in;
		int res;
		char c;

		while ((in = br.readLine()) != null) {
			if (in.equals("#"))
				break;

			res = 0;
			for (int i = 0; i < in.length(); i++) {
				c = in.charAt(i);
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
					res++;
				else if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
					res++;
			}

			bw.write(res + "\n");
		}

		bw.flush();
		bw.close();
	}
}
