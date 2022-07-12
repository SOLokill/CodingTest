package algorithm_java;
/*
    problem :
    task :
    point :
        - 최소의 칸 수를 구할 떄는 BFS를 쓴다.
        - 인접 행렬로 배열을 선언하여 이동할 수 있는 간선을 나타낸다.
        - 칸을 셀 때는 시작 위치에서 부터 1이고 도착하면 1++ 이다.
        - 출발 위치 (1, 1) 에서 시작한다.
        - 범위, 벽, 방문 체크 해주면 된다. (항상 범위 체크는 먼저 해주어야 한다. Index Error를 방지하기 위함)
        - 시작 지점이 벽인지 체크해주면 좋다. 여기서는 그런 경우는 생기지 않는다.
        - 큐에 x, y, d 를 넣어 좌표와 이동 거리를 넣는다.
    explain :
        - 즉, 1인 칸만 지나갈 수 있고 0인 칸은 지나갈 수 없다.
        - 벽이 하나도 없을 때를 먼저 생각해보면, (순서는 동남서북 방향으로 진행한다.)
        DFS는 크게 한 바퀴를 돌면서 진행한다. 절반을 다 돌았으면 위로 ㄹ 모양으로 올라간다.
        BFS는 파동이 번지는 모양과 같다.
    conclusion :
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BK2178 {
    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    //동 서 남 북
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][M + 1];
        visited = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) { //1-base 인 것을 잊지 말자.
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                graph[i][j] = Character.getNumericValue(str.charAt(j-1));
            }
        }
        visited[1][1] = true;
        bfs(1, 1);
        System.out.println(graph[N][M]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] here = queue.poll();
            int nx = here[0];
            int ny = here[1];
            for (int i = 0; i < 4; i++) { // 동서남북 확인 후에 이동 가능한 칸 큐에 저장
                int nextX = nx + dx[i];
                int nextY = ny + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                if (graph[nextX][nextY] == 0 || visited[nextX][nextY]) {
                    continue;
                }
                queue.add(new int[]{nextX, nextY});
                graph[nextX][nextY] = graph[nx][ny] + 1;
                visited[nextX][nextY] = true;
                graph[nextX][nextY] = graph[nx][ny] + 1;
            }
        }
    }
}

