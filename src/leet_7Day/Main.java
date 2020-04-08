package leet_7Day;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

		
	public static void main(String[] args) {

		int[] nums = {1,1,2,2};
		
		System.out.println(countElements(nums));
	}
	
    public static int countElements(int[] arr) {
    	
    	Set<Integer> set = new HashSet<Integer>();
    	for(int i=0; i<arr.length;i++) set.add(arr[i]);
    	
    	int count = 0;
    	for(int i=0; i<arr.length; i++)
    		if(set.contains(arr[i]+1)) count++;
    	
    	return count;
    }

	
}
