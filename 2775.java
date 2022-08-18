import java.util.Scanner;
public class math_2775 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt(); //입력받은 숫자
        int[] result = new int[testCase];

        for(int i = 0; i < testCase; i++){ //testCase만큼 반복
            int k = scanner.nextInt(); //k층
            int n = scanner.nextInt(); //n호

            int[][] person = new int[k][n];

            for(int j = 0; j < n; j++)
                person[0][j] = j+1; //0층 사람 수 입력

            for(int j = 1; j < k; j++) {
                for(int l = 0; l < n; l++) {
                    for(int m = 0; m <= l; m++) {
                        person[j][l] += person[j-1][m];
                    }
                }
            }

            for(int j = 0; j < n; j++)
                result[i] += person[k-1][j];

        }
        for(int i = 0; i < testCase; i++)
            System.out.println(result[i]);
    }
}
