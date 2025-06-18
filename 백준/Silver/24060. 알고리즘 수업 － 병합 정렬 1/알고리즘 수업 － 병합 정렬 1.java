import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] tmp;
    static int count;
    static int result = -1;
    static int k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        tmp = new int[n];

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, arr.length - 1);

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }

    static void merge_sort(int[] arr, int l, int r) {
        if (count > k) return;
        if (l < r) {
            int m = l + (r - l) / 2;

            merge_sort(arr, l, m);
            merge_sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        int lp = l;
        int rp = m + 1;
        int idx = l;

        while (lp <= m && rp <= r) {
            if (arr[lp] < arr[rp]) tmp[idx++] = arr[lp++];
            else tmp[idx++] = arr[rp++];
        }

        while (lp <= m) {
            tmp[idx++] = arr[lp++];
        }

        while (rp <= r) {
            tmp[idx++] = arr[rp++];
        }

        for (int i = l; i <= r; i++) {
            arr[i] = tmp[i];

            count++;
            if (count == k) {
                result = arr[i];
            }
        }
    }
}