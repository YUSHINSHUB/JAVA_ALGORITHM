package Implementation;

/*
commented by ChatGPT
This Java code calculates the minimum number of sets required to represent a given room number, considering that each set contains digits from 0 to 9. 
It treats the digits '6' and '9' as interchangeable. 
The program iterates over the input room number string and counts the occurrence of each digit, doubling it for all digits except '6' and '9'. 
For '6' and '9', it increments the same count. 
The maximum count among all digits, after considering the interchangeability of '6' and '9', determines the minimum sets required. 
If the count is odd, one extra set is needed for the remaining digit.
이 Java 코드는 각 세트에 0부터 9까지의 숫자가 포함된다고 가정할 때 주어진 방 번호를 나타내는 데 필요한 최소 세트 수를 계산합니다. 
'6'과 '9' 숫자는 서로 바꿔 사용할 수 있다고 처리합니다. 
프로그램은 입력된 방 번호 문자열을 순회하며 각 숫자의 발생 횟수를 계산하고, '6'과 '9'를 제외한 모든 숫자에 대해서는 그 수를 두 배로 셉니다. 
'6'과 '9'의 경우 같은 카운트를 증가시킵니다. '6'과 '9'의 상호 교환 가능성을 고려한 모든 숫자 중 가장 많은 카운트가 최소 세트 수를 결정합니다. 
카운트가 홀수인 경우 남은 숫자에 대해 추가 세트가 필요합니다.
*/

import java.io.*;
import java.math.*;
import java.util.Arrays;

public class Q1475_Room_Number_S5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in; // 입력받을 방 번호 문자열
		int cnt[] = new int[9]; // 각 숫자의 카운트를 저장할 배열
		int hig = 0; // 필요한 세트의 최대 수

		in = br.readLine(); // 방 번호 입력 받음
		Arrays.fill(cnt, 0); // 카운트 배열 초기화

		for (int i = 0; i < in.length(); i++) { // 방 번호의 각 숫자에 대해 반복
			if (in.charAt(i) == '6' || in.charAt(i) == '9') { // '6' 또는 '9'인 경우
				cnt[6]++; // '6'의 카운트를 증가시킴 (6과 9는 서로 교환 가능)
				hig = Math.max(hig, cnt[6]); // 필요한 세트의 최대 수 갱신
			} else { // 그 외 숫자인 경우
				cnt[in.charAt(i) - '0'] += 2; // 해당 숫자의 카운트를 2 증가시킴
				hig = Math.max(hig, cnt[in.charAt(i) - '0']); // 필요한 세트의 최대 수 갱신
			}
		}

		// 최대 카운트가 홀수인 경우 하나의 세트를 추가로 필요로 함
		if (hig % 2 == 1)
			hig = hig / 2 + 1;
		else
			hig /= 2; // 짝수인 경우 그대로 반으로 나눔

		bw.write(hig + ""); // 결과 출력
		bw.flush();
		bw.close();

	}
}