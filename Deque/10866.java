import java.io.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void push(int num, int flag) {
        if(flag == 0){
            list.add(0, num);
        }
        else {
            list.add(num);
        }
    }
    public static void pop(int flag) {
        if (list.size() == 0) {
            System.out.println(-1);
        }
        else {
            if(flag == 0){
                System.out.println(list.get(0));
                list.remove(0);
            }
            else {
                int index = list.size()-1;
                System.out.println(list.get(index));
                list.remove(index);
            }
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

    public static void print_num(int flag) {
        if(list.size() == 0) {
            System.out.println(-1);
        }
        else {
            if(flag ==0) {
                System.out.println(list.get(0));
            }
            else {
                System.out.println(list.get(list.size()-1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine()); //몇 번의 명령어를 입력할 것인가

        //flag = 0(front), 1(back)
        for(int i = 0; i < num; i++) {
            String s = bf.readLine();
            if(s.equals("empty")) {
                empty();
            }
            else if(s.equals("size")) {
                size();
            }
            else if(s.equals("front")){
                print_num(0);
            }
            else if(s.equals("back")){
                print_num(1);
            }
            else if(s.contains("pop")){
                if(s.contains("back")){
                    pop(1);
                }
                else {
                    pop(0);
                }
            }
            else {
                int n = Integer.parseInt(s.split(" ")[1]);
                if(s.contains("back")) {
                    push(n, 1);
                }
                else {
                    push(n, 0);
                }
            }
        }

    }
}
