import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        int[] arr = new int[x];

        for (int i : number) {
            if (i < x) {
                arr[i]++;
            }
        }

        int count = 0;

        for (int i : number) {
            if (x - i > 0 && arr[x - i] != 0) {
                count++;
            }
        }

        bw.write(String.valueOf(count/2));

        br.close();
        bw.flush();
        bw.close();
    }

}
