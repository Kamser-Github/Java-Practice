package lv02;

import java.util.ArrayList;
import java.util.List;

public class ExTest1 {
	
	public static void main(String[] args) {
		
		Integer[] nums = new Integer[5];
		for(int i=0 ; i<5 ; i++) {
			nums[i]=i+1;
		}
		
		Integer[] numsClone = nums.clone();
		for(Integer a : numsClone) {
			System.out.println(a);
		}
	}
}
