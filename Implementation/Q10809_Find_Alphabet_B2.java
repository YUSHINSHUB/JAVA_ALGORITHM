package Implementation;

import java.io.*;

public class Q10809_Find_Alphabet_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in = br.readLine();
		int res[] = new int[27];
		for (int i = 1; i <= 26; i++) {
			res[i] = -1;
		}

		for (int i = 0; i < 26; i++) {
			if (in.contains(Character.toString('a' + i))) {
				for (int z = 0; z < in.length(); z++) {
					if (in.charAt(z) == 'a' + i) {
						res[i + 1] = z;
						break;
					}
				}
			}
		}

		for (int i = 1; i <= 26; i++) {
			bw.write(String.valueOf(res[i]) + " ");
		}

		bw.flush();
		bw.close();

	}
}