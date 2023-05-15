package Implementation;

import java.io.*;

public class Q2562_Max_Value_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int max = 0;
		int cnt = 0;

		int num[] = new int[9];

		for (int i = 0; i < 9; i++) {
			num[i] = Integer.parseInt(br.readLine());
			if (num[i] > max) {
				max = num[i];
				cnt = i + 1;
			}
		}

		bw.write(String.valueOf(max) + '\n' + String.valueOf(cnt));
		// String.valueOf(int)는 int를 string 형태로 변환해준다.

		bw.flush();
		bw.close();
	}

}