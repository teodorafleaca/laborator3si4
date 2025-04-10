package laborator6;

public class IntCalculator {
    int state;
    public IntCalculator(int numar) {
        this.state = numar;


    }


    public IntCalculator add(int numar) {
        this.state += numar;
        return this;
    }
    public IntCalculator substract(int numar) {
        this.state -= numar;
        return this;
    }
    public IntCalculator multiply(int numar) {
        this.state *= numar;
        return this;
    }
    public int result(){
        return this.state;
    }
    public static void main(String[] args) {
        IntCalculator calculator = new IntCalculator(10);
        int result = calculator.add(5).multiply(2).substract(3).multiply(2).result();
        System.out.println("a) " + result);
    }

}
