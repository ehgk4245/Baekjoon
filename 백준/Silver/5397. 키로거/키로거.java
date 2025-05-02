import java.io.*;
import java.util.LinkedList;

import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Cursor cursor = new Cursor();

        for (int i = 0; i < n; i++) {
            String text = br.readLine();
            cursor.handleCommand(text);
            StringBuilder sb = cursor.print();
            bw.write(sb.append("\n").toString());
            cursor.clear();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static class Cursor {

        private List<Character> text;
        private ListIterator<Character> cursor;

        public Cursor() {
            this.text = new LinkedList<>();
            this.cursor = this.text.listIterator();
        }

        public void handleCommand(String s) {
            for (int i = 0; i < s.length(); i++) {
                char command = s.charAt(i);
                switch (command) {
                    case '<' :
                        l();
                        break;

                    case '>' :
                        d();
                        break;

                    case '-' :
                        b();
                        break;

                    default :
                        p(command);
                }
            }
        }

        public void l() {
            if (cursor.hasPrevious()) {
                cursor.previous();
            }
        }

        public void d() {
            if (cursor.hasNext()) {
                cursor.next();
            }
        }

        public void b() {
            if (cursor.hasPrevious()) {
                cursor.previous();
                cursor.remove();
            }
        }

        public void p(char c) {
            cursor.add(c);
        }

        public StringBuilder print() {
            StringBuilder sb = new StringBuilder();
            for (Character c : text) {
                sb.append(c);
            }
            return sb;
        }

        public void clear() {
            text.clear();
            cursor = text.listIterator();
        }
    }

}
