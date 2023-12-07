package Implementation;

import java.io.*;

public class Q7568_Size_S5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int mem[][] = new int[n][3];
		String temp[] = new String[2];

		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			mem[i][0] = Integer.parseInt(temp[0]);
			mem[i][1] = Integer.parseInt(temp[1]);
			mem[i][2] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int z = 0; z < n; z++) {
				if (mem[i][0] < mem[z][0] && mem[i][1] < mem[z][1]) {
					mem[i][2]++;
				}
			}
		}

		for (int i = 0; i < n; i++)
			bw.write(mem[i][2] + " ");

		bw.flush();
		bw.close();
	}
}
