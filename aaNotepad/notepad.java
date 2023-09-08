package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static ArrayList<Long> list = new ArrayList<>();

	static void bt(long n) {
			for (int i = 0; i <= 9; i++) {
				if (i < n % 10) {
					list.add(n * 10 + i);
					bt(n * 10 + i);
				}
			}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		list.add((long)0);
		for (int i = 1; i <= 9; i++) {
			list.add((long)i);
			bt(i);
		}

		Collections.sort(list);

		if( n >= list.size() ) bw.write("-1");
		else bw.write(list.get(n) + "");
		bw.flush();
		bw.close();

	}
}
