package Mathematics;

import java.io.*;
import java.util.*;

public class Q2480_Dice_B4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String dices = br.readLine();
		StringTokenizer stk = new StringTokenizer(dices, " ");

		int prize;
		int max = 0;

		int dice[] = new int[3];

		for (int i = 0; i < 3; i++) {
			dice[i] = Integer.parseInt(stk.nextToken());
			max = Math.max(max, dice[i]);
		}

		if (dice[0] == dice[1] && dice[0] == dice[2]) {
			prize = 10000 + (dice[0] * 1000);
		} else if (dice[0] == dice[1] || dice[0] == dice[2]) {
			prize = 1000 + (dice[0] * 100);
		} else if (dice[1] == dice[2]) {
			prize = 1000 + (dice[1] * 100);
		} else {
			prize = 100 * max;
		}

		bw.write(String.valueOf(prize));

		bw.flush();
		bw.close();

	}

}
