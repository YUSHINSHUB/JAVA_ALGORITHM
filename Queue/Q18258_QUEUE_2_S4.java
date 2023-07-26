//이 프로그램은 사용자로부터 입력 받은 명령어에 따라 큐에 원소를 추가(push)하거나 제거(pop)하고, 큐의 크기(size), 
//비어 있는지 여부(empty), 첫 번째 원소(front), 마지막 원소(back)를 출력합니다.
package Queue;

import java.io.*;
import java.util.*;

public class Q18258_QUEUE_2_S4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 사용자로부터 입력을 받기 위한 BufferedReader 객체
																					// 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위한 BufferedWriter 객체 생성

		int n = Integer.parseInt(br.readLine()); // 첫 번째 입력으로 들어오는 숫자를 읽어옵니다. 이 숫자는 총 명령어의 개수입니다.
		Deque<Integer> q = new LinkedList<>(); // 이중 연결 리스트를 이용한 덱(Deque)를 생성합니다. 이 덱은 큐(queue)로 사용됩니다.

		for (int i = 0; i < n; i++) { // n번 동안 반복합니다.
			String in[] = br.readLine().split(" "); // 사용자로부터 입력을 받아 공백으로 나누어 배열에 저장합니다.

			// 사용자로부터 받은 명령어에 따라 작업을 수행합니다.
			if (in[0].equals("push")) // "push" 명령어가 입력된 경우
				q.addLast(Integer.parseInt(in[1])); // 큐에 숫자를 추가합니다.
			else if (in[0].equals("pop")) { // "pop" 명령어가 입력된 경우
				if (q.isEmpty()) // 큐가 비어있는지 확인합니다. 비어있다면
					bw.write("-1\n"); // "-1"을 출력합니다.
				else // 비어있지 않다면
					bw.write(q.pollFirst() + "\n"); // 큐의 첫 번째 원소를 가져와 출력하고, 큐에서 제거합니다.
			} else if (in[0].equals("size")) // "size" 명령어가 입력된 경우
				bw.write(q.size() + "\n"); // 큐의 크기를 출력합니다.
			else if (in[0].equals("empty")) { // "empty" 명령어가 입력된 경우
				if (q.isEmpty()) // 큐가 비어있는지 확인합니다. 비어있다면
					bw.write("1\n"); // "1"을 출력합니다.
				else // 비어있지 않다면
					bw.write("0\n"); // "0"을 출력합니다.
			} else if (in[0].equals("front")) { // "front" 명령어가 입력된 경우
				if (q.isEmpty()) // 큐가 비어있는지 확인합니다. 비어있다면
					bw.write("-1\n"); // "-1"을 출력합니다.
				else // 비어있지 않다면
					bw.write(q.getFirst() + "\n"); // 큐의 첫 번째 원소를 출력합니다.
			} else if (in[0].equals("back")) { // "back" 명령어가 입력된 경우
				if (q.isEmpty()) // 큐가 비어있는지 확인합니다. 비어있다면
					bw.write("-1\n"); // "-1"을 출력합니다.
				else // 비어있지 않다면
					bw.write(q.getLast() + "\n"); // 큐의 마지막 원소를 출력합니다.
			}
		}

		bw.flush(); // BufferedWriter에 쌓여있는 출력을 모두 출력합니다.
		bw.close(); // BufferedWriter를 닫습니다.

	}
}