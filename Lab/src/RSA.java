import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class RSA {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        double c;
        System.out.print("Enter the message to be encypted and decrypted - ");
        int msg = scan.nextInt();
        System.out.print("Enter first Prime Number (p) - ");
        int p = scan.nextInt();
        System.out.print("Enter second Prime Number (q) - ");
        int q = scan.nextInt();

        int n = p * q;
        int PHI = (p-1)*(q-1);
        int e=2;
        int[] ePair = new int[PHI];
        int j = 0;
        while(e<PHI) {
            if(gcd(e,PHI)==1) {
                ePair[j]=e;
                j++;
            }
            e++;
        }
        System.out.println(Arrays.toString(ePair));
        int d = 0;
        System.out.print("Enter your choice for value of e - ");
        int E = scan.nextInt();
        for(int i=0;i<10;i++) {
            int x=1+(i*PHI);
            if(x%E==0) {
                d = x/E;
                break;
            }
        }
        System.out.println("The value of d is "+d);
        c = ((Math.pow(msg,e))%n)%26;
        System.out.println("Encypted message is - "+c);
        BigInteger N = BigInteger.valueOf(n);
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        BigInteger msgBack = (C.pow(d)).mod(N);
        System.out.println("Decrypted message is - "+msgBack);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            if (a > b) {
                a = a - b;
            }
            else {
                b = b - a;
            }
        }
        return a;
    }
}