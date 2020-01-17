package back_2252;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위상정렬 문제 시간 복잡도는 V+E 
public class Main {
	
	//N 지점, M 엣지
	static int N, M;
	static ArrayList<Integer> edges[];
	static StringTokenizer st;
	static int[] inD, result;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// N, M입력값을 입력 받는다.
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edges = new ArrayList[N+1];
		inD = new int[N+1];
		result = new int[N+1];
		for(int i=0; i<=N; i++) edges[i] = new ArrayList<Integer>();
		
		// Edge를 입력 받으면서 진입 갯수를 추가한다.
		int a = 0, b = 0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			edges[a].add(b);
			inD[b]++;
		}
		
		topologicalSort();
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) sb.append(result[i]).append(" ");
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	public static void topologicalSort() {
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		// 진입점이 0인 것을 찾아 q에 넣는다.
		for(int i=1; i<=N; i++) {
			if(inD[i] == 0) q.add(i);
		}
				
		// N만큼 돌면서 진입점이 0인 지점에서 이동지점을 체크하고 만약 이동지점이 0이 되면 q에 넣는다.
		for(int i=1; i<=N; i++) {
			int n = q.poll();
			result[i] = n;
			for(int next : edges[n]){
				inD[next]--;
				if(inD[next] == 0) q.add(next);
			}
		}
	}
	
}
