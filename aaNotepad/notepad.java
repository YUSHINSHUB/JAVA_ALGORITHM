package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = (int) Math.pow(2, Integer.parseInt(br.readLine()));
		bw.write(n + "");

		bw.flush();
		bw.close();

	}
}