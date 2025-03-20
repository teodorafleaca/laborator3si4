package laborator3;
import java.security.SecureRandom;
import java.util.Random;

public class PasswordMaker {
    private static final int MAGIC_NUMBER;
    private final String magicString;
    private final String name;
    private static PasswordMaker instance;
    private static int instanceAccessCount = 0;

    static {
        MAGIC_NUMBER = new SecureRandom().nextInt(6) + 5;
        instance = new PasswordMaker("default");
    }

    private PasswordMaker(String name) {
        this.name = name;
        this.magicString = StringRandomizer.getRandomString(20);
    }

    public static PasswordMaker getInstance(String name) {
        instanceAccessCount++;
        if (instance.name.equals("default")) {
            instance = new PasswordMaker(name);
        }
        return instance;
    }

    public static int getInstanceAccessCount() {
        return instanceAccessCount;
    }

    public String getPassword() {
        String randomPart1 = StringRandomizer.getRandomString(MAGIC_NUMBER);
        int randomLength = new SecureRandom().nextInt(6) + 5; // Valoare între 5 și 10
        String randomPart2 = getRandomSubstring(magicString, randomLength);
        String nameLength = String.valueOf(name.length());
        int randomNumber = new SecureRandom().nextInt(51);

        return randomPart1 + randomPart2 + nameLength + randomNumber;
    }

    private String getRandomSubstring(String source, int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(source.charAt(random.nextInt(source.length())));
        }
        return sb.toString();
    }

}