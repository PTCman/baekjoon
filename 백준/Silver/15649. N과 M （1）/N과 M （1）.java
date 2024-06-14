import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 한 줄 입력을 읽어들임
        String line = br.readLine();

        // 공백을 기준으로 분리
        StringTokenizer st = new StringTokenizer(line);

        // 첫 번째 값 읽기, 숫자 범위
        Integer N = Integer.parseInt(st.nextToken());

        // 두 번째 값 읽기, 깊이
        Integer M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        dfs(N, M, 0, bw);

        bw.flush();
        bw.close();
    }

    public static void dfs(int N, int M, int depth, BufferedWriter bw) throws IOException {

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1, bw);
                visit[i] = false;
            }
        }

    }
}
