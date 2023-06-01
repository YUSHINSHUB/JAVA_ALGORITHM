package Implementation;

import java.io.*;

public class Q16431_Cow_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str1 = br.readLine().split(" ");
		String[] str2 = br.readLine().split(" ");
		String[] str3 = br.readLine().split(" ");

		int[] bessie = new int[2];
		int[] daisy = new int[2];
		int[] john = new int[2];

		int bindex = 0;
		int dindex = 0;
		String out;

		bessie[0] = Integer.parseInt(str1[0]);
		bessie[1] = Integer.parseInt(str1[1]);
		daisy[0] = Integer.parseInt(str2[0]);
		daisy[1] = Integer.parseInt(str2[1]);
		john[0] = Integer.parseInt(str3[0]);
		john[1] = Integer.parseInt(str3[1]);

		while (bessie[0] != john[0] || bessie[1] != john[1]) {
			if (bessie[0] > john[0]) {
				bessie[0]--;
			} else if (bessie[0] < john[0]) {
				bessie[0]++;
			}

			if (bessie[1] > john[1]) {
				bessie[1]--;
			} else if (bessie[1] < john[1]) {
				bessie[1]++;
			}

			bindex++;

		}

		while (daisy[0] != john[0] || daisy[1] != john[1]) {
			if (daisy[0] > john[0]) {
				daisy[0]--;
				dindex++;
				continue;
			} else if (daisy[0] < john[0]) {
				daisy[0]++;
				dindex++;
				continue;
			}

			if (daisy[1] > john[1]) {
				daisy[1]--;
				dindex++;
				continue;
			} else if (daisy[1] < john[1]) {
				daisy[1]++;
				dindex++;
				continue;
			}

		}

		if (bindex > dindex) {
			out = "daisy";
		} else if (bindex < dindex) {
			out = "bessie";
		} else {
			out = "tie";
		}

		bw.write(out);

		bw.flush();
		bw.close();

	}

}
