package Regular_Expression;

import java.io.*;

public class Q9996_Missing_Korea_S3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String s[] = br.readLine().split("\\*");
		// Split()의 패러미터로 특수문자를 사용할 떄에는 \\을 붙여준다.
		String beg = s[0];
		String end = s[1];

		int bl = beg.length();
		int el = end.length();

		for (int i = 0; i < n; i++) {
			String in = br.readLine();
			if (in.length() < bl + el)
				bw.write("NE\n");
			else if (!in.substring(0, bl).equals(beg) || !in.substring(in.length() - el, in.length()).equals(end))
				bw.write("NE\n");
			else
				bw.write("DA\n");
		}

		bw.flush();
		bw.close();

	}
}