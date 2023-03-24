package Implementation;


import java.io.*;
import java.time.*;
import java.time.format.*;

public class Q10699_Todays_Date_B5 {

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			
			//BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
			
			LocalDateTime ldt = LocalDateTime.now();
			//java.time ��Ű���� LocalDateTime Ŭ������ �ý��� �ð��� ��¥, �ð��� �����´�.
			//�� ���������� ��¥�� ����ϸ� �Ǳ� ������ LocalDate�� �ϴ°� �´�.
			
			DateTimeFormatter ftr = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			// DateTime�̱� ������ ���˿� hh, mm, ss�� ���Խ�ų ��� ��, ��, �ʱ��� �޾ƿ� �� �ִ�.
			
			String now = ldt.format(ftr);
			// ���糯¥ ldt�� ��¥���� ftr�� ������� ����� ���� String ���·� ������ش�.
			
			bw.write(now);
			
			bw.flush();
			bw.close();
			

	}

}
