import java.util.Scanner;
import java.math.BigInteger;

public class marathon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");

        BigInteger A = new BigInteger(s[0]);
        BigInteger B = new BigInteger(s[1]);

        System.out.println(A.add(B));
    }
}

//https://github.com/ChoSooBeen/ReviewNote/blob/main/10757.md
