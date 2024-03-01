package Binary_Search;

/*
commented by ChatGPT
This Java code calculates the length of the longest increasing subsequence (LIS) in a given sequence of integers and also reconstructs the LIS itself. 
It first reads the length of the sequence (N) and then the sequence itself. 
The algorithm employs dynamic programming to find the length of the LIS and uses an auxiliary array (`mem`) to track the elements' positions in the LIS. 
After finding the length, it reconstructs the LIS by tracing back through the `mem` array. 
The length of the LIS and the LIS itself are then outputted.

이 Java 코드는 주어진 정수 시퀀스에서 가장 긴 증가하는 부분 수열(LIS)의 길이를 계산하고 LIS 자체를 재구성합니다. 먼저 시퀀스의 길이(N)와 시퀀스 자체를 읽습니다. 
알고리즘은 동적 프로그래밍을 사용하여 LIS의 길이를 찾고 보조 배열(`mem`)을 사용하여 LIS에서 요소의 위치를 추적합니다. 길이를 찾은 후 `mem` 배열을 통해 추적하여 LIS를 재구성합니다. 
그런 다음 LIS의 길이와 LIS 자체를 출력합니다.
*/
import java.io.*;
import java.util.*;
import java.math.*;

public class Q14003_LIS_5_P5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];
		int N = Integer.parseInt(br.readLine()); // 시퀀스의 길이를 읽음
		int sequence[] = new int[1000001]; // 입력 시퀀스 저장 배열
		int mem[] = new int[1000001]; // 각 요소가 LIS의 어느 위치에 있는지 저장하는 배열
		int res[] = new int[1000001]; // LIS를 구성하는 데 사용되는 요소의 값을 저장하는 배열
		int idx = 1; // LIS의 길이 및 res 배열의 인덱스
		ArrayList<Integer> arr = new ArrayList<>(); // LIS를 역추적하여 저장하는 데 사용되는 ArrayList

		Arrays.fill(sequence, 0); // 시퀀스 배열 초기화
		inp = br.readLine().split(" ");

		// 시퀀스 배열 채우기
		for (int i = 0; i < N; i++)
			sequence[i] = Integer.parseInt(inp[i]);
		res[0] = sequence[0]; // 첫 번째 요소로 res 초기화

		// LIS 길이 계산 및 mem 배열 채우기
		for (int i = 1; i < N; i++) {
			if (sequence[i] > res[idx - 1]) {
				res[idx] = sequence[i];
				mem[i] = idx;
				idx++;
				continue;
			}
			int low = 0;
			int high = idx;
			int mid = high / 2;

			// 이진 검색을 사용하여 현재 요소가 들어갈 위치 찾기
			while (low < high) {
				if (res[mid] < sequence[i]) {
					low = mid + 1;
					mid = (low + high) / 2;
				} else {
					high = mid;
					mid = (low + high) / 2;
				}
			}
			res[low] = sequence[i];
			mem[i] = low;
		}

		// LIS의 길이 출력
		bw.write(idx + "\n");
		int cur = idx - 1; // LIS를 역추적하기 시작할 인덱스
		// LIS 역추적하여 arr에 추가
		for (int i = N - 1; i >= 0; i--) {
			if (mem[i] == cur) {
				arr.add(sequence[i]);
				cur--;
				if (cur < 0)
					break;
			}
		}

		// 역추적된 LIS 출력
		for (int i = idx - 1; i >= 0; i--)
			bw.write(arr.get(i) + " ");

		bw.flush();
		bw.close();
	}
}