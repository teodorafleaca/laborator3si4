package laborator6;

public class DoubleCalculator extends ACalculator{
    public DoubleCalculator(double numar) {
        this.state=numar;
    }


    public DoubleCalculator  add(double numar) {
        this.state = (double)this.state+numar;
        return this;
    }
    public DoubleCalculator substract(double numar) {
        this.state=(double)this.state-numar;
        return this;
    }
    public DoubleCalculator multiply(double numar) {
        this.state=(double)this.state*numar;
        return this;
    }
    @Override
    protected void init() {
        this.state=0;
    }

}
