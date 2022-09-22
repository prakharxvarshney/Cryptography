import java.util.*;
public class FindGCD {
    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter r1 value - ");
        int a = scan.nextInt();
        System.out.print("Enter r2 value - ");
        int b = scan.nextInt();
        int g;
        g = gcd(a,b);
        System.out.println("GCD(" + a + " , " + b + ") = " + g);
    }
}
