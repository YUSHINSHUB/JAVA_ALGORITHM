package Data_Structures;

/*
commented by ChatGPT
이 Java 코드는 문자열 s 내에서 bm 문자열을 모두 제거한 후의 결과를 출력하는 코드입니다.
This Java code outputs the result of string s after removing all occurrences of string bm.
*/

import java.io.*;
import java.util.*;

public class Q9935_String_Explosion_G4 {

	public static void main(String[] args) throws IOException {

		// BufferedReader와 BufferedWriter를 사용하여 입출력 스트림을 초기화합니다. (Initialize the input
		// and output stream using BufferedReader and BufferedWriter)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 사용자로부터 문자열 s와 bm을 입력받습니다. (Read strings s and bm from the user)
		String s = br.readLine();
		String bm = br.readLine();
		int idx = 0; // 변수 idx는 현재 처리 중인 문자의 위치를 나타냅니다. (Variable idx represents the position of the
						// character currently being processed)
		boolean pass = false; // bm 문자열의 존재를 확인하기 위한 플래그 (Flag to check the existence of string bm)

		Stack<Character> stk = new Stack<>();
		StringBuilder res = new StringBuilder("");

		// s의 각 문자에 대하여 (For each character in s)
		for (int i = 0; i < s.length(); i++) {
			stk.add(s.charAt(i));

			// 스택의 크기가 bm 문자열의 길이보다 크거나 같을 경우 bm 문자열의 존재를 확인합니다. (Check for the existence of
			// string bm if the stack size is greater than or equal to the length of bm)
			if (stk.size() >= bm.length()) {
				pass = false;
				// bm의 각 문자를 스택과 비교하여 bm 문자열이 스택의 상단에 있는지 확인합니다. (Check if the string bm is at
				// the top of the stack by comparing each character of bm with the stack)
				for (int j = 0; j < bm.length(); j++) {
					if (stk.get(stk.size() - bm.length() + j) != bm.charAt(j)) {
						pass = true;
						break;
					}
				}
				// 스택의 상단에 bm 문자열이 있으면 bm 문자열의 길이만큼 스택에서 문자를 제거합니다. (If the string bm is at the
				// top of the stack, pop characters from the stack equal to the length of bm)
				if (!pass) {
					for (int j = 0; j < bm.length(); j++)
						stk.pop();
				}
			}
		}

		// 스택이 비어있으면 "FRULA"를 출력하고, 그렇지 않으면 스택의 내용을 결과 문자열로 출력합니다. (If the stack is
		// empty, output "FRULA". Otherwise, output the contents of the stack as the
		// result string)
		if (stk.isEmpty())
			bw.write("FRULA");
		else {
			for (char c : stk) {
				res.append(c);
			}
			bw.write(res.toString());
		}

		// 출력 스트림을 비우고 닫습니다. (Flush and close the output stream)
		bw.flush();
		bw.close();
	}
}
