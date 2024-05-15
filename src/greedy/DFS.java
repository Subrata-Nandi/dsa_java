package greedy;
import java.util.*;

class Solution1 {
	
	public ArrayList<Integer> dfs(int s, ArrayList<ArrayList<Integer> > adj, boolean visited[],
			ArrayList<Integer> ls) {
		visited[s] = true;
		ls.add(s);
		
		for(Integer it: adj.get(s)) {
			if(visited[it] == false) {
				dfs(it, adj, visited, ls);
			}
		}
		
		return ls;
	}
}

public class DFS {
	
	int v;
	static ArrayList<ArrayList<Integer>> adj;
	
	DFS(int v) {
		this.v = v;
		adj = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<=v;i++) 
			adj.add(new ArrayList<Integer>());
	}
	
	void addEdge(int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	void printList(ArrayList<ArrayList<Integer> > adj) {
		for(int i=1;i<adj.size();i++) {
			for(int j=0;j<adj.get(i).size();j++) {
				System.out.print(adj.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
//		DFS g = new DFS(5);
//		
//		g.addEdge(1, 2);
//		g.addEdge(1, 3);
//		g.addEdge(3, 4);
//		g.addEdge(2, 4);
//		g.addEdge(2, 5);
//		g.addEdge(4, 5);
		
		DFS g = new DFS(8);
		
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		g.addEdge(2, 6);
		g.addEdge(2, 5);
		g.addEdge(3, 7);
		g.addEdge(4,  8);
		g.addEdge(7, 8);
		
//		g.printList(adj);
		
		Solution1 obj = new Solution1();
		boolean visited[] = new boolean[adj.size() + 1];
		ArrayList<Integer> ls = new ArrayList<Integer>();
		ls = obj.dfs(1, adj, visited, ls);
		
		System.out.println("Depth first search traversal: ");
		for(Integer i: ls) {
			System.out.print(i + " ");
		}
	}
}


/*
Output:

Depth first search traversal: 
5 2 1 3 4 


Depth first search traversal: 
1 2 6 5 3 4 8 7 
*/