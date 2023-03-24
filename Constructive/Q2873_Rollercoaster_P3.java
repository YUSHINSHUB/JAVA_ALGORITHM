package Constructive;

import java.io.*;
import java.math.*;
import java.util.*;
// append 뒤에 string 배열로 선언해서 넣기

public class Q2873_Rollercoaster_P3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String nums[] = br.readLine().split(" ");
		int r = Integer.parseInt(nums[0]); // 세로번호 (가로줄의 개수)
		int c = Integer.parseInt(nums[1]); // 가로번호 (세로줄의 개수)
		String temp[] = new String[c];
		StringBuffer b1 = new StringBuffer();
		// 건너뛸 칸이 포함된 y좌표 전까지의 경로
		StringBuffer b2 = new StringBuffer();
		// 건너뛸 칸의 y좌표 이후의 경로 도착점부터 입력되기 때문에 역순출력)
		
		//JAVA에서 String은 Immutable(불변)의 성질을 가지고 있어 더하기 연산자를 사용할 경우
		// 원래 string에 더하는게 아니라 두 string이 합쳐진 새로운 string을 생성한다.
		//그러므로 쓸데없는 메모리가 늘어나게 된다. 그러므로 StringBuffer 혹은 StringBuilder의 append 메소드를 활용한다.

		int line[][] = new int[r][c];

		for (int i = 0; i < r; i++) {
			temp = br.readLine().split(" ");
			for (int z = 0; z < c; z++) {
				line[i][z] = Integer.parseInt(temp[z]);
			}
		}

		// 가로줄 혹은 세로줄의 개수가 홀수일 경우 모든칸을 다 지날 수 있다.
		if (r % 2 == 1) {

			for (int i = 0; i < r; i++) {
				for (int z = 0; z < c - 1; z++) {
					b1.append("R");
				}
				i++;
				if (i >= r)
					break;
				else {
					b1.append("D");
				}
				for (int z = 0; z < c - 1; z++) {
					b1.append("L");
				}
				b1.append("D");
			}

		} else if (c % 2 == 1) {

			for (int i = 0; i < c; i++) {
				for (int z = 0; z < r - 1; z++) {
					b1.append("D");
				}
				i++;
				if (i == c)
					break;
				else {
					b1.append("R");
				}
				for (int z = 0; z < r - 1; z++) {
					b1.append("U");
				}
				b1.append("R");
			}

			// 가로줄, 세로줄 개수가 모두 짝수일 경우
		} else {
			int mi = 1001;
			int xpos = 0;
			int ypos = 0;
			int ra = 0;
			int rb = r - 1;
			int ct = 0;

			// 세로줄을 두줄단위로 나누어서 건너뛸 칸의 이전(b1), 이후(b2)로 나누어 입력한다.
			for (int i = 0; i < r; i += 2) {
				for (int z = 1; z < c; z += 2) {
					mi = Math.min(mi, line[i][z]);
					if (line[i][z] == Math.min(mi, line[i][z])) {
						ypos = i;
						xpos = z;
					}
				}
			}

			for (int i = 1; i < r; i += 2) {
				for (int z = 0; z < c; z += 2) {
					mi = Math.min(mi, line[i][z]);
					if (line[i][z] == Math.min(mi, line[i][z])) {
						ypos = i;
						xpos = z;
					}
				}
			}

			// 칸의 배치가 흑 백 일 경우 건너뛸 칸은 무조건 백색칸 중에 있기 때문에 위와 같은 방식으로 건너뛸 지점을 결정한다.
			//		      백 흑

			while (ra / 2 < ypos / 2 || rb / 2 > ypos / 2) {
				if (ra / 2 < ypos / 2) {
					for (int i = 0; i < c - 1; i++)
						b1.append("R");
					b1.append("D");
					for (int i = 0; i < c - 1; i++)
						b1.append("L");
					b1.append("D");
					ra += 2;
				}

				if (rb / 2 > ypos / 2) {
					for (int i = 0; i < c - 1; i++)
						b2.append("R");
					b2.append("D");
					for (int i = 0; i < c - 1; i++)
						b2.append("L");
					b2.append("D");
					rb -= 2;
				}
			}

			while (ct / 2 < xpos / 2) {
				b1.append("DRUR");
				ct += 2;
			}

			// 1 2 인 경우에 3을 건너뛰는 경우
			// 3 4
			if (xpos % 2 == 0) {
				b1.append("RD");
			} else { // 1 2 인 경우에 2를 건너뛰는 경우
					 // 3 4
				b1.append("DR");
			}
			ct += 1;

			while (ct < c - 1) {
				b1.append("RURD");
				ct += 2;
			}

		}

		bw.write(b1.toString());
		bw.write(b2.reverse().toString());

		bw.flush();
		bw.close();

	}
}
