package Algo01;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1991_트리순회 {
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static class Node {
		public Node l, r;
		public char c;
		public Node (char c) {
			this.c = c; 
		} 
	}
	private static Node tree[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		tree = new Node[N];
		
		for (int i = 0; i < N; i++) {
			tree[i] = new Node((char) ('A' + i)); 
		}
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0); 
			char l = st.nextToken().charAt(0);
			char r = st.nextToken().charAt(0);
			if (l != '.') 
				tree[root - 'A'].l = tree[l - 'A']; 
			if (r != '.') 
				tree[root - 'A'].r = tree[r - 'A'];
		}
		preorder(0);
		bw.write("\n");
		inorder(0);
		bw.write("\n");
		postorder(0);
		bw.write("\n");
		bw.flush();
		
	}
	private static void preorder (int idx) throws IOException {
		bw.write(tree[idx].c); 
		if (tree[idx].l != null)
			preorder(tree[idx].l.c - 'A');
		if (tree[idx].r != null) 
			preorder(tree[idx].r.c - 'A');
	} 
	private static void inorder (int idx) throws IOException {
		if (tree[idx].l != null)
			inorder(tree[idx].l.c - 'A');
		bw.write(tree[idx].c); 
		if (tree[idx].r != null) 
			inorder(tree[idx].r.c - 'A');
	} 
	private static void postorder (int idx) throws IOException {
		if (tree[idx].l != null) 
			postorder(tree[idx].l.c - 'A');
		if (tree[idx].r != null) 
			postorder(tree[idx].r.c - 'A'); 
		bw.write(tree[idx].c); 
	}
		
		
}
