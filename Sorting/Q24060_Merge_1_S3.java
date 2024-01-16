package Sorting;

import java.io.*;

public class Q24060_Merge_1_S3 {

	static int A[];
	static int tmp[];
	static int res = -1;
	static int k = 0;

	public static void merge_sort(int p, int r) { // A[p..r]을 오름차순 정렬한다.
		if (k == 0)
			return;
		if (p < r) {
			int q = (p + r) / 2; // q는 p, r의 중간 지점
			merge_sort(p, q); // 전반부 정렬
			merge_sort(q + 1, r); // 후반부 정렬
			merge(p, q, r); // 병합
		}
	}

	// A[p..q]와 A[q+1..r]을 병합하여 A[p..r]을 오름차순 정렬된 상태로 만든다.
	// A[p..q]와 A[q+1..r]은 이미 오름차순으로 정렬되어 있다.
	public static void merge(int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 1;

		while (i <= q && j <= r) {
			if (A[i] <= A[j])
				tmp[t++] = A[i++]; // tmp[t] <- A[i]; t++; i++;
			else
				tmp[t++] = A[j++]; // tmp[t] <- A[j]; t++; j++;
		}
		while (i <= q) // 왼쪽 배열 부분이 남은 경우
			tmp[t++] = A[i++];
		while (j <= r) // 오른쪽 배열 부분이 남은 경우
			tmp[t++] = A[j++];

		i = p;
		t = 1;

		while (i <= r) {// 결과를 A[p..r]에 저장
			k--;
			A[i++] = tmp[t++];
			if (k == 0) {
				res = A[i - 1];
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n;
		String inp[] = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		k = Integer.parseInt(inp[1]);
		A = new int[n + 1];
		tmp = new int[n + 1];

		inp = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(inp[i]);
		}

		merge_sort(0, n - 1);

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}