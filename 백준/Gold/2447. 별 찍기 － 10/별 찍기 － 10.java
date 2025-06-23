import java.io.*;
import java.util.Arrays;

public class Main {

    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = ' ';
            }
        }

        recursion(0, 0, n);

        for (char[] chars : arr) {
            for (char aChar : chars) {
                bw.write(aChar);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void recursion(int row, int col, int n) {
        if (n == 1) return;
        for (int i = row; i < row + n; i++) {
            arr[i][col] = '*';
            arr[i][col + n - 1] = '*';
        }
        for (int j = col; j < col + n; j++) {
            arr[row][j] = '*';
            arr[row + n - 1][j] = '*';
        }

        n = n / 3;

        recursion(row, col, n);
        recursion(row, col + n, n);
        recursion(row, col + 2 * n, n);
        recursion(row + n, col, n);
        recursion(row + n, col + 2 * n, n);
        recursion(row + 2 * n, col, n);
        recursion(row + 2 * n, col + n, n);
        recursion(row + 2 * n, col + 2 * n, n);
    }
}