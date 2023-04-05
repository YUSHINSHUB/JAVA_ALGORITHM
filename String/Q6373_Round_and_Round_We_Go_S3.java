package String;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q6373_Round_and_Round_We_Go_S3 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String a, b;
		boolean chk;
		while ((a = br.readLine()) != null) {
			// 숫자 A에 자연수를 곱할 떄 cycle이 형성될 경우 A * (A의 길이 + 1) = A와 같은 자릿수를 가진 9로만 이루어진 수가 된다.
			// 예시 : 142,857 * 7 = 999,999 0588,235,294,117,647 * 17 = 9,999,999,999,999,999
			chk = true;
			BigInteger bi = new BigInteger(a);
			b = bi.multiply(new BigInteger((a.length() + 1) + "")).toString();

			for (int x = 0; x < a.length(); x++) {
				if (b.charAt(x) != '9') {
					bw.write(a + " is not cyclic\n");
					chk = false;
					break;
				}
			}

			if (chk == true)
				bw.write(a + " is cyclic\n");
		}

//		for( int x = 0 ; x < 5 ; x++ ) {
//			a = br.readLine();
//			BigInteger bi = new BigInteger(a);
//			int spos = -1;
//			b = bi.multiply(new BigInteger("2")).toString();
//				spos = -1;
//				if (a.length() != b.length()) {
//					bw.write(a + " is not cyclic\n");
//				} else {
//					for (int i = 0; i < a.length(); i++) {
//						if (a.substring(0, a.length() - i).equals(b.substring(i))) {
//							if (i != 0) {
//								if (a.substring(a.length() - i).equals(b.substring(0, i))) {
//									spos = 1;
//									break;
//								}
//							} else {
//								spos = 1;
//								break;
//							}
//						}
//					}
//
//					if (spos == 1) {
//							bw.write(a + " is cyclic\n");
//					} else
//						bw.write(a + " is not cyclic\n");
//			}

//			for (int i = 0; i < a.length(); i++) {
//				spos = -1;
//				if (a.charAt(0) == b.charAt(i)) {
//					for (int z = 0; z < a.length() - i; z++) {
//						if (a.charAt(z) != b.charAt(z + i)) {
//							spos = -2;
//							break;
//						}
//					}
//					if (spos == -1) {
//						int temp = a.length() - i;
//						for (int z = a.length() - i; z < a.length(); z++) {
//							if (a.charAt(z) != b.charAt(a.length() - i - temp)) {
//								spos = -2;
//								break;
//							}
//							temp--;
//						}
//						if (spos == -1) {
//							spos = 1;
//							break;
//						}
//					}
//				}
//			}
//			if (spos == 1)
//				bw.write(a + " is cyclic\n");
//			else
//				bw.write(a + " is not cyclic\n");
//		}

		bw.flush();
		bw.close();

	}
}
