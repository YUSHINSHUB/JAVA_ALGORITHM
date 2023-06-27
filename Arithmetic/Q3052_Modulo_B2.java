package Arithmetic;

import java.io.*;
import java.util.*;

public class Q3052_Modulo_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean rem = true;
		int temp = 0;
		int nums[] = new int[10];
		int numcnt = 0;

		for (int i = 0; i < 10; i++) {
			rem = true;
			temp = Integer.parseInt(br.readLine()) % 42;
			for (int z = 0; z < numcnt; z++) {
				if (nums[z] == temp) {
					rem = false;
					break;
				}
			}
			if (rem == true) {
				nums[numcnt] = temp;
				numcnt++;
			}
		}

		bw.write(String.valueOf(numcnt));

		bw.flush();
		bw.close();

	}
}