import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[26];

        char[] charArray = br.readLine().toCharArray();

        for (char c : charArray) {
            arr[c - 'a']++;
        }

        for (int i : arr) {
            bw.write(i + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
