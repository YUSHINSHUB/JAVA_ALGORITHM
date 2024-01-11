package Implementation;

import java.io.*;
import java.util.*;

public class Q5597_Assignment_B5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int i = 0; i < 28; i++) {
			t = Integer.parseInt(br.readLine());
			hm.put(t, 1);
		}

		for (int i = 1; i <= 30; i++) {
			if (hm.getOrDefault(i, 0) == 0)
				bw.write(i + "\n");
		}

		bw.flush();
		bw.close();

	}
}