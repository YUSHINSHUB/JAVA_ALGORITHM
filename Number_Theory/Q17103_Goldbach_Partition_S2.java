package Number_Theory;

import java.io.*;

public class Q17103_Goldbach_Partition_S2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 소수인지 아닌지를 판별할 배열, n[i]가 true이면 i는 소수가 아니고 false이면 소수
		boolean n[] = new boolean[1000001];

		// 0과 1은 소수가 아니므로 true로 설정
		n[0] = true;
		n[1] = true;

		// 에라토스테네스의 체를 이용하여 소수를 구함
		for (int i = 2; i < 1000001; i++) {
			if (n[i] == false) {
				for (int z = i * 2; z < 1000001; z += i) {
					n[z] = true;
				}
			}
		}

		// 테스트 케이스의 수를 입력받음
		int t = Integer.parseInt(br.readLine());

		// 각 테스트 케이스에 해당하는 수를 저장할 배열과 각 수를 두 소수의 합으로 나타낼 수 있는 경우의 수를 저장할 배열
		int num[] = new int[t];
		int gold[] = new int[t];

		for (int i = 0; i < t; i++) {
			// 각 테스트 케이스에 해당하는 수를 입력받음
			num[i] = Integer.parseInt(br.readLine());

			// 초기에 각 수를 두 소수의 합으로 나타낼 수 있는 경우의 수는 0으로 설정
			gold[i] = 0;

			// 각 수를 두 소수의 합으로 나타낼 수 있는 경우의 수를 구함
			for (int z = 2; z <= num[i] / 2; z++) {
				if (n[z] == false && n[num[i] - z] == false) {
					gold[i]++;
				}
			}

			// 각 수를 두 소수의 합으로 나타낼 수 있는 경우의 수를 출력
			bw.write(String.valueOf(gold[i]) + "\n");
		}

		bw.flush();
		bw.close();
	}
}