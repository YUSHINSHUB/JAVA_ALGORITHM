package Data_Structures;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q13414_Course_Registration_S3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int k = Integer.parseInt(inp[0]);
		int l = Integer.parseInt(inp[1]);

		LinkedHashSet<String> lhs = new LinkedHashSet<String>(); // LinkedHashSet은 HashSet과 동일하게 중복을 허용하지 않으며
																	// 추가적으로 삽입 순서를 유지하는 특성을 가지고 있다.
		for (int i = 0; i < l; i++) {
			String temp = br.readLine();
			if (lhs.contains(temp))
				lhs.remove(temp);
			lhs.add(temp);
		}

		for (String temp : lhs) {
			bw.write(temp + "\n");
			k--;
			if (k == 0)
				break;
		}

		bw.flush();
		bw.close();
	}
}
