package Set_Map_By_Trees;

import java.io.*;
import java.util.*;

public class Q14425_String_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);
		int cnt = 0;

		String temp;

		HashMap<String, Boolean> strmap = new HashMap<String, Boolean>(n);

		for (int i = 0; i < n; i++) {
			temp = br.readLine();
			strmap.put(temp, true);
			// 입력받은 문자열을 key로, true를 value로 갖는 요소가 n개인 hashmap이 생성된다.
		}

		for (int i = 0; i < m; i++) {
			temp = br.readLine();
			if (strmap.containsKey(temp) == true)
				cnt++;
			// key값만을 사용하여 존재하는지 여부를 검색하기 때문에 value값은 뭐든 상관이 없다.
		}

		bw.write(String.valueOf(cnt));

		bw.flush();
		bw.close();

	}
}