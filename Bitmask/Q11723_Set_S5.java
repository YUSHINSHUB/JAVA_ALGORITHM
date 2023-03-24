package Bitmask;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q11723_Set_S5 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int m = Integer.parseInt(br.readLine());
		int bit = 0; 
		String a[] = new String[2];
		int b;
		for (int i = 0; i < m; i++) {
			a = br.readLine().split(" ");
			if (a[0].equals("add")) {
				b = Integer.parseInt(a[1]);
				bit = bit | (1 << b-1); 
				// | 은 or연산으로, a | b 에서 a와 b의 각 자리 비트가 양쪽중 하나만 1이면 1을 반환한다.
				// <<은 왼쪽 시프트 연산이다. ex) 1 << 8 == 100000000
			}
			else if (a[0].equals("remove")) {
				b = Integer.parseInt(a[1]);
				if ((bit & (1 << (b - 1))) > 0) bit -= Math.pow(2, b - 1);
				// & 은 and연산으로, a & b 에서 a와 b의 각 자리 비트가 모두 1이면 1을 반환한다.
				// ex) 110에서 두번쨰 자리의 1을 뺴고 싶을 떄, 110 & (1 << (2-1) )을 할 경우 110 & 010이 되어
				// 결과는 010이 되어 두번째 자리에 비트가 존재했을 경우 10이, 존재하지 않았을 경우 0이 된다. 그러므로 0보다 클때만
				// 2의 b-1제곱을 뺴주면 해당 비트가 삭제된다.
			}
			else if (a[0].equals("check")) {
				b = Integer.parseInt(a[1]);
				if ((bit & (1 << (b - 1))) > 0) bw.write("1\n");
				else bw.write("0\n");
			}
			else if (a[0].equals("toggle")) {
				b = Integer.parseInt(a[1]);
				if ((bit & (1 << (b - 1))) > 0) bit -= Math.pow(2, b-1);
				else bit += Math.pow(2, b-1);
			}
			else if (a[0].equals("all")) {
				bit = 1048575;
				// 2진법 11111111111111111111 은 10진법 1048575이다.
			}
			else if (a[0].equals("empty")) {
				bit = 0;
			}
		}
		
		bw.flush();
		bw.close();

	}
}
