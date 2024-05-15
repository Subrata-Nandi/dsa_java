package greedy;
import java.util.*;

class DisjointSet1 {
	ArrayList<Integer> rank = new ArrayList<Integer>();
	ArrayList<Integer> parent = new ArrayList<Integer>();
	
	public DisjointSet1(int n) {
		for(int i=0;i<=n;i++) {
			rank.add(0);
			parent.add(i);
		}
	}
	
	public int findParent(int node) {
		if(node == parent.get(node)) 
			return node;
		
		int ulp = findParent(parent.get(node));
		parent.set(node, ulp);
		return parent.get(node);
	}
	
	public void unionByRank(int u, int v) {
		int ulp_u = findParent(u);
		int ulp_v = findParent(v);
		
		if(ulp_u == ulp_v) return;
		
		if(rank.get(ulp_u) < rank.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
 		}
		else if(rank.get(ulp_u) > rank.get(ulp_v)) {
			parent.set(ulp_v, ulp_u);
		}
		else {
			parent.set(ulp_v, ulp_u);
			rank.set(ulp_u, rank.get(ulp_u) + 1);
		}
	}
}

public class UnionByRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisjointSet1 ds = new DisjointSet1(7);
		
		ds.unionByRank(1, 2);
		ds.unionByRank(2, 3);
		ds.unionByRank(4, 5);
		ds.unionByRank(6, 7);
		ds.unionByRank(5, 6);
		
		// if 3 and 7 are same or not
		if(ds.findParent(3) == ds.findParent(7))
			System.out.println("Same");
		else
			System.out.println("Not same");
		
		ds.unionByRank(3, 7);
		
		if(ds.findParent(3) == ds.findParent(7))
			System.out.println("Same");
		else
			System.out.println("Not same");
	}

}
