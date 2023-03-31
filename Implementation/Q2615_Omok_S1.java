package Implementation;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2615_Omok_S1 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int board[][] = new int[19][19];
		String res = "";
		
		for( int i = 0 ; i < 19 ; i++ ) {
			String inp[] = br.readLine().split(" ");
			for( int z = 0 ; z < 19 ; z++ ) {
				board[i][z] = Integer.parseInt(inp[z]);
			}
		}
		
		int cnt = 0;
		
		for( int i = 0 ; i < 19 ; i++ ) {
			for( int z = 0 ; z < 19 ; z++ ) {
				if( board[z][i] != 0 ) {
					int t = board[z][i];
					//가로검사
					if( i == 14 && board[z][13] != t ) {
						cnt = 1;
						for( int x = 1 ; x <= 4 ; x++ ) {
						if( board[z][i+x] == t ) {
							cnt++;
						}else break;
					}
					}
					if( cnt == 5 ) {
						res = t + "\n" + (z+1) + " " + (i+1); 
						break;
					}
					//세로검사
					if( z == 14 && board[13][i] != t ) {
						cnt = 1;
						for( int x = 1 ; x <= 4 ; x++ ) {
						if( board[z+x][i] == t ) {
							cnt++;
						}else break;
					}
					}
					if( cnt == 5 ) {
						res = t + "\n" + (z+1) + " " + (i+1);
						break;
					}
					//대각검사
					if( (z <= 14 && i == 14) || (z == 14 && i <= 14) ) {
						if( i == 0 || z == 0 ) {
							cnt = 1;
							for( int x = 1 ; x <= 4 ; x++ ) {
							if( board[z+x][i+x] == t ) {
								cnt++;
							}else break;
							}
						}else if( board[z-1][i-1] != t) {
						cnt = 1;
						for( int x = 1 ; x <= 4 ; x++ ) {
						if( board[z+x][i+x] == t ) {
							cnt++;
						}else break;
						}
						}
					}
						
					
					if( cnt == 5 ) {
						res = t + "\n" + (z+1) + " " + (i+1);
						break;
					}
				//가로검사
						if( i < 14 ) {
							if( i == 0 ) {
								cnt = 1;
								for( int x = 1 ; x <= 5 ; x++ ) {
								if( board[z][i+x] == t ) {
									cnt++;
								}else break;
							}
							}else if( board[z][i-1] != t ) {
								cnt = 1;
								for( int x = 1 ; x <= 5 ; x++ ) {
								if( board[z][i+x] == t ) {
									cnt++;
								}else break;
							}
							}
							
						}
						if( cnt == 5 ) {
							res = t + "\n" + (z+1) + " " + (i+1); 
							break;
						}
						
						//세로검사
						if( z < 14 ) {
							if( z == 0 ) {
							cnt = 1;
							for( int x = 1 ; x <= 5 ; x++ ) {
							if( board[z+x][i] == t ) {
								cnt++;
							}else break;
							}
							}else if( board[z-1][i] != t ) {
								cnt = 1;
								for( int x = 1 ; x <= 5 ; x++ ) {
								if( board[z+x][i] == t ) {
									cnt++;
								}else break;
							}
							}
						}
						if( cnt == 5 ) {
							res = t + "\n" + (z+1) + " " + (i+1);
							break;
						}
						//대각검사
						if( z < 14 && i < 14) {
							if( z == 0 || i == 0 ) {
								cnt = 1;
								for( int x = 1 ; x <= 5 ; x++ ) {
								if( board[z+x][i+x] == t ) {
									cnt++;
								}else break;
								}
							}else if( board[z-1][i-1] != t ) {
								cnt = 1;
								for( int x = 1 ; x <= 5 ; x++ ) {
								if( board[z+x][i+x] == t ) {
									cnt++;
								}else break;
								}
							}
						}
						
						if( cnt == 5 ) {
							res = t + "\n" + (z+1) + " " + (i+1);
							break;
						}
						//대각검사
						if( (z == 4 && i <= 14) || (z >= 4 && i == 14) ) {
							if( i == 0 || z == 18) {
							cnt = 1;
							for( int x = 1 ; x <= 4 ; x++ ) {
							if( board[z-x][i+x] == t ) {
								cnt++;
							}else break;
						}
							}else if( board[z+1][i-1] != t ) {
								cnt = 1;
								for( int x = 1 ; x <= 4 ; x++ ) {
								if( board[z-x][i+x] == t ) {
									cnt++;
								}else break;
							}
							}
						}
						
						if( cnt == 5 ) {
							res = t + "\n" + (z+1) + " " + (i+1);
							break;
						}
						//대각검사 (윗방향 오른쪽)
						if( z > 4 && i < 14 ) {
							if( i == 0 || z == 18) {
							cnt = 1;
							for( int x = 1 ; x <= 5 ; x++ ) {
							if( board[z-x][i+x] == t ) {
								cnt++;
							}else break;
						}
							}else if( board[z+1][i-1] != t ) {
									cnt = 1;
									for( int x = 1 ; x <= 5 ; x++ ) {
									if( board[z-x][i+x] == t ) {
										cnt++;
									}else break;
								}
						}
						}
						
						if( cnt == 5 ) {
							res = t + "\n" + (z+1) + " " + (i+1);
							break;
						}
						}
			}
			if( cnt == 5 ) {
				break;
			}
		}
		
		if( cnt == 5 ) {
			bw.write(res);
		}else {
			bw.write("0");
		}
		
		bw.flush();
		bw.close();

	}}