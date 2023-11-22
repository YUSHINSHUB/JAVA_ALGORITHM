package Greedy;

/*
commented by ChatGPT
This Java program is designed to create the largest possible number by removing K digits from a given number. 
It reads a number as a string and uses a stack to keep track of the digits. 
The algorithm iteratively compares the top of the stack with the next digit in the string. 
If a smaller digit is found on the stack, it is removed to form a larger number. 
The process continues until K digits are removed or the end of the string is reached. 
The final number is constructed from the remaining digits in the stack.
이 Java 프로그램은 주어진 숫자에서 K개의 숫자를 제거하여 가능한 가장 큰 숫자를 만드는 것을 목표로 합니다. 
숫자를 문자열로 읽고 스택을 사용하여 숫자를 추적합니다. 
알고리즘은 스택의 맨 위와 문자열의 다음 숫자를 반복적으로 비교합니다. 
스택에 더 작은 숫자가 발견되면, 더 큰 숫자를 형성하기 위해 제거됩니다. 
이 과정은 K개의 숫자가 제거되거나 문자열의 끝에 도달할 때까지 계속됩니다. 
최종 숫자는 스택에 남아 있는 숫자로 구성됩니다.
*/

import java.io.*;
import java.util.*;

public class Q2812_BIGGER_G3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder(""); // 최종 숫자를 구성하기 위한 StringBuilder
		String inp[] = br.readLine().split(" ");
		int N = Integer.parseInt(inp[0]); // 숫자의 길이
		int K = Integer.parseInt(inp[1]); // 제거해야 할 숫자의 개수

		String num = br.readLine(); // 주어진 숫자
		Stack<Character> stk = new Stack<>(); // 숫자를 저장하기 위한 스택

		for (int i = 0; i < N - 1; i++) {
			stk.add(num.charAt(i)); // 현재 숫자를 스택에 추가
			// 스택의 맨 위 숫자가 다음 숫자보다 작으면 제거
			while (!stk.isEmpty() && K > 0) {
				if (stk.peek() < num.charAt(i + 1)) {
					stk.pop();
					K--;
				} else
					break;
			}
		}
		stk.add(num.charAt(N - 1)); // 마지막 숫자 추가

		// 남은 K만큼 스택에서 숫자 제거
		while (K != 0) {
			stk.pop();
			K--;
		}

		// 스택에 남은 숫자를 StringBuilder에 추가
		while (!stk.isEmpty()) {
			sb.append(stk.pop());
		}

		bw.write(sb.reverse().toString()); // 역순으로 된 숫자를 정상 순서로 변경하여 출력

		bw.flush();
		bw.close();
	}
}
