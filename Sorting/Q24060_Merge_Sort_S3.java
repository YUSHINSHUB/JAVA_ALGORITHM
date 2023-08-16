package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q24060_Merge_Sort_S3 {

	static int A[];
	static int tmp[];
	static int res = -1;
	static int k = 0;

	public static void merge_sort(int p, int r) { // A[p..r]�� �������� �����Ѵ�.
		if (k == 0)
			return;
		if (p < r) {
			int q = (p + r) / 2; // q�� p, r�� �߰� ����
			merge_sort(p, q); // ���ݺ� ����
			merge_sort(q + 1, r); // �Ĺݺ� ����
			merge(p, q, r); // ����
		}
	}

	// A[p..q]�� A[q+1..r]�� �����Ͽ� A[p..r]�� �������� ���ĵ� ���·� �����.
	// A[p..q]�� A[q+1..r]�� �̹� ������������ ���ĵǾ� �ִ�.
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
		while (i <= q) // ���� �迭 �κ��� ���� ���
			tmp[t++] = A[i++];
		while (j <= r) // ������ �迭 �κ��� ���� ���
			tmp[t++] = A[j++];

		i = p;
		t = 1;

		while (i <= r) {// ����� A[p..r]�� ����
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