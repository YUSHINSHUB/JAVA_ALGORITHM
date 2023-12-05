package Implementation;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q11721_Split_Ten_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		int index = 0;

		for (int i = 0; i < (s.length() / 10) + 1; i++) {
			for (int z = 0; z < 10; z++) {
				if (index == s.length()) {
					break;
				}
				bw.write(s.charAt((i * 10) + z));
				index++;
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}
