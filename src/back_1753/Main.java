package back_1753;

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

	static int V, E, K;
	static ArrayList<Integer[]> edges[];
	static StringTokenizer st;
	
	static int node = 0, cost = 1, costs[];
	
	public static void main(String[] args) throws IOException {
	
		long start = System.currentTimeMillis();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		edges = new ArrayList[V+1];
		costs = new int[V+1];
		
		for(int i=0; i<V+1; i++) {
			edges[i] = new ArrayList<Integer[]>();
			costs[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			Integer edge[] = new Integer[2];
			int from = Integer.parseInt(st.nextToken());
			edge[node] = Integer.parseInt(st.nextToken());
			edge[cost] = Integer.parseInt(st.nextToken());
			edges[from].add(edge);			
		}
		 

		PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>(new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				// TODO Auto-generated method stub
				return o1[cost].compareTo(o2[cost]);
			}
		});
		
		Integer s[] = {K,0};	
		pq.add(s);
		costs[K] = 0;
		
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
		
		for(int i=1; i<V+1; i++) {
			bw.write((costs[i] == Integer.MAX_VALUE ? "INF" : costs[i]) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	
}
