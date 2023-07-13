package Dynamic_Programming;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q11051_Binomial_Coefficient_2_S2 {

	protected static int fac[] = new int[1001];

	protected static int getFac(int n) {

		if (fac[n] < 0) {
			if (fac[n - 1] < 0)
				fac[n] = (getFac(n - 1) * n) % 10007;
			else
				fac[n] = (fac[n - 1] * n) % 10007;
		}

		return fac[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int k = Integer.parseInt(inp[1]);
		Arrays.fill(fac, -1);
		fac[0] = 1;

		// �丣���� �������� ���� P�� �Ҽ���� ���� �Ͽ� (A/B) % P = ( (A%P) * (B^(P-2)%P) ) % P �� �����Ѵ�.
		// nCk % 10007 = ( n! / ( n-k )! * k! ) % 10007
		// = ( (n! % 10007) * ( ( n-k )! * k! )^10005 % 10007 ) ) % 10007�� ����.
		int fa = (getFac(n));
		int fb = (getFac(n - k) * getFac(k)) % 10007;

		int idx = 10005;
		int cur = 2;
		int kfac[] = new int[10006];
		Arrays.fill(kfac, -1);
		kfac[1] = fb % 10007;
		int div = 1;

		// ���� ������ �й��Ģ�� Ȱ���Ͽ� �ŵ������� �������� ������ ���� �� �ִ�.
		// https://ko.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/fast-modular-exponentiation
		// ����

		while (idx > 0) {

			if (cur > idx) {
				cur /= 2;
				idx -= cur;
				div = (div * kfac[cur]) % 10007;
				cur = 1;
			}

			if (kfac[cur] < 0)
				kfac[cur] = (kfac[cur / 2] * kfac[cur / 2]) % 10007;

			cur *= 2;
		}

		int res = (fa * div) % 10007;

		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}