package cipher;

public class RouteCipherTest {
    public static void main(String[] args) {
RouteCipher routeCipher = new RouteCipher(4);
        String text = "THIS IS THE PLAIN TEXT";
        String encrypted = routeCipher.encrypt(text);
        System.out.println("Plain text: " + text);
        System.out.println("Encrypted text is: " + encrypted);

        String decrypted = routeCipher.decrypt(encrypted);
        System.out.println("Decrypted text is: " + decrypted);

        System.out.println();

        routeCipher.setKey(5);
        text = "ABORT THE MISSION, YOU HAVE BEEN SPOTTED";
        encrypted = routeCipher.encrypt(text);
        System.out.println("Plain text: " + text);
        System.out.println("Encrypted text is: " + encrypted);

        decrypted = routeCipher.decrypt(encrypted);
        System.out.println("Decrypted text is: " + decrypted);

        System.out.println();

        routeCipher.setKey(-5);
        text = "ABORT THE MISSION, YOU HAVE BEEN SPOTTED";
        encrypted = routeCipher.encrypt(text);
        System.out.println("Plain text: " + text);
        System.out.println("Encrypted text is: " + encrypted);

        decrypted = routeCipher.decrypt(encrypted);
        System.out.println("Decrypted text is: " + decrypted);
    }
}
