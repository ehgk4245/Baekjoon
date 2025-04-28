import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> list = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(st1.nextToken()) == 0) {
                list.add(Integer.parseInt(st2.nextToken()));
            } else {
                st2.nextToken();
            }
        }

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            list.addFirst(Integer.parseInt(st3.nextToken()));
            sb.append(list.removeLast()).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}
