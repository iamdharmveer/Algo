// 2 WebPages Shortest Path(if the edges weight is unity else do the bellman-ford, djikstra or floyd-warshall)
import java.util.*;
public class All_Pairs_Shortest_Path {
    public static void main(String[] args){
        System.out.print("Enter number of Vertices and Edges: ");
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt(), m =sc.nextInt(), distance[][] =new int[n][n], dist[][] =new int[n][n];
        for(int i =0;i<n;++i)
            for(int j =0;j<n;++j)
                if(i == j)  distance[i][j] =0;
                else    distance[i][j] =Integer.MAX_VALUE;
        System.out.println("Enter edges and cost: ");
        for(int i =0;i<m;++i){
            int a =sc.nextInt(), b =sc.nextInt(), c =sc.nextInt();
            distance[a-1][b-1] =c;
        }
        for(int i =0;i<n;++i)
            for(int j =0;j<n;++j)
                dist[i][j] =distance[i][j];
        for(int k =0;k<n;++k){
            for(int i =0;i<n;++i){
                for(int j =0;j<n;++j){
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                }
            }
        }
        for(int i =0;i<n;++i){
            for(int j =0;j<n;++j){
                if(dist[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF\t");
                else
                    System.out.print(dist[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}