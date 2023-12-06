package Implementation;

/*
commented by ChatGPT
This Java program reads an array of switches and a series of operations to toggle them. 
It supports two types of operations: toggling every k-th switch and toggling a symmetrical range of switches centered at a given index. 
The final state of the switches is printed, with a line break after every 20 switches.
이 Java 프로그램은 스위치 배열과 그것들을 토글하는 일련의 연산을 읽습니다. 
두 가지 유형의 연산을 지원합니다: k번째 스위치를 토글하는 것과 주어진 인덱스를 중심으로 대칭 범위의 스위치를 토글하는 것. 
최종 스위치 상태는 매 20개 스위치마다 줄 바꿈과 함께 출력됩니다.
*/

import java.io.*;

public class Q1244_Turn_On_and_Off_S4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, T; // N: Number of switches, T: Number of operations (N: 스위치 수, T: 연산 수)
		int sch[]; // Array to store the state of switches (스위치 상태를 저장할 배열)

		N = Integer.parseInt(br.readLine()); // Read number of switches (스위치 수 읽기)
		sch = new int[N + 1]; // Initialize switch array with N+1 (N+1 크기의 스위치 배열 초기화)
		String inp[] = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			sch[i + 1] = Integer.parseInt(inp[i]); // Read initial state of switches (스위치의 초기 상태 읽기)
		}
		T = Integer.parseInt(br.readLine()); // Read number of operations (연산 수 읽기)

		// Processing each operation
		for (int i = 0; i < T; i++) {
			inp = br.readLine().split(" ");
			int num = Integer.parseInt(inp[1]);
			if (Integer.parseInt(inp[0]) == 1) { // Operation type 1: Toggle every k-th switch (연산 유형 1: k번째 스위치 토글)
				for (int j = num; j <= N; j += num) {
					sch[j] = sch[j] == 1 ? 0 : 1; // Toggle the switch (스위치 토글)
				}
			} else { // Operation type 2: Toggle a symmetrical range of switches (연산 유형 2: 대칭 범위의 스위치
						// 토글)
				int low = num;
				int hig = num;
				// Expand the symmetrical range (대칭 범위 확장)
				while (low > 1 && hig < N && sch[low - 1] == sch[hig + 1]) {
					low--;
					hig++;
				}
				// Toggle switches in the range (범위 내의 스위치 토글)
				for (int j = low; j <= hig; j++) {
					sch[j] = sch[j] == 1 ? 0 : 1;
				}
			}
		}

		// Output the final state of switches (스위치의 최종 상태 출력)
		for (int i = 1; i <= N; i++) {
			bw.write(sch[i] + " ");
			if (i % 20 == 0) // Line break after every 20 switches (20개 스위치마다 줄 바꿈)
				bw.write("\n");
		}

		bw.flush(); // Flush the buffer (버퍼 플러시)
		bw.close(); // Close the writer (쓰기 닫기)

	}

}
