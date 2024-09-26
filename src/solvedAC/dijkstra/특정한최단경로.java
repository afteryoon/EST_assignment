package solvedAC.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정한최단경로 {

    static class Node implements Comparable<Node> {
        int to;
        int price;

        Node(int to, int price) {
            this.to = to;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            return this.to - o.to;
        }
    }

    static int n,e;
    static List<Node>[] graph;
    static int[] dist;
    static int u,v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to,price));
            graph[to].add(new Node(from,price));
        }
        st = new StringTokenizer(br.readLine());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        int result1 = dijkstra(1, u) + dijkstra(u, v) + dijkstra(v, n);
        int result2 = dijkstra(1, v) + dijkstra(v, u) + dijkstra(v, n);
        int result = Math.min(result1, result2);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static int dijkstra(int start, int end) {
        dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE/2);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if(dist[current.to] < current.price) {
                continue;
            }

            for(Node next : graph[current.to]) {
                if(dist[next.to] > dist[current.to] + next.price) {
                    dist[next.to] = next.price+dist[current.to];
                    pq.add(new Node(next.to,dist[current.to]));
                }
            }

        }
        return dist[end];
    }
}
