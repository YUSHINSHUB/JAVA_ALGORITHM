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
	//Ŭ���� �ȿ��ִ� ������ �ʵ��� �Ѵ�.

	myInt(int a, int b, int c, int d, int e, int f) {
		// Ŭ�����̸�() �� �����ڶ�� �Ѵ�. �����ڴ� �ش� Ŭ������ ȣ���Ҷ� ����Ǵ� �޼ҵ��̴�.
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
	//Ŭ���� ���� �޼ҵ带 ������ �� �ִ�. main�Լ����� �ҷ��� ���� ��ü��.�޼ҵ�� �� ���·� ����Ѵ�.

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
		// ���赵�� ������ �ϴ� Ŭ������ ������� ��ü(object, �ν��Ͻ� ��� �Ѵ�.) �� �����Ͽ���.
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
