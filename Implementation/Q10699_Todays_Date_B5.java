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
			//java.time 패키지의 LocalDateTime 클래스는 시스템 시계의 날짜, 시간을 가져온다.
			//본 문제에서는 날짜만 출력하면 되기 떄문에 LocalDate로 하는게 맞다.
			
			DateTimeFormatter ftr = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			// DateTime이기 때문에 포맷에 hh, mm, ss를 포함시킬 경우 시, 분, 초까지 받아올 수 있다.
			
			String now = ldt.format(ftr);
			// 현재날짜 ldt에 날짜포맷 ftr을 적용시켜 출력을 위해 String 형태로 만들어준다.
			
			bw.write(now);
			
			bw.flush();
			bw.close();
			

	}

}
