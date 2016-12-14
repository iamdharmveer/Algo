/*input
3 2
0 2 5
1 2 6
0
*/
import java.util.*;
import java.io.*;
import java.lang.*;
class djikstra{
	static int vertices =0;
	int min_distance(int dist[], Boolean visited[]){
		int min_index =-1, minimum =1000000;
		for(int i =0;i<vertices;++i){
			if(visited[i] == false && dist[i]<=minimum){
				minimum =dist[i];
				min_index =i;
			}
		}
		return min_index;
	}
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		djikstra ob =new djikstra();
		vertices =sc.nextInt();
		int edges =sc.nextInt();
		int a, b, cost, i, j;
		int[][] Graph1 =new int[vertices][vertices];
		for(i =0;i<vertices;++i){
			for(j =0;j<vertices;++j){
				Graph1[i][j] =0;
			}
		}
		for(i=0;i<edges;++i){
			a =sc.nextInt();
			b =sc.nextInt();
			cost =sc.nextInt();
			Graph1[a][b] =cost;
			Graph1[b][a] =cost;
		}
		int source =sc.nextInt();
		System.out.println("Vertex \t Distance from Source");
		int dist[] =new int[vertices];
		Boolean visited[] =new Boolean[vertices];
		Arrays.fill(dist, 1000000);
		Arrays.fill(visited, false);
		dist[source] =0;
		for(i =0;i<vertices-1;++i){
			int u;
			u =ob.min_distance(dist, visited);
			visited[u] =true;
			for(j =0;j<vertices;++j){
				if((!visited[j]) && (Graph1[u][j]!=0) && ((dist[u]+Graph1[u][j])<(dist[j]))){
					dist[j] =dist[u]+Graph1[u][j];
				}
			}
		}
		for(i =0;i<vertices;++i){
			System.out.println(i + "\t\t\t" + dist[i]);
		}
	}
}