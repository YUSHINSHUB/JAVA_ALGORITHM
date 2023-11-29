package String;

/*
commented by ChatGPT
This Java code reads an input string and calculates the sum of all the numbers present in the string. 
It iterates through each character, checking if it's a digit. If so, it appends the character to a StringBuilder. 
When a non-digit character is encountered, it converts the collected digits into a number and adds it to the sum. 
Finally, the code outputs the total sum of all numbers found in the string.
이 Java 코드는 입력 문자열을 읽고 문자열에 있는 모든 숫자의 합을 계산합니다. 각 문자를 순회하면서 숫자인지 확인합니다. 
숫자라면 StringBuilder에 문자를 추가합니다. 숫자가 아닌 문자를 만나면 모아둔 숫자들을 숫자로 변환하여 합계에 더합니다. 
마지막으로 코드는 문자열에서 찾은 모든 숫자의 총 합을 출력합니다.
*/

import java.io.*;

public class Q8595_Hidden_Number_B1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine()); // 입력 문자열의 길이를 읽음
		String s = br.readLine(); // 입력 문자열을 읽음
		StringBuilder sb = new StringBuilder(""); // 숫자를 저장할 StringBuilder 객체 생성
		long res = 0; // 숫자의 합을 저장할 변수

		for (int i = 0; i < n; i++) { // 문자열의 각 문자에 대해 반복
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') { // 현재 문자가 숫자라면
				sb.append(s.charAt(i)); // StringBuilder에 추가
			} else if (!sb.toString().equals("")) { // 숫자가 아니고, StringBuilder에 숫자가 저장되어 있으면
				res += Integer.parseInt(sb.toString()); // 숫자로 변환하여 res에 더함
				sb = new StringBuilder(""); // StringBuilder 초기화
			}
		}

		// 마지막 숫자 처리
		if (!sb.toString().equals("")) {
			res += Integer.parseInt(sb.toString()); // 마지막으로 저장된 숫자를 합계에 더함
		}

		bw.write(res + ""); // 결과 출력
		bw.flush();
		bw.close();
	}
}