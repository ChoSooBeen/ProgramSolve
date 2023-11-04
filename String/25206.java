import java.io.*;
import java.util.HashMap;

public class BOJ25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] code = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0"};
        HashMap<String, Float> scores = new HashMap<>();
        float score = 4.5f;
        for(int i = 0; i < code.length; i++) {
            scores.put(code[i], score);
            score -= 0.5;
        }
        scores.put("F", 0.0f);

        float total = 0.0f; //학점 총합
        float sum = 0.0f; // 학점 * 과목 평점
        for (int i = 0; i < 20; i++) {
            String[] input = br.readLine().split(" ");
            float tmp = Float.parseFloat(input[1]);
            if (scores.containsKey(input[2])) { //평점이 존재하면
                sum += (tmp * scores.get(input[2]));
                total += tmp;
            }
        }

        System.out.println(String.format("%.6f", sum / total));
    }
}
