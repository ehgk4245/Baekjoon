import java.io.*;
import java.util.*;

public class Main {

    static class Location {

        final int index;
        final int time;

        public Location(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }

    static final MyInterface[] moves = {
            index -> index - 1,
            index -> index + 1,
            index -> index * 2
    };

    interface MyInterface {
        int nextIndex(int index);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Location> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[100001];

        queue.add(new Location(N, 0));

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            if (location.index == K) {
                bw.write(String.valueOf(location.time));
                break;
            }
            for (MyInterface move : moves) {
                int next = move.nextIndex(location.index);
                if (next < 0 || next > 100000) continue;
                if (visit[next]) continue;
                queue.add(new Location(next, location.time + 1));
                visit[next] = true;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }


}