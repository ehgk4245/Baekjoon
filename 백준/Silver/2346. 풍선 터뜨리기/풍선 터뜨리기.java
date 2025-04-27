import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, Integer.parseInt(st.nextToken()));
            deque.addLast(i);
        }

        int next = deque.removeFirst();
        sb.append(next).append(" ");

        while (!deque.isEmpty()) {
            int count = map.get(next);
            next = cycle(deque, count);
            sb.append(next).append(" ");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static int cycle(Deque<Integer> deque, int count) {
        int size = deque.size();
        if (count > 0) {
            count = (count - 1) % size;
            for (int i = 0; i < count; i++) {
                deque.addLast(deque.removeFirst());
            }
            return deque.removeFirst();
        } else {
            count = (-count - 1) % size;
            for (int i = 0; i < count; i++) {
                deque.addFirst(deque.removeLast());
            }
            return deque.removeLast();
        }
    }

}
