package Deque;

import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Q10866_Deque_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		 int n = Integer.parseInt(br.readLine());
				 
		 ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		 for( int k = 0 ; k < n ; k++) {
			 String [] s = br.readLine().split(" ");
			 String cmd = s[0];
			 
			 if(cmd.contentEquals("push_front")) {
				 int num = Integer.parseInt(s[1]);
				 stack.offerFirst(num);
			 }else if(cmd.equals("push_back")) {
				 int num = Integer.parseInt(s[1]);
				 stack.offerLast(num);
			 }else if(cmd.equals("pop_front")) {
				 if( !stack.isEmpty() ) {
				 bw.write(String.valueOf(stack.pollFirst()) + "\n");
				 }else {
					 bw.write("-1" + "\n");
				 }
			 }else if(cmd.equals("pop_back")) {
				 if( !stack.isEmpty() ) {
					 bw.write(String.valueOf(stack.pollLast()) + "\n");
					 }else {
						 bw.write("-1" + "\n");
					 }
			 }else if(cmd.equals("size")) {
				 bw.write(String.valueOf(stack.size()) + "\n");
			 }else if(cmd.contentEquals("empty")) {
				 if(stack.isEmpty()) {
					 bw.write("1" + "\n");
				 }else {
					 bw.write("0" + "\n");
				 }
			 }else if(cmd.equals("front")) {
				 if( !stack.isEmpty() ) {
					 bw.write(String.valueOf(stack.getFirst()) + "\n");
					 }else {
						 bw.write("-1" + "\n");
					 }
			 }else if(cmd.equals("back")) {
				 if( !stack.isEmpty() ) {
					 bw.write(String.valueOf(stack.getLast()) + "\n");
					 }else {
						 bw.write("-1" + "\n");
					 }
			 }
		 }
        
        bw.flush();
        bw.close();

	
}
}
