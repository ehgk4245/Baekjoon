import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[10];

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int total = A * B * C;

        char[] charArray = String.valueOf(total).toCharArray();

        for (char c : charArray) {
            arr[c - '0']++;
        }

        for (int i : arr) {
            bw.write(i + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
