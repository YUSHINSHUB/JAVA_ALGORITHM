package Dynamic_Programming;

/*
commented by ChatGPT
This Java code implements a dynamic programming solution to calculate the number of ways to fill a zoo with animals. 
The zoo has rows of cages, and each cage can either be empty, contain a lion, or contain a tiger. 
The total number of configurations is calculated using two arrays: mem1 and mem2. mem1[i] represents the number of configurations for the first i cages when the i-th cage is empty, while mem2[i] represents the number of configurations when the i-th cage is not empty (i.e., it contains a lion or a tiger). 
The final answer is the sum of mem1[N] and mem2[N], representing all possible configurations for N cages, modulo 9901 to handle large numbers.

이 Java 코드는 동물원을 동물로 채우는 방법의 수를 계산하기 위한 동적 프로그래밍 솔루션을 구현합니다. 
동물원에는 우리들이 일렬로 있으며, 각 우리는 비어 있거나 사자가 있거나 호랑이가 있을 수 있습니다. 
총 구성 수는 mem1과 mem2라는 두 배열을 사용하여 계산됩니다. 
mem1[i]는 i번째 우리가 비어 있을 때 첫 번째 i 우리들의 구성 수를 나타내며, mem2[i]는 i번째 우리가 비어 있지 않을 때 (즉, 사자나 호랑이가 있을 때) 구성 수를 나타냅니다. 
최종 답은 mem1[N]과 mem2[N]의 합으로, N 개의 우리에 대한 모든 가능한 구성을 나타내며, 큰 수를 다루기 위해 9901로 나눈 나머지를 사용합니다.
*/

import java.io.*;
import java.util.*;

public class Q1309_Zoo_S1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N; // Number of cages in the zoo
		int[] mem1; // Array to store configurations with the i-th cage empty
		int[] mem2; // Array to store configurations with the i-th cage not empty

		N = Integer.parseInt(br.readLine()); // Reading the number of cages
		mem1 = new int[N + 1];
		mem2 = new int[N + 1];
		mem1[0] = 0; // Base case when no cages are present
		mem2[0] = 1; // Base case when no cages are present

		for (int i = 1; i <= N; i++) {
			// Calculating the number of configurations for i cages
			mem1[i] = (mem1[i - 1] + (mem2[i - 1] * 2)) % 9901; // Configurations when i-th cage is empty
			mem2[i] = (mem1[i - 1] + mem2[i - 1]) % 9901; // Configurations when i-th cage is not empty
		}

		// Writing the total number of configurations for N cages modulo 9901
		bw.write((mem1[N] + mem2[N]) % 9901 + "");
		bw.flush();
		bw.close();
	}
}