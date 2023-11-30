package Implementation;

import java.util.*;

public class Q1330_COMPARE_B5 {
	public static void main() {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();

		if (A > B) {
			System.out.println('>');
		}

		if (A < B) {
			System.out.println('<');
		}

		if (A == B) {
			System.out.println("==");
		}
	}
}
