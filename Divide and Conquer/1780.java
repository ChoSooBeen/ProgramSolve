import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PaperCut {
    static int one = 0; // 1로만 채워진 종이의 개수
    static int zero = 0; // 0으로만 채워진 종이의 개수
    static int minusOne = 0; // -1로만 채워진 종이의 개수
    static int[][] paper;

    /**
     * 현재 위치에서 정해진 사이즈만큼 똑같은 숫자로만 채워져있는지 확인하는 함수
     * @param row 시작 행
     * @param col 시작 열
     * @param size 시작 위치에서 부터 검사할 사이즈
     * @return 모두 같은 숫자로 이루어져 있으면 true / 아닐 경우 false
     */
    static boolean search(int row, int col, int size) {
        int current = paper[row][col];
        for(int i = row; i < row+size; i++) {
            for(int j = col; j < col+size; j++) {
                if(paper[i][j] != current){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 종이가 같은 수로 채워져 있으면 각 개수를 count
     * 위의 경우가 아니면 3분할 하는 함수
     * @param row 시작 행
     * @param col 시작 열
     * @param size 종이 크기
     */
    static void division(int row, int col, int size) {
        if(search(row, col, size)) {
            if(paper[row][col] == 1)
                one++;
            else if(paper[row][col] == 0)
                zero++;
            else
                minusOne++;
        }
        else {
            int new_size = size / 3;
            division(row, col, new_size);
            division(row, col+new_size, new_size);
            division(row, col+new_size*2, new_size);
            division(row+new_size, col, new_size);
            division(row+new_size, col+new_size, new_size);
            division(row+new_size, col+new_size*2, new_size);
            division(row+new_size*2, col, new_size);
            division(row+new_size*2, col+new_size, new_size);
            division(row+new_size*2, col+new_size*2, new_size);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); //종이 한변의 길이

        paper = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        division(0,0,N);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }
}
