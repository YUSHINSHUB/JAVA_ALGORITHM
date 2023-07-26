//이진 탐색을 사용하여 최적의 케이블 길이를 찾습니다. 
//케이블의 길이가 중간값일 때 필요한 케이블의 수가 부족하다면 길이를 줄이고, 그렇지 않다면 길이를 늘립니다. 
//이 과정을 반복하여 최적의 케이블 길이를 찾아 출력합니다.
package Binary_Search;

import java.io.*;

public class Q1654_Cut_Lan_S2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 사용자로부터 입력을 받기 위한 BufferedReader 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 결과를 출력하기 위한 BufferedWriter 생성

		int k, n;
		long cnt, mid;
		long low = 0, hig = 0; // 이진 탐색을 위한 low, hig 초기화

		String in[] = br.readLine().split(" "); // 입력받은 두 수를 공백으로 나누어 배열에 저장
		k = Integer.parseInt(in[0]); // 케이블의 개수
		n = Integer.parseInt(in[1]); // 필요한 케이블의 개수

		int lans[] = new int[k]; // 케이블 길이를 저장할 배열

		for (int i = 0; i < k; i++) { // 케이블의 개수만큼 반복
			lans[i] = Integer.parseInt(br.readLine()); // 각 케이블의 길이를 배열에 저장
			if (hig < lans[i])
				hig = lans[i]; // 가장 긴 케이블 길이를 hig에 저장
		}
		hig++; // 최대 케이블 길이보다 하나 큰 값으로 초기화

		while (low < hig) { // 이진 탐색 시작
			cnt = 0; // 각 반복에서 얻을 수 있는 케이블의 수를 저장하는 변수
			mid = (low + hig) / 2; // 중간값을 구함
			for (int i = 0; i < k; i++) {
				cnt += lans[i] / mid; // 각 케이블에서 얻을 수 있는 케이블의 수를 더함
			}

			if (cnt < n) { // 필요한 케이블의 수보다 적다면, 케이블의 길이를 줄임
				hig = mid;
			} else { // 필요한 케이블의 수보다 많다면, 케이블의 길이를 늘림
				low = mid + 1;
			}
		}

		bw.write((low - 1) + ""); // 최적의 케이블 길이를 출력. low는 hig보다 1만큼 크므로 1을 빼준다.

		bw.flush(); // BufferedWriter의 버퍼를 비우고, 남아있는 데이터를 모두 출력
		bw.close(); // BufferedWriter를 닫음
	}
}