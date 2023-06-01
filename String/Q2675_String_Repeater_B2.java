package Implementation;

import java.io.*;
import java.util.*;

public class Q2675_String_Repeater_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			for (int z = 0; z < temp[1].length(); z++) {
				for (int x = 0; x < Integer.parseInt(temp[0]); x++) {
					bw.write(temp[1].charAt(z));
				}
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();

	}
}