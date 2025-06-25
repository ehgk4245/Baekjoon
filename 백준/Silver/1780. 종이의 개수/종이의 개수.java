import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int mOne;
    static int zero;
    static int one;
    static int[][] paper;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0, 0, n);

        System.out.println(mOne);
        System.out.println(zero);
        System.out.println(one);
    }

    public static void recursion(int row, int col, int n) {
        boolean b = true;
        int num = paper[row][col];
        outer :
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (num != paper[i][j]) {
                    b = false;
                    break outer;
                }
            }
        }
        if (b) {
            count(num);
            return;
        }

        int nn = n / 3;

        for (int i = row; i < row + n; i += nn) {
            for (int j = col; j < col + n; j += nn) {
                recursion(i, j, nn);
            }
        }
    }

    private static void count(int num) {
        switch(num) {
            case -1 :
                mOne++;
                break;
            case 0 :
                zero++;
                break;
            case 1 :
                one++;
        }
    }
}