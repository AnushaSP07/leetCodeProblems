/*

There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:


Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
Example 2:

Input: n = 2, connections = [[0,1]]
Output: [[0,1]]
 

Constraints:

2 <= n <= 105
n - 1 <= connections.length <= 105
0 <= ai, bi <= n - 1
ai != bi
There are no repeated connections.

*/

class Solution {
    int parent[];//Store the parent of each vertex 
	int disct[];//Stores the id, which node has been discovered 
	int low[];//lowest id we can reach from current node u, in another path(not the current path we are traversing)
	boolean visited[];//so that we don't visit the node again 
	int id;
    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) 
    {
        ArrayList<ArrayList<Integer>> graph= new ArrayList<>();
        
        for(int i= 0; i< n; i++)
		     graph.add(new ArrayList<Integer>());
        
        /*Creating the adjacency list*/
        for(List<Integer> edge: connections)
		{
			int u= edge.get(0);
			int v= edge.get(1);
            
            //undirected graph
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
        
        //initializing the arrays 
        parent= new int[n];
		disct= new int[n];
		low= new int[n];
		visited= new boolean[n];
		
        id= 1;//id node counter starting from one 
		parent[0]= -1;//source has no parent, storing it with -1
        
        dfs(graph, 0);//calling the method 
        
        return res;
    }
    private void dfs(ArrayList<ArrayList<Integer>> graph, int u)
	{
        /*
		 * Note ::
		 * ->Once we detect a loop(not parent with lower id value), in the graph while traversing
		 * ->The low change in one node
		 * ->and then all the node in that loop has the same low value(because of the DFS recursive approach)
		 * ->When the low differ between two SCC(Strongly connected Component), that is the indication of the critical edge or the articulation point 
		 * ->Tarjan's Algorithm main objective is to find the number loop in graph @ O(E+V), and detect the critical edge between two SCC by their low values
		 * ->Low value will be different for two different loops  
		 * ->T->O(E+V)
		 * ->SCC is only valid for directed graph
		 * ->Low Disct Concept is Valid for both directed and directed graph 
		 */
        
        disct[u]= low[u]= id;
        //whenever a node is discovered we assigned a unique id to it 
		id+= 1;//increasing the id counter for the next node 
		
		visited[u]= true;//marking as visited, so that we don't traverse the node again 
		
        int count= 0;
		for(int v: graph.get(u))
		{
			if(parent[u] == v)//if the current vertex is the parent vertex
				continue;
			
            //Back Edge, current SCC
			else if(visited[v] == true)//if the current vertex is not parent vertex, but visited from another path
				low[u]= Math.min(low[u], disct[v]);//calculating the low for the current node u, in search of, if we found an element with lower discovered no, in another path 
            
            
			else
			{//Tree Edge, next SCC 
				parent[v]= u;//updating and calculating the parent matrix //u is parent of v
                
				dfs(graph, v);//going in depth of the child
				
				low[u]= Math.min(low[u], low[v]);//still finding the possibility of updating the the low of u
				//with current child v because it was traversing in depth recursively and now backtracking or recursing back
				//in case it( v(child) ) has updated it's low, we are checking and updating if we find a smaller id the u's low
				//if low is updated they belong to same SCC
			    
                
                //if low is not updated(child v) 
				//then child has greater low value, then it(child) belong to another SCC and u a articulation point 
				if(low[v] > disct[u])
                {
                    //When we found a critical or a bridge between two component//v belongs to 1 SCC and u belong to 1 SCC
					// if low of v is greater than low of u, that means that u is the AP
                    
                    ArrayList<Integer> adds= new ArrayList<>();
                    adds.add(u);
                    adds.add(v);
                    res.add(adds);
                }
			}
		}
		return;
	}
}
