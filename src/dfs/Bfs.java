package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public static boolean[] isVisited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        isVisited[start] = true;

        while (!queue.isEmpty()){
            int x = queue.remove();
            System.out.print(x+" ");
            for (Integer i : graph.get(x)) {
                if(!isVisited[i]){
                    queue.add(i);
                    isVisited[i] = true;
                }
            }
//            for (int i = 0; i < graph.get(x).size(); i++) {
//                int y = graph.get(x).get(i);
//                if (!isVisited[y]) {
//                    queue.add(y);
//                    isVisited[y] = true;
//                }
//            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] nv = br.readLine().split(" ");
            int n1 = Integer.parseInt(nv[0]);
            int n2 = Integer.parseInt(nv[1]);
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
        System.out.println(graph);
        bfs(1);
    }
}
