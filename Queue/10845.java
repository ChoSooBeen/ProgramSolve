import java.io.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void push(int num) {
        list.add(num);
    }
    public static void pop() {
        if (list.size() == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(list.get(0));
            list.remove(0);
        }
    }
    public static void size() {
        System.out.println(list.size());
    }

    public static void empty() {
        if(list.size() == 0)
            System.out.println(1);
        else
            System.out.println(0);
    }

    public static void front() {
        if(list.size() == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(list.get(0));
        }
    }
    public static void back() {
        if (list.size() == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(list.get(list.size()-1));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine()); //몇 번의 명령어를 입력할 것인가

        for(int i = 0; i < num; i++) {
            String s = bf.readLine();
            if(s.equals("pop")) {
                pop();
            }
            else if(s.equals("size")) {
                size();
            }
            else if(s.equals("empty")){
                empty();
            }
            else if(s.equals("back")) {
                back();
            }
            else if(s.equals("front")){
                front();
            }
            else {
                int n = Integer.parseInt(s.split(" ")[1]);
                push(n);
            }
        }

    }
}
