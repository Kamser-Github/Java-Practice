package rambda;
import java.util.function.IntSupplier;
import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
public class RambdaEx04 {
	
	public static void main(String[] args) {
		
		IntSupplier s = ()-> (int)(Math.random()*40)+1;
		IntPredicate p = e -> e%2==0 || e%3==0 ;
		IntConsumer c = e -> System.out.print(e+",");
		IntUnaryOperator op = e-> (int)Math.sqrt(e);
		
		int[] arr = new int[10];
		makeRandomList(s,arr);
		System.out.println(Arrays.toString(arr));
		
		printEvenNum(p,c,arr);
		
		arr = doSomething(op,arr);
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	static void makeRandomList(IntSupplier s, int[] arr) {
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = s.getAsInt();
		}
	}
	
	static void printEvenNum(IntPredicate p,IntConsumer c,int[] arr) {
		System.out.print("[");
		for(int i=0 ; i<arr.length ; i++) {
			if(p.test(arr[i])) {
				c.accept(arr[i]);
			}
		}
		System.out.println("]");
	}
	
	static int[] doSomething(IntUnaryOperator op,int[] arr) {
		int[] newArr = new int[arr.length];
		for(int i=0; i<arr.length ; i++) {
			newArr[i] =op.applyAsInt(arr[i]);
		}
		return newArr;
	}
}
