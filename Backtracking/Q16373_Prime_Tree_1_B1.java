package Backtracking;

import java.io.*;
import java.util.*;


public class Q16373_Prime_Tree_1_B1 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for( int c = 0 ; c < t ; c++ ) {
			
		int n = Integer.parseInt(br.readLine());
		int tree[][] = new int[n-1][2];
		int res[] = new int[n];
		int bs = 0;
		int as = 0;
		
		for( int i = 0 ; i < n ; i++ ) {
			res[i] = i+1;
		}
		
		for( int i = 0 ; i < n-1 ; i++ ) {
			String temp[] = br.readLine().split(" ");
			tree[i][0] = Integer.parseInt(temp[0]);
			tree[i][1] = Integer.parseInt(temp[1]);
		}
		
		for( int i = 0 ; i < n-1 ; i++ ) {
			for( int z = 2 ; z <= Math.min(tree[i][0], tree[i][1]) ; z++ ) {
				if( tree[i][0] % z == 0 && tree[i][1] % z == 0 ) {
					bs++;
					// 입력받은 트리의 합산점수 (점수를 최소한으로 낮추는것이 목표이다.)
					break;
				}
			}
		}
		
		while( true ) {
			int scr[] = new int[n+1];
			for( int i = 1 ; i <= n ; i++ ) {
				scr[i] = 0;
			}
			int max = 0;
			int num = 0;
			for( int i = 0 ; i < n-1 ; i++ ) {
				for( int z = 2 ; z <= Math.min(tree[i][0], tree[i][1]) ; z++ ) {
					if( tree[i][0] % z == 0 && tree[i][1] % z == 0 ) {
						scr[tree[i][0]]++;
						scr[tree[i][1]]++;
						break;
					}
				}
			}
			
			for( int i = 1 ; i <= n ; i++ ) {
				if( scr[i] > max) {
					max = scr[i];
					num = i;
				}else if( scr[i] == max) {
					int acnt = 0;
					int bcnt = 0;
					for( int x = 0 ; x < n-1 ; x++ ) {
						if( tree[x][0] == num ) {
							acnt++;
						}else if( tree[x][0] == i ) {
							bcnt++;
						}
						if( tree[x][1] == num ) {
							acnt++;
						}else if( tree[x][1] == i ) {
							bcnt++;
						}
					}
					if( bcnt > acnt ) {
						max = scr[i];
						num = i;
					}
				}
			}
			//각 요소 (vertices)들과 연결된 bad edges의 수를 계산하여 가장 많은 요소의 위치를 바꾼다.
			// 수가 같을 경우 더 많은 요소와 연결되어 있는 요소를 사용한다.
			int acc[] = new int[n];
			int accnt = 0;
			boolean chk[] = new boolean[n+1];
			chk[num] = true;
			
			for( int i = 0 ; i < n-1 ; i++ ) {
				if( tree[i][0] == num ) {
					chk[tree[i][1]] = true;
				}else if( tree[i][1] == num ) {
					chk[tree[i][0]] = true;
				}
			}
			
			for( int i = 1 ; i <= n ; i++ ) {
				if( chk[i] == false ) {
					acc[accnt] = i;
					accnt++;
				}
			}
			
			int mtemp = 0;
			int min = max;
			int mnum = 0;
			
			for( int i = 0 ; i < accnt ; i++ ) {
				mtemp = 0;
					for( int z = 1 ; z <= n ; z++ ) {
						if( chk[z] == true ) {
						for( int x = 2 ; x <= Math.min(acc[i], z) ; x++ ) {
							if( acc[i] % x == 0 && z % x == 0 ) {
								mtemp++;
								continue;
							}
						}
						}
					}
					if( min > mtemp ) {
							min = mtemp;
							mnum = acc[i];
						}
					}
			
			if( min >= max ) {
				break;
			}else {
				for( int i = 0 ; i < n ; i++ ) {
					if( res[i] == num ) {
						res[i] = mnum;
					}else if( res[i] == mnum ) {
						res[i] = num;
					}
				}
				}
			//교체 후의 bad edge 수를 계산하여 원래의 수보다 많거나 같아질 경우에는 종료하고 아닐 경우에는
			//교체를 실행한다.
			
			for( int i = 0 ; i < n-1 ; i++ ) {
				if( tree[i][0] == num ) {
					tree[i][0] = mnum;
				}else if( tree[i][0] == mnum ) {
					tree[i][0] = num;
				}
				if( tree[i][1] == mnum ) {
					tree[i][1] = num;
				}else if( tree[i][1] == num ) {
					tree[i][1] = mnum;
				}
				
			}
			for( int i = 0 ; i < n-1 ; i++ ) {
				for( int z = 2 ; z <= Math.min(tree[i][0], tree[i][1]) ; z++ ) {
					if( tree[i][0] % z == 0 && tree[i][1] % z == 0 ) {
						as++;
						break;
					}
				}
			}
			
			if( as == bs ) {
				break;
				//교체전과 교체후의 bad edge 수가 같을경우 교체를 종료한다.
			}else {
				bs = as;
				as = 0;
			}
			
		}
		
		for( int i = 0 ; i < n ; i++ ) {
			bw.write(String.valueOf(res[i]) + " ");
		}
		
		bw.write("\n");
		
		}
		
		bw.flush();
		bw.close();
		
	}
}
