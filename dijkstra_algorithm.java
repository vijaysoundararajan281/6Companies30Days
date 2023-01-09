import java.util.*;
public class dijkstra_algorithm {
    public static final int v=6;
    public int minkey(int key[],boolean mstkey[]){
        int min=Integer.MAX_VALUE;
        int min_index=-1;
        for(int i=0;i<v;i++){
            if(mstkey[i]==false &key[i]<min){
                min=key[i];
                min_index=i;
            }
            
        }
        return min_index;
    }
    void printdijkstra(int key[]){
        for(int i=0 ;i<v;i++){
            System.out.println(i + "\t\t"+key[i]);
        }
    }
    void dijkstra(int graph[][],int h){
        //int parent[] =new int[v];
        int key[] = new int [v];
        boolean mstkey[] = new boolean [v];
        for(int i=0;i<v;i++){
            key[i]=Integer.MAX_VALUE;
            mstkey[i]=false;
        }
        key[h]=0;
        //parent[0]=-1;
        for(int c=0;c<v-1;c++){
            int u=minkey(key,mstkey);
            mstkey[u]=true;
            for(int i=0;i<v;i++){
                if(graph[u][i]!=0 && mstkey[i]==false && key[u]+graph[u][i]<key[i]){
                    //parent[i]=u;
                    key[i]=key[u]+graph[u][i];
                }
            }
        }
        printdijkstra(key);
    }
    public static void main(String args[]){
        dijkstra_algorithm t =new dijkstra_algorithm();
        int graph[][] = new int[][] { {0,4,8,0,0,0},{0,0,11,8,7,0},{0,0,0,0,3,0},{0,0,0,0,0,2},{0,0,0,14,0,0},{0,0,0,0,10,0}};
        t.dijkstra(graph,0);
    }
}
