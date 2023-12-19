package Data_Structures;

/*
commented by ChatGPT
이 Java 코드는 주어진 시퀀스의 각 숫자가 몇 번째로 큰 숫자인지를 판별하고, 그 숫자가 다른 숫자에게 자신의 위치를 알릴 수 없을 경우 -1을 반환하는 문제를 해결합니다. 
스택을 사용하여 효율적으로 문제를 해결합니다.
This Java code solves the problem of determining which order each number in the given sequence is in terms of magnitude. 
If the number cannot notify its position to another number, it returns -1. The problem is efficiently solved using a stack.
*/

import java.io.*;
import java.util.*;

public class Q17298_Big_G4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String in[] = br.readLine().split(" ");
		int num[] = new int[n];

		Stack<Integer> stk = new Stack<Integer>(); // 숫자의 인덱스를 저장하기 위한 스택 (Stack for storing indices of numbers)

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(in[i]);
		}

		int cnt = 1;

		while (cnt <= n) {
			// 스택이 비어있으면 현재의 cnt를 스택에 넣는다. (If stack is empty, push the current 'cnt' into
			// the stack)
			if (stk.isEmpty()) {
				stk.push(cnt);
				cnt++;
			} else {
				// 스택의 최상단 숫자가 현재 숫자보다 작으면 스택에서 pop하여 해당 위치를 현재 숫자로 갱신 (If the top number in the
				// stack is smaller than the current number, pop it from the stack and update
				// its position with the current number)
				if (num[(int) stk.peek() - 1] < num[cnt - 1]) {
					num[(int) stk.pop() - 1] = num[cnt - 1];
				} else {
					stk.push(cnt);
					cnt++;
				}
			}
		}

		// 남아있는 스택의 원소들에 대해 -1을 할당 (Assign -1 for the remaining elements in the stack)
		while (!stk.isEmpty()) {
			num[(int) stk.pop() - 1] = -1;
		}

		for (int i = 0; i < n; i++) {
			bw.write(String.valueOf(num[i]) + " ");
		}

		bw.flush();
		bw.close();
	}
}
