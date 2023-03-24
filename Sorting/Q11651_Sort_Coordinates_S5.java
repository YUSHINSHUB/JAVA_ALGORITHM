package Sorting;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q11651_Sort_Coordinates_S5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int te = Integer.parseInt(br.readLine());
		
		int[][] ca = new int[te][2]; 
		//테스트 케이스 수 te만큼의 좌표와 각 좌표에 x, y 두개의 값이 필요하므로 2차원 배열의 크기는
		//   [te][2]이다.
		
		for( int i = 0 ; i < te ; i++ ) {
			String[] pos = br.readLine().split(" ");
			
			ca[i][0] = Integer.parseInt(pos[0]);
			ca[i][1] = Integer.parseInt(pos[1]);
				
		}
		
		Arrays.sort(ca, (o1, o2) -> {
			if( o1[1] == o2[1] ) {
				return Integer.compare(o1[0], o2[0]);
			}else {
				return Integer.compare(o1[1], o2[1]);
			}
			//람다메소드를 사용하여 코드를 간략화 할 수 있다.
			//Integer.compare(x, y)는 x > y일 경우 양수를, x < y일 경우 음수를 리턴한다.
			//x == y일 경우에는 0을 반환한다.
			// 해당 코드의 경우 o1[1]이 o2[1] 보다 클경우 양수를 리턴하며 comparator가 양수를 리턴할 경우 
			// o2가 o1보다 앞으로 와야한다. 결과적으로 이는 오름차 정렬이 된다.
			// 1차원 정수 배열을 정렬하고 싶을 떄에는 int[]형 대신 Integer[]형을 사용해야 한다.
		});
		
		for( int i = 0 ; i < te ; i++ ) {
			bw.write(String.valueOf(ca[i][0]) + " " + String.valueOf(ca[i][1]) + "\n");
		}
		
		bw.flush();
		bw.close();

	}

}
