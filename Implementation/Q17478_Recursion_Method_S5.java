package Implementation;

/*
commented by ChatGPT
This Java code implements a recursive function to generate a story-like dialogue about recursion. 
The program takes an integer input N and prints out a conversation between a student and a wise sage, where the student repeatedly asks what a recursive function is. 
The dialogue is formatted with increasing indentations represented by underscores, simulating the depth of recursion. 
Each recursion level adds more to the story until it reaches the base case (N), where a direct answer about recursion is given. 
After reaching the base case, the program unwinds the recursion stack, appending closing statements to the dialogue with decreasing indentation.

이 Java 코드는 재귀에 대한 이야기 같은 대화를 생성하기 위해 재귀 함수를 구현합니다. 
프로그램은 정수 N을 입력받아 학생과 현명한 선인 사이의 대화를 출력합니다. 
여기서 학생은 반복적으로 재귀함수가 무엇인지 묻습니다. 
대화는 재귀의 깊이를 나타내는 밑줄을 사용하여 들여쓰기로 형식화됩니다. 
각 재귀 레벨은 기본 케이스(N)에 도달할 때까지 이야기에 더 많은 내용을 추가합니다. 
기본 케이스에서 재귀에 대한 직접적인 대답이 주어진 후, 프로그램은 재귀 스택을 되감으며 대화에 감소하는 들여쓰기로 답변을 추가합니다.
*/

import java.io.*;

public class Q17478_Recursion_Method_S5 {

	static StringBuilder sb = new StringBuilder("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n"); // 대화 시작 문구
	static int N; // 재귀 깊이를 나타내는 변수

	static void recur(int idx) { // 재귀 함수

		if (idx == N) { // 기본 케이스: 재귀의 깊이가 N에 도달한 경우
			for (int i = 0; i < idx; i++) { // 현재 깊이에 맞는 들여쓰기를 추가
				for (int j = 0; j < 4; j++) {
					sb.append("_");
				}
			}
			// 재귀함수의 정의에 대한 직접적인 대답
			sb.append("\"재귀함수가 뭔가요?\"\n");
			for (int i = 0; i < idx; i++) {
				for (int j = 0; j < 4; j++) {
					sb.append("_");
				}
			}
			sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
		} else { // 재귀 케이스: 대화를 계속 이어가는 부분

			for (int i = 0; i < idx; i++) { // 들여쓰기 추가
				for (int j = 0; j < 4; j++) {
					sb.append("_");
				}
			}
			// 대화 내용 추가
			sb.append("\"재귀함수가 뭔가요?\"\n");
			for (int i = 0; i < idx; i++) {
				for (int j = 0; j < 4; j++) {
					sb.append("_");
				}
			}
			sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
			for (int i = 0; i < idx; i++) {
				for (int j = 0; j < 4; j++) {
					sb.append("_");
				}
			}
			sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
			for (int i = 0; i < idx; i++) {
				for (int j = 0; j < 4; j++) {
					sb.append("_");
				}
			}
			sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

			recur(idx + 1); // 재귀 호출

		}

		for (int i = 0; i < idx; i++) { // 대화 닫는 부분 추가
			for (int j = 0; j < 4; j++) {
				sb.append("_");
			}
		}
		sb.append("라고 답변하였지.\n");

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); // 재귀 깊이 입력 받음

		recur(0); // 재귀 함수 호출

		bw.write(sb.toString()); // 결과 출력
		bw.flush();
		bw.close();

	}
}