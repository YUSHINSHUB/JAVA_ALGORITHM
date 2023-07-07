package Data_Structures;

import java.io.*;
import java.util.*;

public class Q14425_String_Array_S3 {

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
			// �Է¹��� ���ڿ��� key��, true�� value�� ���� ��Ұ� n���� hashmap�� �����ȴ�.
		}

		for (int i = 0; i < m; i++) {
			temp = br.readLine();
			if (strmap.containsKey(temp) == true)
				cnt++;
			// key������ ����Ͽ� �����ϴ��� ���θ� �˻��ϱ� ������ value���� ���� ����� ����.
		}

		bw.write(String.valueOf(cnt));

		bw.flush();
		bw.close();

	}
}