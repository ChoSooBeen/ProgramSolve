import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int nk = N - K;

        int n_fac = 1;
        int k_fac = 1;
        int nk_fac = 1;

        for(int i = N; i > 0; i--) {
            n_fac *= i;
            if(i <= K)
                k_fac *= i;
            if(i <= nk)
                nk_fac *= i;
        }
        System.out.println(n_fac/(k_fac * nk_fac));
    }
}
