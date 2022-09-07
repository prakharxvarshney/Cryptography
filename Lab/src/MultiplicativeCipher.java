import java.util.*;

public class MultiplicativeCipher {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String bruteText = new String();
        String cipher = new String();
        option();
        System.out.print("Enter the choice - ");
        int choice = scan.nextInt();
        while (true) {
            if (choice == 1) {

            }
            else if (choice==2) {

            }
            else if (choice==3) {

            }
            else if (choice==4) {
                System.out.println("Thank You - Bye Bye");
                System.exit(0);
            }
        }
    }
    public static void option() {
        System.out.println("------------------------------------");
        System.out.println("1. Encryption\n2. Decryption\n3. Brute Force\n4. Exit");
        System.out.println("------------------------------------");
    }
    public static boolean checkPlainText(String plainText) {
        int count = 0;
        for (int i = 0; i < plainText.length(); i++) {
            if (plainText.charAt(i) >= 'a' && plainText.charAt(i) <= 'z') {
                count++;
            }
        }
        if (count == plainText.length()) {
            return true;
        }
        else {
            return false;
        }
    }

}
