package Implementation;

import java.io.*;

class Q2438_Star_1_B5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());

		for (int i = 1; i <= a; i++) {
			for (int x = 1; x <= i; x++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}