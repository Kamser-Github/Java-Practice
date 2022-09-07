package collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueue {
	public static void main(String[] args) {
		
		Stack<Integer> st1 = new Stack<Integer>();
		st1.push(10); st1.push(20); st1.push(30); st1.push(40);
		
		System.out.println(st1);
		
		Queue<Integer> q1 = new LinkedList<>();
		System.out.println(q1);
	}
}
