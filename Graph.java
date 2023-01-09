import java.util.*;
class Graph {
    //public class Graph{
        public int v;
        public LinkedList<Integer> adj[];
        Graph(int u){
            v=u;
            adj=new LinkedList[v];
            for(int i=0;i<u;i++){
                adj[i]=new LinkedList();
            }
        }
        void addEdge(int u, int w){
            adj[u].add(w);
        }
        void BFS(int s){
            boolean visited[] = new boolean[v];
            LinkedList<Integer> queue = new LinkedList<Integer>();
            visited[s] = true;
            queue.add(s);
            while(queue.size() !=0){
                s=queue.poll();
                System.out.println(s+" ");
                Iterator<Integer> i= adj[s].listIterator();
                while(i.hasNext()){
                    int n= i.next();
                    if(!visited[n]){
                        visited[n]=true;
                        queue.add(n);
                    }
                }
            }
        }
    
    public static void main(String args[]){
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);

        g.BFS(3);
    }
}
