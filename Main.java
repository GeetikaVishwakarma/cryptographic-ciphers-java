import java.util.*;

public class Main {

    // Caesar Cipher
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

    // Vigenere Cipher
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

    // Rail Fence Cipher
    public static String railFenceEncrypt(String text, int key) {
        if (key <= 1) return text;

        StringBuilder[] rail = new StringBuilder[key];
        for (int i = 0; i < key; i++) rail[i] = new StringBuilder();

        int row = 0;
        boolean down = true;

        for (char c : text.toCharArray()) {
            rail[row].append(c);

            if (row == 0) down = true;
            else if (row == key - 1) down = false;

            row += down ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rail) result.append(sb);

        return result.toString();
    }

    // Main Menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Cryptographic Ciphers ---");
            System.out.println("1. Caesar Cipher");
            System.out.println("2. Vigenere Cipher");
            System.out.println("3. Rail Fence Cipher");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 4) break;

            System.out.print("Enter text: ");
            String text = sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter shift: ");
                    int shift = sc.nextInt();
                    System.out.println("Encrypted: " + caesarEncrypt(text, shift));
                    System.out.println("Decrypted: " + caesarDecrypt(caesarEncrypt(text, shift), shift));
                    break;

                case 2:
                    System.out.print("Enter key: ");
                    String key = sc.nextLine();
                    System.out.println("Encrypted: " + vigenereEncrypt(text, key));
                    System.out.println("Decrypted: " + vigenereDecrypt(vigenereEncrypt(text, key), key));
                    break;

                case 3:
                    System.out.print("Enter rows: ");
                    int k = sc.nextInt();
                    System.out.println("Encrypted: " + railFenceEncrypt(text, k));
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}