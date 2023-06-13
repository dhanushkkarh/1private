import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 'E' for encryption or 'D' for decryption: ");
        String choice = scanner.nextLine().toUpperCase();

        if (choice.equals("E")) {
            System.out.print("Enter the input: ");
            String input = scanner.nextLine();
            System.out.print("Enter the password: ");
            String password = scanner.nextLine();

            String encryptedValue = Encrypt.encrypt(input, password);
            System.out.println("Encrypted value: " + encryptedValue);
        } else if (choice.equals("D")) {
            System.out.print("Enter the encrypted value: ");
            String encryptedValue = scanner.nextLine();
            System.out.print("Enter the password: ");
            String password = scanner.nextLine();

            String decryptedValue = Decrypt.decrypt(encryptedValue, password);
            System.out.println("Decrypted value: " + decryptedValue);
        } else {
            System.out.println("Invalid choice. Please enter 'E' or 'D'.");
        }

        scanner.close();
    }
}
