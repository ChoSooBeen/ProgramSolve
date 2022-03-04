package test;
import java.util.*;

public class CollectionsSort {
    static Scanner s = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        int input = s.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0; i < input; i++){
            a.add(s.nextInt());
        }
        Collections.sort(a);

        for(int i : a) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
