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
		//�׽�Ʈ ���̽� �� te��ŭ�� ��ǥ�� �� ��ǥ�� x, y �ΰ��� ���� �ʿ��ϹǷ� 2���� �迭�� ũ���
		//   [te][2]�̴�.
		
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
			//���ٸ޼ҵ带 ����Ͽ� �ڵ带 ����ȭ �� �� �ִ�.
			//Integer.compare(x, y)�� x > y�� ��� �����, x < y�� ��� ������ �����Ѵ�.
			//x == y�� ��쿡�� 0�� ��ȯ�Ѵ�.
			// �ش� �ڵ��� ��� o1[1]�� o2[1] ���� Ŭ��� ����� �����ϸ� comparator�� ����� ������ ��� 
			// o2�� o1���� ������ �;��Ѵ�. ��������� �̴� ������ ������ �ȴ�.
			// 1���� ���� �迭�� �����ϰ� ���� ������ int[]�� ��� Integer[]���� ����ؾ� �Ѵ�.
		});
		
		for( int i = 0 ; i < te ; i++ ) {
			bw.write(String.valueOf(ca[i][0]) + " " + String.valueOf(ca[i][1]) + "\n");
		}
		
		bw.flush();
		bw.close();

	}

}
