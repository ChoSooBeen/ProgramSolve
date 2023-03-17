import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Confetti {
    static int blue = 0; //파란색 색종이 개수
    static int white = 0; //하얀색 색종이 개수
    static int[][] square;

    //주언진 영역에 서로 다른 색이 있는지 구별
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

    //색종이를 분할하여 똑같은 색만 있으면 그 색의 개수 증가
    //위의 경우가 아니면 다시 분할
    static void division(int row, int col, int size) {
        if(search(row, col, size)) {
            if(square[row][col] == 0)
                white++;
            else
                blue++;
        }
        else {
            int new_size = size / 2;
            division(row, col, new_size);
            division(row, col+new_size, new_size);
            division(row+new_size, col, new_size);
            division(row+new_size, col+new_size, new_size);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); //종이 한변의 길이

        square = new int[N][N]; //하얀색 = 0; 파란색 = 1
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++){
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        division(0,0,N);
        System.out.println(white);
        System.out.println(blue);
    }
}
