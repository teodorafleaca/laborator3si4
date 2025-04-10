package laborator6;

public class Main {
    public static void main(String[] args) {
        NewIntCalculator calculator = new NewIntCalculator(10);
        int result = (int)calculator.add(5).substract(3).multiply(2).result();
        System.out.println("a) " + result);

        DoubleCalculator fCalculator = new DoubleCalculator(10);
        double result2 =
                (Double)fCalculator.add(5).substract(3.3).multiply(2.2).result();
        System.out.println("5.4.2 b) "+result2);
    }
    }



