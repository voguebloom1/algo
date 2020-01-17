package back_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static boolean prime[];
	static ArrayList<Integer> prime_numbers = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		 // 구하고자 하는 숫자 범위
        int N = Integer.parseInt(br.readLine());
   
        prime = new boolean[N+1];
        
        // 소수는 false
        // 1은 소수가 아니므로 제외
        prime[0] = prime[1] = true;       
        for(int i=2; i*i<=N; i++){
            if(!prime[i]) for(int j=i*i; j<=N; j+=i) prime[j]=true;                
        }            
        // 소수 출력
        for(int i=1; i<=N;i++){
        	if(!prime[i]) prime_numbers.add(i);     
        }

        int start=0, end=0, sum=0, count=0;
        while(true) {
        	if(sum >= N ) sum -= prime_numbers.get(start++);
        	else if(end == prime_numbers.size()) break;
        	else sum += prime_numbers.get(end++);       	
        	if(N==sum) count++;        	
        }		
        System.out.println(count);	
		br.close();

	}
	
}
