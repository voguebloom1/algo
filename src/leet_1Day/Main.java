package leet_1Day;

import java.util.Arrays;

public class Main {

		
	public static void main(String[] args) {
	
		int[] nums = {4,1,2,1,2};
		System.out.println(singleNumber(nums));
	}
	
    public static int singleNumber(int[] nums) {
    
    	if(nums == null || nums.length == 0) return 0;
    	int n = nums.length;
    	int ans = 0;
    	for(int i=0; i<n; i++) {
    	    ans ^= nums[i];
    	}
    	return ans;
    	
    }
	
	
}
