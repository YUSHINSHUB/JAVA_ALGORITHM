package Mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q6359_Drunken_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		int index[] = new int[t];

		for (int i = 0; i < t; i++) {
			index[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < t; i++) {
			boolean[] temp = new boolean[index[i] + 1];
			for (int z = 1; z <= index[i]; z++) {
				for (int x = z; x <= index[i]; x += z) {
					if (temp[x] == false) {
						temp[x] = true;
					} else {
						temp[x] = false;
					}
				}
			}
			int out = 0;
			for (int z = 1; z <= index[i]; z++) {
				if (temp[z] == true) {
					out++;
				}
			}
			bw.write(String.valueOf(out) + "\n");
		}

		bw.flush();
		bw.close();
	}
}
