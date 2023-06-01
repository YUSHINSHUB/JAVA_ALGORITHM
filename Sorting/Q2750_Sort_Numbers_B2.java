package Implementation;

import java.util.Scanner;
import java.util.ArrayList;

public class Q2750_Sort_Numbers_B2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		ArrayList<Integer> a = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {

			int temp = sc.nextInt();

			a.add(temp);

		}

		java.util.Collections.sort(a);

		for (int x : a) {
			System.out.println(x);
		}
	}
}
