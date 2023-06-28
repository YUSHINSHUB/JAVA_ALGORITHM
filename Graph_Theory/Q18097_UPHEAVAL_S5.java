package Graph_Theory;

import java.io.*;

public class Q18097_UPHEAVAL_S5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		if (n == 2)
			bw.write("1");
		else
			bw.write(n + "");
		// n개의 노드를 n-1개의 엣지로 최대의 접근성을 유지하며 모두 연결하는 방법은 하나의 노드에 모든 노드를 연결하는
		// 것이다. 그러므로 경우의 수는 노드의 개수와 같다.

		bw.flush();
		bw.close();

	}
}
