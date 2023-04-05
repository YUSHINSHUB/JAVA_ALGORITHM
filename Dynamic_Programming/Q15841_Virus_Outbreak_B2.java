package Dynamic_Programming;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q15841_Virus_Outbreak_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		BigInteger fi[] = new BigInteger[491];
		fi[0] = new BigInteger("0");
		fi[1] = new BigInteger("1");
		fi[2] = new BigInteger("1");
		int temp = 0;

		for (int i = 3; i <= 490; i++) {
			fi[i] = fi[i - 1].add(fi[i - 2]);
		}

		while (true) {
			temp = Integer.parseInt(br.readLine());
			if (temp == -1) {
				break;
			}
			bw.write("Hour " + String.valueOf(temp) + ": " + String.valueOf(fi[temp]) + " cow(s) affected\n");
		}

		bw.flush();
		bw.close();
	}
}
