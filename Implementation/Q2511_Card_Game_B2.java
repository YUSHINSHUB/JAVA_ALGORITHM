package Implementation;

import java.io.*;

public class Q2511_Card_Game_B2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a[] = new int[10];
		int b[] = new int[10];

		int scra = 0, scrb = 0;
		int chk = 0;

		String inp[] = br.readLine().split(" ");
		for (int i = 0; i < 10; i++) {
			a[i] = Integer.parseInt(inp[i]);
		}

		inp = br.readLine().split(" ");
		for (int i = 0; i < 10; i++) {
			b[i] = Integer.parseInt(inp[i]);
			if (b[i] < a[i]) {
				scra += 3;
				chk = 1;
			} else if (b[i] > a[i]) {
				scrb += 3;
				chk = 2;
			} else {
				scra++;
				scrb++;
			}
		}

		bw.write(scra + " " + scrb + "\n");
		if (scra > scrb) {
			bw.write("A");
		} else if (scra < scrb) {
			bw.write("B");
		} else {
			switch (chk) {
			case 1:
				bw.write("A");
				break;
			case 2:
				bw.write("B");
				break;
			case 0:
				bw.write("D");
				break;
			}
		}

		bw.flush();
		bw.close();

	}
}
