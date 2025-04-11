package laborator7;

import laborator6.ACalculator;
import laborator6.NewIntCalculator;
import org.junit.jupiter.api.*;
public class TestCalculator {
private NewIntCalculator intCalc;
@BeforeEach
public void setUp() {
    intCalc=new NewIntCalculator(0);
}
@Test
public void testAddPositive(){
intCalc.add(17).add(10);

Assertions.assertEquals(27, intCalc.result());

}
@Test
    public void testAddNegative(){
    intCalc.add(-17).add(-10);
    Assertions.assertEquals(-27, intCalc.result());
}
@Test
    public void testSubstractPositive(){
    intCalc.substract(17).add(10);
    Assertions.assertEquals(-7, intCalc.result());
}
@Test
    public void testSubstractNegative(){
    intCalc.substract(-17).add(-10);
    Assertions.assertEquals(7, intCalc.result());
}
@Test
    public void testMultiplyPositive(){
    intCalc=new NewIntCalculator(29);
    intCalc.multiply(10);
    Assertions.assertEquals(290, intCalc.result());
}
@Test
    public void testMultiplyNegative(){
    intCalc=new NewIntCalculator(-29);
    intCalc.multiply(-10);
    Assertions.assertEquals(290, intCalc.result());
}
@Test
public void testMultiplyBy0(){
    intCalc=new NewIntCalculator(0);
    intCalc.multiply(7);
    Assertions.assertEquals(0, intCalc.result());
}
@Test
public void testDividePositives(){
    intCalc=new NewIntCalculator(1);


}

}
