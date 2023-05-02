// 토마토
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class BJ_7576 {
    static int M, N;
    static int[] xx = {-1, +1, 0, 0};
    static int[] yy = {0, 0, -1, 1};

    static int[][] box;
    static Queue<tomato2> que = new LinkedList<>();

    static int day_cnt=0, tomato_cnt=0;

    public static int bfs() {
        while(!que.isEmpty()){
            tomato2 temp = que.poll();

            for(int i=0; i<4; i++){
                int nx = temp.row + xx[i];
                int ny = temp.col + yy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M)
                    continue;

                if(box[nx][ny] > 0 || box[nx][ny] == -1)
                    continue;

                que.offer(new tomato2(nx, ny));
                box[nx][ny] = box[temp.row][temp.col] + 1;
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(box[i][j] == 0)
                    return -1;
                if(max < box[i][j])
                    max = box[i][j];
            }
        }

        return max-1; // 첫 날 0일째
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1)
                    que.offer(new tomato2(i, j));
            }
        }

        System.out.print(bfs());
    }
}

class tomato2 {
    int row, col;

    tomato2(int x, int y){
        row = x;
        col = y;
    }
}