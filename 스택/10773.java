import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>(); //int형 스택 선언

        int N = Integer.parseInt(bf.readLine());
        for(int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(bf.readLine());
            if(tmp == 0 && !stack.empty()) {
                stack.pop();
            }
            else {
                stack.push(tmp);
            }
        }

        int result = 0;
        while(!stack.empty()) {
            result += stack.pop();
        }

        System.out.println(result);
    }
}
