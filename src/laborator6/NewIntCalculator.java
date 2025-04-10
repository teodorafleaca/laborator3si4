package laborator6;

public class NewIntCalculator extends ACalculator{

    public NewIntCalculator(int numar) {
        this.state=numar;
    }

    public NewIntCalculator add(int numar) {
        this.state = (int)this.state+numar;
        return this;
    }
    public NewIntCalculator substract(int numar) {
        this.state=(int)this.state-numar;
        return this;
    }
    public NewIntCalculator multiply(int numar) {
        this.state=(int)this.state*numar;
        return this;
    }

    @Override
    protected void init() {
        this.state=0;
    }
}
