package greedy;
import java.util.*;

public class Dijkstra {

	public static int[] dijkstra(int v, ArrayList<ArrayList<Pair>> adj, int S) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.wt - y.wt);
		int dist[] = new int[v];
		
		for(int i=0;i<v;i++) dist[i] = (int) (1e9);
		
		dist[S] = 0;
		pq.add(new Pair(S, 0));
		
		while(!pq.isEmpty()) {
			int wt = pq.peek().wt;
			int node = pq.peek().node;
			pq.remove();
			
			for(int i=0;i<adj.get(node).size();i++) {
				int edgeWeight = adj.get(node).get(i).wt;
				int adjNode = adj.get(node).get(i).node;
				
				if((wt + edgeWeight) < dist[adjNode]) {
					dist[adjNode] = wt + edgeWeight;
					pq.add(new Pair(adjNode, dist[adjNode]));
				}
			}
		}
		
		return dist;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		int v = 6;
		int start = 0;
		
		// Create adjacency list representation of the graph
		for(int i=0;i<=v;i++) {
			adj.add(new ArrayList<>());
		}
				
		Prims.addEdge(adj, 0, 1, 4);
		Prims.addEdge(adj, 0, 2, 4);
		Prims.addEdge(adj, 1, 2, 2);
		Prims.addEdge(adj, 2, 3, 3);
		Prims.addEdge(adj, 2, 5, 6);
		Prims.addEdge(adj, 2, 4, 1);
		Prims.addEdge(adj, 3, 5, 2);
		Prims.addEdge(adj, 4, 5, 3);
		
		int result[] = new int[v];
		result = dijkstra(v, adj, start);
		
		for(int i=0;i<result.length;i++) {
			System.out.println("Distance from node " + start + " to " + i + " is " + result[i]);
		}
	}

}

/*

Output

Distance from node 0 to 0 is 0
Distance from node 0 to 1 is 4
Distance from node 0 to 2 is 4
Distance from node 0 to 3 is 7
Distance from node 0 to 4 is 5
Distance from node 0 to 5 is 8

*/
