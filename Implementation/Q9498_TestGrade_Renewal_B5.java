package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Q9498_TestGrade_Renewal_B5{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int grade = Integer.parseInt(br.readLine());
		
		switch( (int) grade / 10 ){		// grade / 10의 값을 int 형태로 캐스팅하여 소수점을 날림
		case 10: ;   					// switch-case문은  조건에 부합할 때 break가 걸리기 전까지
		case 9: bw.write("A"); break;	// 아래에 있는 code를 계속 진행시킨다.
		case 8: bw.write("B"); break;
		case 7: bw.write("C"); break;
		case 6: bw.write("D"); break;
		default: bw.write("F"); break;
		}
		
		bw.flush();
		bw.close();

}
}
