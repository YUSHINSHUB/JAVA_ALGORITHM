package Bitmask;

import java.io.*;
import java.util.*;


public class Q12833_XORXORXOR_B5 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a, b, c;
		String inp[] = br.readLine().split(" ");
		
		a = Integer.parseInt(inp[0]);
		b = Integer.parseInt(inp[1]);
		c = Integer.parseInt(inp[2]);
		
		int res = 0;
		
		if( c % 2 == 1 ) {
		// A^B일 떄 B의 비트가 1일 경우 A의 대응하는 비트가 반전된다. 그러므로 이를 n번 수행했을 때 n이 짝수일 경우 A는 원래대로 돌아온다.
		// 이를 이용해 n이 홀수일때만 XOR연산을 딱 한번 수행하면 ((A^B)^B)...^B를 n번 수행했을 때의 값을 더욱 효율적으로 얻을 수 있다.
		
		res = a ^ b;
		//비트연산에는 AND (&), OR (|), XOR (^), NOT (~), SHIFT (>>, <<)가 있다.
		//AND: 대응하는 두 비트가 모두 1일 때 1을 반환. 1010 & 1111 = 1010
		//OR: 대응하는 두 비트가 모두 1 혹은 하나만 1일 때 1을 반환. 1010 | 1111 = 1111
		//XOR: 대응하는 두 비트가 서로 다르면 1을 반환 1010 | 1111 = 0101
		//NOT: 비트의 값을 반전하여 반환 ~1010 = 0101
		//SHIFT: 왼쪽 또는 오른쪽으로 비트를 옮긴다 00001010 << 2 = 101000   00001010 >> 2 = 000010 
		//왼쪽 시프트는 A * 2^B 를 의미하고, 오른쪽 시프트는 A / 2^B 를 의미한다.
		
		}else {
			res = a;
		}
		
		bw.write(String.valueOf(res));
		
		bw.flush();
		bw.close();
}
}
