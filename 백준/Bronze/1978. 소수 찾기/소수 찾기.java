import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputSize = br.readLine();
        Boolean[] checkPrime = new Boolean[Integer.parseInt(inputSize)];

        Arrays.fill(checkPrime, true);

        String numbers = br.readLine();
        String[] primeNumbers = numbers.split(" ");

        for(int i = 0; i < primeNumbers.length; i++) {
            if(primeNumbers[i].equals("1")) {
                checkPrime[i] = false;
            }
            for(int j = 2; j * j <= Integer.parseInt(primeNumbers[i]); j++){
                if (Integer.parseInt(primeNumbers[i]) % j == 0) {
                    checkPrime[i] = false;
                    break;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < checkPrime.length; i++) {
            if(checkPrime[i]) {
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }
}
