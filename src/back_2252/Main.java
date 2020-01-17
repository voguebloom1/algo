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

// �������� ���� �ð� ���⵵�� V+E 
public class Main {
	
	//N ����, M ����
	static int N, M;
	static ArrayList<Integer> edges[];
	static StringTokenizer st;
	static int[] inD, result;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// N, M�Է°��� �Է� �޴´�.
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edges = new ArrayList[N+1];
		inD = new int[N+1];
		result = new int[N+1];
		for(int i=0; i<=N; i++) edges[i] = new ArrayList<Integer>();
		
		// Edge�� �Է� �����鼭 ���� ������ �߰��Ѵ�.
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
		
		// �������� 0�� ���� ã�� q�� �ִ´�.
		for(int i=1; i<=N; i++) {
			if(inD[i] == 0) q.add(i);
		}
				
		// N��ŭ ���鼭 �������� 0�� �������� �̵������� üũ�ϰ� ���� �̵������� 0�� �Ǹ� q�� �ִ´�.
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
