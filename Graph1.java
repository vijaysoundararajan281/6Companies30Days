import java.util.*;
class Graph1 {
        public int v;
        public LinkedList<Integer> adj[];
        Graph1(int u){
            v=u;
            adj=new LinkedList[v];
            for(int i=0;i<u;i++){
                adj[i]=new LinkedList();
            }
        }
        void addEdge(int u, int w){
            adj[u].add(w);
        }
        void dfsutil(int s,boolean visited[]){
            visited[s] = true;
            System.out.println(v+" ");
            Iterator<Integer> i= adj[s].listIterator();
            while(i.hasNext()){
                int n= i.next();
                if(!visited[n]){
                    dfsutil(n,visited);
                }
            }
        }
        void dfs(int v){
            boolean visited[] =new boolean[v];
            dfsutil(v,visited);
        }
    public static void main(String args[]){
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);

        g.BFS(2);
    }
}
