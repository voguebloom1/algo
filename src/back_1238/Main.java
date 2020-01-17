package back_1238;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, M, X;
	static ArrayList<Integer[]> edges[];
	static ArrayList<Integer[]> backEdges[];
	static StringTokenizer st;
	
	static int node = 0, cost = 1;
	static long costs[], backCosts[];
	
	public static void main(String[] args) throws IOException {
	
		long start = System.currentTimeMillis();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		edges = new ArrayList[N+1];
		backEdges = new ArrayList[N+1];
		costs = new long[N+1];
		backCosts = new long[N+1];
		
		
		for(int i=0; i<N+1; i++) {
			edges[i] = new ArrayList<Integer[]>();
			backEdges[i] = new ArrayList<Integer[]>();
			costs[i] = Integer.MAX_VALUE;
			backCosts[i] = Integer.MAX_VALUE;
		}
		int from, to, c;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			Integer edge[] = {to, c};
			edges[from].add(edge);	
			Integer backEdge[] = {from, c};
			backEdges[to].add(backEdge);
		}
		 
		dijkstra(X, costs, edges);
		dijkstra(X, backCosts, backEdges);
		
		long max =0, n=0;
		for(int i=1; i<N+1; i++) {
			n = costs[i] + backCosts[i];
			max = Math.max(n, max);
		}
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	static void dijkstra(int start, long costs[], ArrayList<Integer[]> edges[]) {
		PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>(new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				// TODO Auto-generated method stub
				return o1[cost].compareTo(o2[cost]);
			}
		});
				
		Integer s[] = {X,0};	
		pq.add(s);
		costs[X] = 0;
		
		while(!pq.isEmpty()) {
			Integer[] now = pq.poll();
			for(Integer[] edge : edges[now[node]]){
				int c = now[cost] + edge[cost];
				if(costs[edge[node]] > c) {
					costs[edge[node]] = c;
					Integer[] next = { edge[node], c};
					pq.add(next);
				}
				
			}
		}	
		
	}
	
}
