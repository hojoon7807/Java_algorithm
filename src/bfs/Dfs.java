package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dfs {
    public static boolean[] isVisited=new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void dfs(int start){
        isVisited[start] = true;
        System.out.print(start+" ");
        for (Integer i: graph.get(start)){
            if (!isVisited[i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<=8;i++){
            graph.add(new ArrayList<Integer>());
        }

        for (int i=0;i<9;i++){
            String[] nv = br.readLine().split(" ");
            int n1 = Integer.parseInt(nv[0]);
            int n2 = Integer.parseInt(nv[1]);

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
        System.out.println(graph);

        dfs(1);
    }

}
