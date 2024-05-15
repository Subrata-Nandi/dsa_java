package greedy;

public class FloydWarshall {

	public static void floyd(int adj[][]) {
		int n = adj.length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					adj[i][j] = Math.min(adj[i][j], (adj[i][k] + adj[k][j]));
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.println("Distance from " + i + " -> " + j + " : " + adj[i][j]);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int adj[][] = new int[4][4];
		
		for(int i=0;i<adj.length;i++) {
			for(int j=0;j<adj[i].length;j++) {
				adj[i][j] = (int) 1e9;
				
				if(i == j) 
					adj[i][j] = 0;
			}	
		}
		
		adj[0][1] = 2;
		adj[1][0] = 1;
		adj[1][2] = 3;
		adj[3][0] = 3;
		adj[3][1] = 5;
		adj[3][2] = 4;
		
		floyd(adj);
	}

}

/*

Output:

Distance from 0 -> 0 : 0
Distance from 0 -> 1 : 2
Distance from 0 -> 2 : 5
Distance from 0 -> 3 : 1000000000
Distance from 1 -> 0 : 1
Distance from 1 -> 1 : 0
Distance from 1 -> 2 : 3
Distance from 1 -> 3 : 1000000000
Distance from 2 -> 0 : 1000000000
Distance from 2 -> 1 : 1000000000
Distance from 2 -> 2 : 0
Distance from 2 -> 3 : 1000000000
Distance from 3 -> 0 : 3
Distance from 3 -> 1 : 5
Distance from 3 -> 2 : 4
Distance from 3 -> 3 : 0

*/
