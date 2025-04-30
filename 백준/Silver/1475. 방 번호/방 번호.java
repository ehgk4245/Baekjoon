import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] charArray = br.readLine().toCharArray();

        int[] arr = new int[9];

        for (char c : charArray) {
            if (c - '0' == 9) {
                arr[6]++;
            } else {
                arr[c - '0']++;
            }
        }

        int max = 0;
        arr[6] = (arr[6] + 1)/2;

        bw.write(String.valueOf(Arrays.stream(arr).max().getAsInt()));

        br.close();
        bw.flush();
        bw.close();
    }

}
