package String;

/*
commented by ChatGPT
This Java code checks whether a given string follows a specific pattern or not. 
The input string can only contain sequences of "pi", "ka", or "chu". 
The program iterates over each character of the string, checking if it forms a valid sequence as per the given pattern. 
If any sequence does not match "pi", "ka", or "chu", or if the string ends prematurely, the program outputs "NO". 
If the entire string follows the pattern, it outputs "YES".
이 Java 코드는 주어진 문자열이 특정 패턴을 따르는지 확인합니다. 
입력 문자열에는 "pi", "ka", "chu"의 연속만 포함될 수 있습니다. 
프로그램은 문자열의 각 문자를 순회하면서 주어진 패턴에 따라 유효한 시퀀스를 형성하는지 확인합니다. 
어떤 시퀀스도 "pi", "ka", "chu"와 일치하지 않거나 문자열이 조기에 끝나면 프로그램은 "NO"를 출력합니다. 
전체 문자열이 패턴을 따르면 "YES"를 출력합니다.
*/

import java.io.*;

public class Q14405_PIKACHU_B1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in = br.readLine(); // 입력 문자열을 읽음
		String res = "YES"; // 결과를 "YES"로 초기화

		for (int i = 0; i < in.length(); i++) { // 문자열의 각 문자에 대해 반복

			// 마지막 문자일 경우 "NO"로 설정하고 반복문 종료
			if (i == in.length() - 1) {
				res = "NO";
				break;
			}

			// "pi" 시퀀스 검사
			if (in.charAt(i) == 'p') {
				if (in.charAt(i + 1) == 'i')
					i++; // "pi"가 맞으면 다음 문자로 넘어감
				else {
					res = "NO"; // "pi"가 아니면 "NO"로 설정하고 반복문 종료
					break;
				}
			}
			// "ka" 시퀀스 검사
			else if (in.charAt(i) == 'k') {
				if (in.charAt(i + 1) == 'a')
					i++; // "ka"가 맞으면 다음 문자로 넘어감
				else {
					res = "NO"; // "ka"가 아니면 "NO"로 설정하고 반복문 종료
					break;
				}
			}
			// "chu" 시퀀스 검사
			else if (in.charAt(i) == 'c') {
				if (i == in.length() - 2) {
					res = "NO"; // 문자열이 "ch"로 끝나면 "NO"로 설정하고 반복문 종료
					break;
				} else if (in.charAt(i + 1) == 'h' && in.charAt(i + 2) == 'u')
					i += 2; // "chu"가 맞으면 두 문자를 넘어감
				else {
					res = "NO"; // "chu"가 아니면 "NO"로 설정하고 반복문 종료
					break;
				}
			}
			// 위 세 경우 모두 해당하지 않으면 "NO"로 설정하고 반복문 종료
			else {
				res = "NO";
				break;
			}

		}

		bw.write(res); // 결과 출력
		bw.flush();
		bw.close();

	}
}