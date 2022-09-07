import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class HillCipher {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        option();
        System.out.print("Enter the choice - ");
        int choice = scan.nextInt();
        while (true) {
            if (choice == 1) {
                System.out.print("Enter the plain text - ");
                String plainText = scan.next();
                while (!checkPlainText(plainText)) {
                    System.out.print("Re-enter plain-text - ");
                    plainText=scan.next();
                }
                encryption(plainText);
                option();
                System.out.print("Enter your choice - ");
                choice=scan.nextInt();
            }
        }
    }

    public static String encryption(String plainText) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<26; i++) {
            map.put((char)(97+i),i);
        }
        int[][] textMatrix = new int[3][3];
        int l = 0;
        for (int i=0; i<textMatrix.length; i++) {
            for (int j=0; j<textMatrix[0].length; j++) {
                textMatrix[j][i] = map.get(plainText.charAt(l));
                l++;
            }
        }
        for (int i = 0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(textMatrix[i][j]+" ");
            }
            System.out.println();
        }

        System.out.print("Enter the key in small letter - ");
        String key = scan.next();
        int[][] keyMatrix = new int[3][3];
        int k = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                keyMatrix[j][i] = map.get(key.charAt(k));
                k+=1;
            }
        }
        for (int i = 0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(keyMatrix[i][j]+" ");
            }
            System.out.println();
        }

        int[][] cipherMatrix = new int[3][3];
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {

                for(int a=0; a<3; a++) {
                    cipherMatrix[i][j] += textMatrix[a][i]*keyMatrix[i][a];
                }
            }
        }
        for (int i = 0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(cipherMatrix[i][j]+" ");
            }
            System.out.println();
        }
        return plainText;
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

    public static String inputPlainText() {
        String plainText = scan.nextLine();
        return plainText;
    }
}
