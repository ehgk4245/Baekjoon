import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String str = br.readLine();
        List<String> li = new LinkedList<>();
        for(int i = 0; i < str.length(); i++){
            li.add(str.substring(i, i+1));
        }
        ListIterator<String> iterator = li.listIterator();
        while(iterator.hasNext()){
            iterator.next();
        }
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("L")){
                if(iterator.hasPrevious())iterator.previous();
            } else if (command.equals("D")) {
                if(iterator.hasNext())iterator.next();
            } else if (command.equals("B")) {
                if(iterator.hasPrevious()){
                    iterator.previous();
                    iterator.remove();
                }
            } else{
                String s = st.nextToken();
                iterator.add(s);
            }
        }
        for(String s : li){
            bw.write(s);
        }
        bw.flush();
        br.close();
        bw.close();
    }
}