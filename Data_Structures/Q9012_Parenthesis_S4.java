package Data_Structures;

import java.util.*;
import java.io.*;

class Q9012_Parenthesis_S4 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (; 0 < n; n--) {
			String str = br.readLine();

			Queue<String> q = new LinkedList<String>();
			boolean bl = true;

			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '(') {
					q.add("(");
				} else {
					if (q.isEmpty()) {
						bl = false;
						break;
					} else {
						q.poll();
					}
				}
			}
			if (!q.isEmpty()) {
				bl = false;
			}
			if (bl) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}

	}

}
