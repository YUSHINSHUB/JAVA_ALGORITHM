package Arithmetic;

/*
commented by ChatGPT
This Java code implements a simple discount system based on the number of items purchased and the original price. 
The program reads two integer values, N (the number of items purchased) and P (the original price), and calculates the discounted price based on given conditions. 
Different discount rules apply based on the quantity of items: discounts for purchases of 5 or more, 10 or more, 15 or more, and 20 or more items. 
The discount is calculated as a reduction in price or a percentage discount, whichever is less. 
The final discounted price is ensured to be non-negative.

이 Java 코드는 구매한 항목 수와 원래 가격에 따라 간단한 할인 시스템을 구현합니다. 
프로그램은 두 개의 정수 값인 N(구매한 항목 수)과 P(원래 가격)를 읽고 주어진 조건에 따라 할인된 가격을 계산합니다. 
항목 수에 따라 다른 할인 규칙이 적용됩니다: 5개 이상, 10개 이상, 15개 이상, 20개 이상 구매 시 할인이 적용됩니다. 
할인은 가격 감소 또는 백분율 할인 중 더 적은 금액으로 계산됩니다. 
최종 할인 가격은 음수가 되지 않도록 보장됩니다.
*/

import java.io.*;

public class Q25704_Event_B4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, P; // N: 구매한 항목 수, P: 원래 가격
		int res; // 결과 할인 가격

		N = Integer.parseInt(br.readLine()); // 구매한 항목 수 입력
		P = Integer.parseInt(br.readLine()); // 원래 가격 입력
		res = P; // 할인 전 가격으로 초기화

		// 할인 조건에 따라 할인된 가격 계산
		if (N >= 20) {
			res = Math.min(res, (P / 4) * 3); // 25% 할인
			res = Math.min(res, P - 2000); // 2000원 할인
			res = Math.min(res, (P / 10) * 9); // 10% 할인
		} else if (N >= 15) {
			res = Math.min(res, P - 2000); // 2000원 할인
			res = Math.min(res, (P / 10) * 9); // 10% 할인
		} else if (N >= 10) {
			res = Math.min(res, (P / 10) * 9); // 10% 할인
			res = Math.min(res, P - 500); // 500원 할인
		} else if (N >= 5) {
			res -= 500; // 500원 할인
		}

		if (res < 0) // 할인 가격이 음수가 되지 않도록 보장
			res = 0;

		bw.write(res + ""); // 결과 출력
		bw.flush();
		bw.close();

	}
}