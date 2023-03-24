package Backtracking;

import java.io.*;
import java.math.*;
import java.util.*;

//class place {
//	int x;
//	int y;
//
//	place(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}
// 주석 풀고 실행하기
//
//public class Q15686_Chicken_Delivery {
//
//	static int n;
//	static int m;
//	static ArrayList<place> chp = new ArrayList<place>();
//	static ArrayList<place> hop = new ArrayList<place>();
//	//클래스를 그냥 글로벌 배열로 선언하면 Null Pointer Exception이 뜸.
//	static boolean[] pick;
//	static int res;
//
//	static void bt(int sidx, int cnt) {
//		int sum = 0;
//		int temp = 0;
//		int min = Integer.MAX_VALUE;
//		if (cnt == m) {
//			for (int z = 0; z < hop.size(); z++) {
//				min = Integer.MAX_VALUE;
//				for (int i = 0; i < chp.size(); i++) {
//					if (pick[i]) {
//						//각 집에서 열려있는 치킨집 중 가장 가까운 치킨집을 구한다.
//						temp = Math.abs(hop.get(z).x - chp.get(i).x) + Math.abs(hop.get(z).y - chp.get(i).y);
//						min = Math.min(temp, min);
//					}
//				}
//				sum += min;
//			}
//			res = Math.min(sum, res);
//			//치킨집을 m개 만큼만 남기는 모든 경우의 수 중에 각 집 최소 치킨거리의 합이 가장 작은 값이 최종 결과값이 된다.
//			return;
//		} else {
//			//이러한 방식으로 재귀호출 하면 치킨집을 네개 남겨야 한다고 가정할 때 1,2,3,4번 -> 1,2,3,5번 -> 1,2,3,6번 과 같은 순서로 진행된다.
//			for (int i = sidx; i < chp.size(); i++) {
//				// sidx-1번쨰의 치킨집은 이전 회차에서 사용했기 때문에 i를 sidx부터 시작시켜서 반복회수를 줄인다.
//				if (!pick[i]) {
//					pick[i] = true;
//					bt(i + 1, cnt + 1);
//					pick[i] = false;
//				}
//			}
//		}
//	}
//
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//		String in[] = br.readLine().split(" ");
//		n = Integer.parseInt(in[0]);
//		m = Integer.parseInt(in[1]);
//		res = Integer.MAX_VALUE;
//		int chc = 0;
//		int hom = 0;
//
//		for (int i = 0; i < n; i++) {
//			in = br.readLine().split(" ");
//			for (int z = 0; z < n; z++) {
//				if (in[z].equals("1")) {
//					hop.add(new place(z, i));
//					hom++;
//				} else if (in[z].equals("2")) {
//					chp.add(new place(z, i));
//					chc++;
//				}
//			}
//		}
//
//		pick = new boolean[chp.size()];
//		//글로벌 배열을 사용할떄는 위와 같이 자릿수 지정을 해준다.
//		bt(0, 0);
//
//		bw.write(res + "");
//		bw.flush();
//		bw.close();
//
//	}
//}
