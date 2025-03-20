package laborator3;

public class Main {
    public static void main(String[] args) {
        PasswordMaker pm = PasswordMaker.getInstance("Andreea");
        System.out.println("Generated Password: " + pm.getPassword());
        PasswordMaker pm2 = PasswordMaker.getInstance("Teodora");
        System.out.println("Generated Password: " + pm2.getPassword());

        System.out.println("getInstance() was accessed " + PasswordMaker.getInstanceAccessCount() + " times.");


    }
}