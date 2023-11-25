package Greedy;

/*
commented by ChatGPT
This Java program calculates the minimum number of flowers required to ensure a flower is blooming every day from March 1st to November 30th. 
It reads the bloom start and end dates for each flower, converting them into day numbers of the year using switch-case statements. 
The program then employs a greedy algorithm to find the minimum set of flowers that covers the entire period. 
If there is any day within this period that cannot be covered by the flowers, it outputs 0.
이 Java 프로그램은 3월 1일부터 11월 30일까지 매일 최소 한 송이의 꽃이 피어 있도록 필요한 최소 꽃의 수를 계산합니다. 
각 꽃의 개화 시작 및 종료 날짜를 읽고 switch-case 문을 사용하여 연중 일자로 변환합니다. 
그런 다음, 프로그램은 전체 기간을 커버하는 최소한의 꽃을 찾기 위해 탐욕 알고리즘을 사용합니다. 
이 기간 중 하루라도 꽃으로 커버할 수 없는 경우 0을 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q2457_Princess_Garden_G3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // 꽃의 총 개수
		int[] day = new int[366]; // 각 일자별 꽃이 피는 기간을 저장하는 배열
		int res = 0; // 필요한 꽃의 최소 개수
		boolean quit = false; // 전체 기간을 커버할 수 있는지 여부
		Arrays.fill(day, 0); // 배열 초기화

		for (int i = 0; i < N; i++) {
			String[] inp = br.readLine().split(" ");
			int bm = Integer.parseInt(inp[0]); // 꽃이 피기 시작하는 월
			int bd = Integer.parseInt(inp[1]); // 꽃이 피기 시작하는 일
			int wm = Integer.parseInt(inp[2]); // 꽃이 지는 월
			int wd = Integer.parseInt(inp[3]); // 꽃이 지는 일
			int start = 0; // 개화 시작 일자
			int end = 0; // 개화 종료 일자

			// 개화 시작 월에 따른 시작 일자 계산
			switch (bm) {
			case 1:
				start = bd;
				break;
			case 2:
				start = 31 + bd;
				break;
			case 3:
				start = 59 + bd;
				break;
			case 4:
				start = 90 + bd;
				break;
			case 5:
				start = 120 + bd;
				break;
			case 6:
				start = 151 + bd;
				break;
			case 7:
				start = 181 + bd;
				break;
			case 8:
				start = 212 + bd;
				break;
			case 9:
				start = 243 + bd;
				break;
			case 10:
				start = 273 + bd;
				break;
			case 11:
				start = 304 + bd;
				break;
			case 12:
				start = 334 + bd;
				break;
			}

			// 개화 종료 월에 따른 종료 일자 계산
			switch (wm) {
			case 1:
				end = wd;
				break;
			case 2:
				end = 31 + wd;
				break;
			case 3:
				end = 59 + wd;
				break;
			case 4:
				end = 90 + wd;
				break;
			case 5:
				end = 120 + wd;
				break;
			case 6:
				end = 151 + wd;
				break;
			case 7:
				end = 181 + wd;
				break;
			case 8:
				end = 212 + wd;
				break;
			case 9:
				end = 243 + wd;
				break;
			case 10:
				end = 273 + wd;
				break;
			case 11:
				end = 304 + wd;
				break;
			case 12:
				end = 334 + wd;
				break;
			}

			day[start] = Math.max(day[start], end - start); // 시작 일자에 대한 최대 커버 기간 업데이트
		}

		int idx = 60; // 시작 일자 (3월 1일)
		while (idx <= 334) { // 종료 일자 (11월 30일)까지
			int hig = Integer.MIN_VALUE; // 현재 위치에서 가능한 최대 커버 기간
			for (int i = idx; i >= 1; i--) {
				hig = Math.max(hig, (i + day[i] - 1) - idx);
			}
			if (hig < 0) { // 커버 불가능한 기간 발견
				quit = true;
				break;
			}

			idx += hig + 1; // 다음 시작 위치로 이동
			res++; // 물주기 횟수 증가
		}

		if (quit)
			bw.write("0"); // 전체 기간 커버 불가
		else
			bw.write(res + ""); // 필요한 꽃의 최소 개수 출력

		bw.flush();
		bw.close();
	}
}
