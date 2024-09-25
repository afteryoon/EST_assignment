package solvedAC.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {
    //백준

    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,1,-1,0};
    static int n,m;
    static int[][] graph;
    static int safeAreaMax =0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(safeAreaMax);
    }

    private static void dfs(int wall) {
        if(wall== 3){
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(graph[i][j] == 0){
                    graph[i][j] = 1;
                    dfs(wall+1);
                    graph[i][j] = 0;
                }
            }

        }
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[][] lab = new int[n][m];

        for (int i = 0; i < n; i++) {
            lab[i] = graph[i].clone();
            for (int j = 0; j < m; j++) {
                if(graph[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (ny>=0 && nx>=0 && nx<m && ny<m) {
                    if (lab[nx][ny] == 0) {
                        lab[nx][ny] = 2;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        int safeArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(lab[i][j] == 0){
                    safeArea++;
                }
            }
        }
        safeAreaMax = Math.max(safeAreaMax,safeArea);
    }
}
