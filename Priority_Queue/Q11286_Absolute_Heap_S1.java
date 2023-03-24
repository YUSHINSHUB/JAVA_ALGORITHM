package Priority_Queue;

import java.io.*;

//참고자료: https://chanhuiseok.github.io/posts/ds-4/

class q11286{
	
	int size = 0;
	int node[] = new int[200002];
	
	int getpar(int idx) {
		return node[idx/2];
	}
	
	int getlch(int idx) {
		return node[idx*2];
	}
	
	int getrch(int idx) {
		return node[(idx*2)+1];
	}
	
	void add(int i) {
		
		size++;
		int idx = size;
		node[idx] = i;
		
		while( idx != 1 ) {
			if( Math.abs(getpar(idx)) > Math.abs(node[idx]) ) {
				int temp = node[idx];
				node[idx] = node[idx/2];
				node[idx/2] = temp;
			}else if( Math.abs(getpar(idx)) == Math.abs(node[idx]) && getpar(idx) > node[idx] ) {
				int temp = node[idx];
				node[idx] = node[idx/2];
				node[idx/2] = temp;
			}else break;
			idx /= 2;
		}
	}
	
	void remove() {
		node[1] = node[size];
		size--;
		int idx = 1;
		
		while( idx*2+1 <= size ) {
		if( Math.abs(getlch(idx)) > Math.abs(getrch(idx)) ) {
			if( Math.abs(getrch(idx)) < Math.abs(node[idx]) ) {
				int temp = node[idx];
				node[idx] = getrch(idx);
				node[(idx*2)+1] = temp;
			}else if( Math.abs(getrch(idx)) == Math.abs(node[idx]) ) {
				if( getrch(idx) < node[idx] ) {
					int temp = node[idx];
					node[idx] = getrch(idx);
					node[(idx*2)+1] = temp;
				}
			}else break;
			
			idx*=2;
			idx++;
			
		}else if( Math.abs(getlch(idx)) < Math.abs(getrch(idx)) ) {
			if( Math.abs(getlch(idx)) < Math.abs(node[idx]) ) {
				int temp = node[idx];
				node[idx] = getlch(idx);
				node[(idx*2)] = temp;
			}else if( Math.abs(getlch(idx)) == Math.abs(node[idx]) ) {
				if( getlch(idx) < node[idx] ) {
					int temp = node[idx];
					node[idx] = getlch(idx);
					node[(idx*2)] = temp;
				}
			}else break;
			idx*=2;
		}else{
			if( getlch(idx) <= getrch(idx) ) {
				if( Math.abs(getlch(idx)) < Math.abs(node[idx]) ) {
					int temp = node[idx];
					node[idx] = getlch(idx);
					node[(idx*2)] = temp;
				}else if( Math.abs(getlch(idx)) == Math.abs(node[idx]) ) {
					if( getlch(idx) < node[idx] ) {
						int temp = node[idx];
						node[idx] = getlch(idx);
						node[(idx*2)] = temp;
					}
				}else break;
				idx*=2;
			}else if ( getlch(idx) > getrch(idx) ) {
				if( Math.abs(getrch(idx)) < Math.abs(node[idx]) ) {
					int temp = node[idx];
					node[idx] = getrch(idx);
					node[(idx*2)+1] = temp;
				}else if( Math.abs(getrch(idx)) == Math.abs(node[idx]) ) {
					if( getrch(idx) < node[idx] ) {
						int temp = node[idx];
						node[idx] = getrch(idx);
						node[(idx*2)+1] = temp;
					}
				}else break;
				idx*=2;
				idx++;
			}
		}
		
		}//while
		
		if( size == idx*2 ) {
			if( Math.abs(getlch(idx)) < Math.abs(node[idx]) ) {
				int temp = node[idx];
				node[idx] = getlch(idx);
				node[(idx*2)] = temp;
			}else if( Math.abs(getlch(idx)) == Math.abs(node[idx]) ) {
				if( getlch(idx) < node[idx] ) {
					int temp = node[idx];
					node[idx] = getlch(idx);
					node[(idx*2)] = temp;
				}
			}
		}
		
	}
	
}

public class Q11286_Absolute_Heap_S1{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		q11286 nodes = new q11286();
		
		int n = Integer.parseInt(br.readLine());
		int temp = 0;
		
		for( int i = 0 ; i < n ; i++ ) {
			temp = Integer.parseInt(br.readLine());
			if( temp != 0 ) {
				nodes.add(temp);
			}else {
				if( nodes.size == 0 ) {
					bw.write("0\n");
				}else {
					bw.write(nodes.node[1] + "\n");
					nodes.remove();
				}
			}
		}
		
		bw.flush();
		bw.close();

	}
}
