package Geometry;

/*
commented by ChatGPT
This Java code calculates the maximum number of buildings that can be seen from any building. 
Each building's height is given. 
A building blocks the view of another building if its slope with respect to the current building is greater than the previous buildings.
이 Java 코드는 건물의 높이가 주어질 때, 어떤 건물에서 볼 수 있는 건물의 최대 수를 계산합니다. 
한 건물이 현재 건물과의 기울기가 이전 건물들보다 크면 다른 건물의 전망을 막을 수 있습니다.
*/

import java.io.*;
import java.math.*;

public class Q1027_HIGHRISE_G4 {

	public static void main(String[] args) throws IOException {

		// Initialize input and output stream for reading and writing
		// 입력 및 출력 스트림 초기화하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the number of buildings
		// 건물의 수 읽기
		int N = Integer.parseInt(br.readLine());
		double bld[] = new double[N + 1];
		double s = 0; // Variable to hold the slope value for comparison (비교를 위한 기울기 값을 저장하는 변수)
		int cnt = 0; // Counter to hold the number of buildings that can be seen (볼 수 있는 건물의 수를 저장하는
						// 카운터)
		int res = 0; // Result variable to store the maximum number of buildings that can be seen (볼
						// 수 있는 건물의 최대 수를 저장하는 결과 변수)

		// Parse the building heights from the input
		// 입력에서 건물의 높이 파싱하기
		String inp[] = br.readLine().split(" ");
		for (int i = 1; i <= N; i++)
			bld[i] = Double.parseDouble(inp[i - 1]);

		// Check for each building, how many buildings can be seen from it
		// 각 건물에서 몇 개의 건물을 볼 수 있는지 확인하기
		for (int i = 1; i <= N; i++) {
			cnt = 0;
			s = Integer.MIN_VALUE; // Initialize slope value with the minimum value (기울기 값을 최소값으로 초기화)

			// Check for buildings on the left of current building
			// 현재 건물의 왼쪽에 있는 건물들을 확인하기
			for (int j = i - 1; j >= 1; j--) {
				// Calculate the slope with the left building
				// 왼쪽 건물과의 기울기 계산하기
				if (((bld[j] - bld[i]) / Math.abs(j - i)) > s) {
					cnt++; // Increment the counter if the slope is greater than previous (기울기가 이전 것보다 크면
							// 카운터 증가)
					s = ((bld[j] - bld[i]) / Math.abs(j - i)); // Update the slope value (기울기 값을 업데이트)
				}
			}

			s = Integer.MIN_VALUE; // Reset the slope value for right side buildings (오른쪽 건물을 위해 기울기 값을 리셋)

			// Check for buildings on the right of current building
			// 현재 건물의 오른쪽에 있는 건물들을 확인하기
			for (int j = i + 1; j <= N; j++) {
				// Calculate the slope with the right building
				// 오른쪽 건물과의 기울기 계산하기
				if (((bld[j] - bld[i]) / Math.abs(j - i)) > s) {
					cnt++; // Increment the counter if the slope is greater than previous (기울기가 이전 것보다 크면
							// 카운터 증가)
					s = ((bld[j] - bld[i]) / Math.abs(j - i)); // Update the slope value (기울기 값을 업데이트)
				}
			}

			// Update the result if current building's count is greater
			// 현재 건물의 카운트가 더 큰 경우 결과를 업데이트하기
			if (cnt > res)
				res = cnt;

		}

		// Write the result to the output
		// 결과를 출력에 작성하기
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}