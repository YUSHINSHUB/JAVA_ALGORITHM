package Implementation;

import java.io.*;
import java.util.*;

public class Q10807_Count_B5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		int n = Integer.parseInt(br.readLine());

		String temp[] = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			hm.put(Integer.parseInt(temp[i]), hm.getOrDefault(Integer.parseInt(temp[i]), 0) + 1);
		}

		int v = Integer.parseInt(br.readLine());

		bw.write(hm.getOrDefault(v, 0) + "");

		bw.flush();
		bw.close();

	}
}
