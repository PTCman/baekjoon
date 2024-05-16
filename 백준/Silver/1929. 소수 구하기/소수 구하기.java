import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String[] numbers = input.split(" ");

        int start = Integer.parseInt(numbers[0]);
        int end = Integer.parseInt(numbers[1]);

        boolean[] isPrime = new boolean[end + 1]; // 소수 판별 배열
        java.util.Arrays.fill(isPrime, true); // 모든 숫자를 소수로 가정
        isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아님

        for (int i = 2; i * i <= end; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= end; j += i) {
                    isPrime[j] = false; // i의 배수는 소수가 아님
                }
            }
        }

        for (int i = start; i <= end; i++) {
            if (isPrime[i]) { // 시작점부터 끝점까지 소수인지 판별 후 출력
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}