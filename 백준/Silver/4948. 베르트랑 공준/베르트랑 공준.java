import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String input = br.readLine();
            if(input.equals("0")) break;

            int start = Integer.parseInt(input);

            int count = 0;

            Integer[] numbers = new Integer[start];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = start + i +1;
            }


            boolean[] isPrime = new boolean[start]; // 소수 판별 배열
            Arrays.fill(isPrime, true);

            if (numbers[0] == 1) {
                isPrime[0] = false;
            }

            for (int i = 0; i < numbers.length; i++) {
                for (int j = 2; j * j <= 2 * start; j++) {
                    if (numbers[i] % j == 0) {
                        isPrime[i] = false;
                        break;
                    }
                }
            }

            for (boolean b : isPrime) {
                if (b) {
                    count++;
                }
            }

            bw.write(count+"\n");
            bw.flush();
        }

        bw.close();
    }
}