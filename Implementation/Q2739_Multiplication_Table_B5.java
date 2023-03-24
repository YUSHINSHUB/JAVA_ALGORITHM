package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

// java.io.*로 import 했을떄가 오히려 메모리, 시간 효율이 좋게나옴.

public class Q2739_Multiplication_Table_B5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = Integer.parseInt(br.readLine());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = 1;
		
		while(a <= 9) {
			bw.write(i + " * " + a + " = " + i * a + "\n");
			a++;
		}
		// while( 조건 )
		
		bw.flush();
		bw.close();

	}

}
