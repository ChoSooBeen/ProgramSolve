package test;
import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        String a = input.nextLine();
        int num = 1;
        if (a.substring(a.length()-1).compareTo("0") == 0){
            num = 2;
        }
        int b = Integer.parseInt(a.substring(a.length()-num));
        int c = Integer.parseInt(a.substring(0, a.length()-num));
        System.out.println(b+c);
    }
}
