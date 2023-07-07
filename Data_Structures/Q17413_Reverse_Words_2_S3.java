package Data_Structures;

import java.io.*;
import java.util.*;

public class Q17413_Reverse_Words_2_S3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp = br.readLine();
		Stack<Character> stk = new Stack<Character>();
		int temp = 0;
		boolean chk = true;

		for (int i = 0; i < inp.length(); i++) {
			while (inp.charAt(i) != '<' && inp.charAt(i) != ' ') {
				stk.add(inp.charAt(i));
				i++;
				if (i == inp.length()) {
					chk = false;
					break;
				}
			}

			while (!stk.isEmpty()) {
				bw.write(stk.pop() + "");
			}

			if (chk == false)
				break;

			if (inp.charAt(i) == ' ') {
				bw.write(" ");
			} else if (inp.charAt(i) == '<') {
				while (inp.charAt(i) != '>') {
					bw.write(inp.charAt(i) + "");
					i++;
				}
				bw.write(">");
			}

		}

		bw.flush();
		bw.close();
	}
}