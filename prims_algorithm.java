import java.util.*;
public class prims_algorithm {
    public static final int v=5;
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
    void printmst(int parent[],int graph[][]){
        for(int i=1 ;i<v;i++){
            System.out.println(parent[i] + "--"+i+"\t"+graph[i][parent[i]]);
        }
    }
    void primmst(int graph[][]){
        int parent[] =new int[v];
        int key[] = new int [v];
        boolean mstkey[] = new boolean [v];
        for(int i=0;i<v;i++){
            key[i]=Integer.MAX_VALUE;
            mstkey[i]=false;
        }
        key[0]=0;
        parent[0]=-1;
        for(int c=0;c<v-1;c++){
            int u=minkey(key,mstkey);
            mstkey[c]=true;
            for(int i=0;i<v;i++){
                if(graph[u][i]!=0 && mstkey[i]==false && graph[u][i]<key[i]){
                    parent[i]=u;
                    key[i]=graph[u][i];
                }
            }
        }
        printmst(parent,graph);
    }
    public static void main(String args[]){
        prims_algorithm t =new prims_algorithm();
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },{ 2, 0, 3, 8, 5 },{ 0, 3, 0, 0, 7 },{ 6, 8, 0, 0, 9 },{ 0, 5, 7, 9, 0 } };
        t.primmst(graph);
    }
}
