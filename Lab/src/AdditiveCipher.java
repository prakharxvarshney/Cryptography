import java.util.*;

public class AdditiveCipher {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String bruteText = new String();
        String cipher = new String();
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
                bruteText = plainText;
                cipher = encryption(plainText);
                System.out.println(cipher);
                option();
                System.out.print("Enter your choice - ");
                choice=scan.nextInt();
            }
            else if (choice==2) {
                decryption(cipher);
                option();
                System.out.print("Enter your choice - ");
                choice=scan.nextInt();
            }
            else if (choice==3) {
                bruteforce(cipher,bruteText);
                try{
                    Thread.sleep(2000);
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                option();
                System.out.print("Enter your choice - ");
                choice=scan.nextInt();
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

    public static String inputPlainText() {
        String plainText = scan.nextLine();
        return plainText;
    }
    public static String encryption(String plainText) {
        System.out.print("Enter the key - ");
        int key = scan.nextInt()%26;
        System.out.println("------------------------------------");
        char[] cipher = new char[plainText.length()];
        for(int i=0;i<cipher.length;i++) {
            cipher[i]=(char)((((plainText.charAt(i)-'a')+key)%26) + 'a');
        }
        String cipherText = new String(cipher);
        return cipherText.toUpperCase();
    }

    public static void decryption(String cipher) {
        String cipherLowerCase = cipher.toLowerCase();
        System.out.print("Enter the key - ");
        int key = scan.nextInt();
        char[] plainText = new char[cipher.length()];
        for (int i=0;i<plainText.length;i++) {
            int temp=(((cipherLowerCase.charAt(i)-'a')-key)%26);
            if(temp<0){
                temp+=26;
                temp=temp%26;
            }
            else{
                temp=temp%26;
            }
            // plainText[i] = (char)(((cipherLowerCase.charAt(i)-'a')-key)%26 + 'a');
            plainText[i]=(char)(temp+'a');
        }
        String covertedPlainText = new String(plainText);
        System.out.println(covertedPlainText);
    }
    public static void decryption(String cipher,int key) {
        String cipherLowerCase = cipher.toLowerCase();
        char[] plainText = new char[cipher.length()];
        for (int i=0;i<plainText.length;i++) {
            int temp=(((cipherLowerCase.charAt(i)-'a')-(key%26))%26);
            if(temp<0){
                temp+=26;
                temp=temp%26;
            }
            else{
                temp=temp%26;
            }
            plainText[i] = (char)(temp + 'a');
        }
        String covertedPlainText = new String(plainText);
        System.out.println(covertedPlainText);
    }

    public static void bruteforce(String cipher, String bruteText) {
        HashMap<Integer,String> map= new HashMap<Integer,String>();
        char[] arr = new char[cipher.length()];
        for(int i=0;i<26;i++) {
            for(int k=0;k<cipher.length();k++) {
                arr[k]=(char)((((bruteText.charAt(k)-'a')+i)%26) + 'a');
            }
            String arr1 = new String(arr);
            map.put(i,arr1);
        }
        System.out.println(map);
        for (int i = 0;i<26;i++) {
            if(map.get(i).equals(cipher.toLowerCase())) {
                System.out.println("------------------------------------");
                System.out.println("Key - "+i);
                System.out.print("Decrypted Text - ");
                decryption(cipher,i);
            }
        }
    }
}