package Implementation;

import java.io.*;
import java.util.*;

public class Q2752_Sort_Three_B4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String numbers = br.readLine();

		StringTokenizer stk = new StringTokenizer(numbers, " ");

		int index = stk.countTokens();

		int[] num = new int[index];

		for (int i = 0; i < index; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}

		Arrays.sort(num);

		// bw.write(Arrays.toString(num));

		for (int i = 0; i < index; i++) {
			bw.write(String.valueOf(num[i]) + " ");
		}

		bw.flush();
		bw.close();

	}

}