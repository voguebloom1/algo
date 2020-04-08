package leet_2Day;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

		
	public static void main(String[] args) {

		System.out.println(isHappy(19));
	}
	
    public static boolean isHappy(int n) {
    	
    	boolean result = true;
    	HashSet<Integer> hs = new HashSet<Integer>();
    	hs.add(n);
    	int num;
    	while(true) {
    		if(n == 1) break;
    		num = 0;
    		while(n != 0) {
    			num += (n%10) * (n%10);
    			n = n/10;
    		}
    		
    		n = num;
    		if(hs.contains(n)) {
    			result = false;
    			break;
    		}
    		hs.add(n);
    	}
    	
        return result;
    }	
}
