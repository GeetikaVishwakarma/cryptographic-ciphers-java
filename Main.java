import java.util.*;

public class Main {

    // ---------------- Caesar Cipher ----------------
    public static String caesarEncrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + shift) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String caesarDecrypt(String text, int shift) {
        return caesarEncrypt(text, 26 - shift);
    }

    // ---------------- Vigenere Cipher ----------------
    public static String vigenereEncrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int j = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetter(c)) {
                int shift = key.charAt(j % key.length()) - 'a';
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + shift) % 26 + base));
                j++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String vigenereDecrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int j = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetter(c)) {
                int shift = key.charAt(j % key.length()) - 'a';
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base - shift + 26) % 26 + base));
                j++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // ---------------- Main Menu ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Cryptographic Ciphers ---");
            System.out.println("1. Caesar Cipher");
            System.out.println("2. Vigenere Cipher");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 3) break;

            System.out.print("Enter text: ");
            String text = sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter shift: ");
                    int shift = sc.nextInt();

                    String enc = caesarEncrypt(text, shift);
                    System.out.println("Encrypted: " + enc);
                    System.out.println("Decrypted: " + caesarDecrypt(enc, shift));
                    break;

                case 2:
                    System.out.print("Enter key: ");
                    String key = sc.nextLine();

                    String enc2 = vigenereEncrypt(text, key);
                    System.out.println("Encrypted: " + enc2);
                    System.out.println("Decrypted: " + vigenereDecrypt(enc2, key));
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
