package Arithmetic;


import java.io.*;
import java.util.*;

class myInt {
	
	int sh;
	int sm;
	int ss;
	int eh;
	int em;
	int es;
	//클래스 안에있는 변수를 필드라고 한다.

	myInt(int a, int b, int c, int d, int e, int f) {
		// 클래스이름() 은 생성자라고 한다. 생성자는 해당 클래스를 호출할때 실행되는 메소드이다.
		sh = a;
		sm = b;
		ss = c;
		eh = d;
		em = e;
		es = f;
	}

	void getTime() {
		sh = eh - sh;
		sm = em - sm;
		ss = es - ss;
		if (ss < 0) {
			ss += 60;
			sm--;
		}
		if (sm < 0) {
			sm += 60;
			sh--;
		}
	}
	//클래스 내에 메소드를 선언할 수 있다. main함수에서 불러올 때는 객체명.메소드명 의 형태로 사용한다.

}

public class Q5575_TimeCard_B4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String a = br.readLine();
		StringTokenizer ta = new StringTokenizer(a, " ");
		String b = br.readLine();
		StringTokenizer tb = new StringTokenizer(b, " ");
		String c = br.readLine();
		StringTokenizer tc = new StringTokenizer(c, " ");

		int[] an = new int[6];
		int[] bn = new int[6];
		int[] cn = new int[6];

		for (int i = 0; i < 6; i++) {
			an[i] = Integer.parseInt(ta.nextToken());
			bn[i] = Integer.parseInt(tb.nextToken());
			cn[i] = Integer.parseInt(tc.nextToken());
		}

		myInt atime = new myInt(an[0], an[1], an[2], an[3], an[4], an[5]);
		// 설계도의 역할을 하는 클래스를 기반으로 객체(object, 인스턴스 라고도 한다.) 를 선언하였다.
		myInt btime = new myInt(bn[0], bn[1], bn[2], bn[3], bn[4], bn[5]);
		myInt ctime = new myInt(cn[0], cn[1], cn[2], cn[3], cn[4], cn[5]);

		atime.getTime();
		btime.getTime();
		ctime.getTime();

		bw.write(atime.sh + " " + atime.sm + " " + atime.ss + "\n" 
				+ btime.sh + " " + btime.sm + " " + btime.ss + "\n"
				+ ctime.sh + " " + ctime.sm + " " + ctime.ss + "\n");

		bw.flush();
		bw.close();

	}

}
