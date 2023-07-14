package Stack;

import java.io.*;
import java.util.*;

public class Q5397_Key_Logger_S2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			Deque<Character> stk = new LinkedList<>();
			Deque<Character> buf = new LinkedList<>();

			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '<') {
					if (!stk.isEmpty())
						buf.push(stk.pop());

				} else if (s.charAt(j) == '>') {
					if (!buf.isEmpty())
						stk.push(buf.pop());

				} else if (s.charAt(j) == '-') {
					if (!stk.isEmpty())
						stk.pop();
				} else
					stk.push(s.charAt(j));
			}

			while (!buf.isEmpty())
				stk.push(buf.pop());
			while (!stk.isEmpty())
				bw.write(stk.pollLast() + "");
			bw.write("\n");
		}

		bw.flush();
		bw.close();

	}
}