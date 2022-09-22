import java.util.Scanner;

public class FindMultiplicativeInverse {
    static int modInverse(int A, int M)
    {

        for (int X = 1; X < M; X++)
            if (((A % M) * (X % M)) % M == 1)
                return X;
        return 1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter A - ");
        int a = scan.nextInt();
        System.out.print("Enter M - ");
        int m = scan.nextInt();
        System.out.println(modInverse(a, m));
    }
}
