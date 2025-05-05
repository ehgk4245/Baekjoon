import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int index = list.indexOf(target);

            if (index <= list.size() / 2) {
                while (list.peekFirst() != target) {
                    list.add(list.removeFirst());
                    count++;
                }
            } else {
                while (list.peekFirst() != target) {
                    list.addFirst(list.removeLast());
                    count++;
                }
            }
            list.removeFirst();
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.flush();
        bw.close();
    }
}
