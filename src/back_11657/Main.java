package back_11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	// N 도시 개수, M 버스 노선 개수
	static int N, M;
	static StringTokenizer st;
	static int edges[][], D[];
	
	static final int from = 0, to = 1, cost = 2; 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		edges = new int[N+1][3];
		D = new int[N+1];
		
		int a,b,c;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			edges[i][from] = a;
			edges[i][to] = b;
			edges[i][cost] = c;
			
		}
		
		boolean minus = bellman(edges, 1, D);
	
		if(minus) {
			System.out.println(-1);
		}else {
			for(int i=2; i<=N; i++) {
				if(D[i] == Integer.MAX_VALUE) System.out.print(-1+" ");
				else System.out.print(D[i]+" ");
			}
		}
		
		
		br.close();

	}
	
	public static boolean bellman(int edges[][], int start, int D[]) {
		
		boolean minus_cycle = false;
		
		Arrays.fill(D, Integer.MAX_VALUE);
		D[start] = 0;
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<M; j++) {
				int[] edge = edges[j];
				int _cost = D[edge[from]] + edge[cost]; 
				
				if(D[edge[to]] > _cost) {
					D[edge[to]] = _cost;
					if(i == N) minus_cycle = true;
				}
				
				
			}
		}
		
		return minus_cycle;
	}
	
	
}
