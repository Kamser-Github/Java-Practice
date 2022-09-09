package collection;

import java.util.TreeSet;

public class TreeSetTx1 {
	public static void main(String[] args) {
		TreeSet<Integer> nums = new TreeSet<Integer>();
		
		for(int i=50 ; i>0 ; i-=2) {
			nums.add(i);
		}
		System.out.println(nums);
		//[2, 4, 6, ... , 46, 48, 50]
		
		//#1.first()
		System.out.println(nums.first()); // 2 
		//#2.last()
		System.out.println(nums.last()); // 50 
		//#3.lower() e > ?
		System.out.println(nums.lower(5)); // 4
		//#4.higher e < ?
		System.out.println(nums.higher(5)); //6
		//#5.floor e=> ?
		System.out.println(nums.floor(5)); // 4
		System.out.println(nums.floor(6)); // 6
		//#6.ceiling e=> ?
		System.out.println(nums.ceiling(5)); //6
		System.out.println(nums.ceiling(6)); // 6
		//#7.pollFirst()
		int numsSize = nums.size();
		System.out.println(numsSize); //25
		for(int i=0 ; i<10 ; i++) {
			System.out.print(nums.pollFirst()+" ");
		}
		//2 4 6 8 10 12 14 16 18 20
		System.out.println(); 
		System.out.println(nums.size());//15
		//#8.pollLast()
		numsSize = nums.size();
		System.out.println(numsSize); //15
		for(int i=0 ; i<10 ; i++) {
			System.out.print(nums.pollLast()+" ");
		}
		//50 48 46 44 42 40 38 36 34 32 
		System.out.println(); 
		System.out.println(nums.size());//5
		
		
	}
}
