import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992 {
    public static int[][] square;
    public static StringBuilder sb = new StringBuilder();

    /**
     * 현재 탐색하려는 영역안에 모두 같은 값이 존재하는지 체크
     * @param row 시작 행
     * @param col 시작 열
     * @param size 탐색할 영역의 크기
     * @return 모두 같은 값 = ture / 아니면 = false
     */
    static boolean search(int row, int col, int size) {
        int current = square[row][col];
        for(int i = row; i < row+size; i++) {
            for(int j = col; j < col+size; j++) {
                if(square[i][j] != current){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 분할하는 함수
     * @param row 시작 행
     * @param col 시작 열
     * @param size 현재 영역
     */
    static void division(int row, int col, int size) {
        if(search(row, col, size)) {
            sb.append(square[row][col]);
        }
        else {
            int new_size = size / 2;
            sb.append("(");
            division(row, col, new_size);
            division(row, col+new_size, new_size);
            division(row+new_size, col, new_size);
            division(row+new_size, col+new_size, new_size);
            sb.append(")");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); //종이 한변의 길이

        square = new int[N][N]; //흰점 = 0; 검은점 = 1

        for(int i = 0; i < N; i++) {
            String[] s = bf.readLine().split("");
            for(int j = 0; j < N; j++){
                square[i][j] = Integer.parseInt(s[j]);
            }
        }
        division(0,0,N);
        System.out.println(sb);
    }
}
