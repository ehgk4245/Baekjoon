import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deck deck = new Deck();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "1" :
                    deck.pushFront(Integer.parseInt(st.nextToken()));
                    break;

                case "2" :
                    deck.pushBack(Integer.parseInt(st.nextToken()));
                    break;

                case "3" :
                    sb.append(deck.popFront()).append("\n");
                    break;

                case "4" :
                    sb.append(deck.popBack()).append("\n");
                    break;

                case "5" :
                    sb.append(deck.size()).append("\n");
                    break;

                case "6" :
                    sb.append(deck.isEmpty()).append("\n");
                    break;

                case "7" :
                    sb.append(deck.peekFront()).append("\n");
                    break;

                case "8" :
                    sb.append(deck.peekBack()).append("\n");
                    break;
            }
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();

    }

    static class Deck {

        private final static Deque<Integer> deck = new ArrayDeque<>();

        public void pushFront(int x) {
            deck.addFirst(Integer.valueOf(x));
        }

        public void pushBack(int x) {
            deck.addLast(Integer.valueOf(x));
        }

        public int popFront() {
            if(isEmpty() == 0) {
                return deck.removeFirst();
            }
            return -1;
        }

        public int popBack() {
            if(isEmpty() == 0) {
                return deck.removeLast();
            }
            return -1;
        }

        public int size() {
            return deck.size();
        }

        public int isEmpty() {
            return size() == 0 ? 1 : 0;
        }

        public int peekFront() {
            if (isEmpty() == 0) {
                return deck.peekFirst();
            }
            return -1;
        }

        public int peekBack() {
            if (isEmpty() == 0) {
                return deck.peekLast();
            }
            return -1;
        }

    }
}
