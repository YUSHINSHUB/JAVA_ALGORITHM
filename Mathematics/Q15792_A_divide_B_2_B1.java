package Mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;

public class Q15792_A_divide_B_2_B1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		BigDecimal bd1 = new BigDecimal(inp[0]);
		BigDecimal bd2 = new BigDecimal(inp[1]);

		bd1 = bd1.divide(bd2, 1002, BigDecimal.ROUND_DOWN);
		// BigDecimal a.divide(BigDecimal b, n번째 자리까지 표시, ROUND DOWN (버림 // 필요에 따라 올림, 반올림 등의 기능도 있음) )
		bw.write(bd1.toString());

		bw.flush();
		bw.close();
	}
}
