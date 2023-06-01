package Implementation;

import java.io.*;

public class Q13777_Hunt_the_Rabbit_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int in;
		int max, min, env;
		while (true) {
			in = Integer.parseInt(br.readLine());
			if (in == 0) {
				break;
			}

			max = 50;
			min = 1;
			env = 25;
			bw.write("25 ");

			while (env != in) {
				if (env > in) {
					max = env - 1;
				} else {
					min = env + 1;
				}
				env = (min + max) / 2;
				bw.write(String.valueOf(env) + " ");
			}

			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}