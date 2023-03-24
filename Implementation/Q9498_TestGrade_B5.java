package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Q9498_TestGrade_B5{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int grade = Integer.parseInt(br.readLine());
		
		//if 조건문을 사용하는 가장 기본적인 방식
		if( grade >= 90 & grade <= 100) {
			//논리연산자에는 논리곱 &&, & (AND연산자), 논리합 ||, | (OR연산자)
			// 배타적 논리합 ^ (서로 다른값일 경우 true), 논리부정 ! (NOT연산자)가 있다.
			bw.write("A");
		} else if( grade >= 80 && grade < 90) {
			bw.write("B");
		} else if( grade >= 70 && grade < 80) {
			bw.write("C");
		} else if( grade >= 60 && grade < 70) {
			bw.write("D");
		} else {
			bw.write("F");
		}
		
		bw.flush();
		bw.close();

}
}
