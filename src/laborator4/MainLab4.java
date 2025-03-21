package laborator4;

import java.util.*;

public class MainLab4 {
    public static void main(String[] args) {
        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List<Integer> xPlusY = new ArrayList(); //a
        Set<Integer> zSet = new TreeSet(); //b
        List<Integer> xMinusY = new ArrayList();//c
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList(); //d

        Random random = new Random();
        for(int i=0; i<5; i++){
            x.add(random.nextInt(0,10));
        }
        for(int i=0; i<7; i++){
            y.add(random.nextInt(0,10));
        }
        Collections.sort(x);
        Collections.sort(y);
        System.out.println("Lista x= " +x);
        System.out.println("Lista y= " +y);

        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);
      System.out.println("xPlusY= " + xPlusY);

      zSet.addAll(x);
      zSet.addAll(y);
      System.out.println("zSet= " + zSet);

      xMinusY.addAll(x);
      xMinusY.remove(y);
      System.out.println("xMinusY= " + xMinusY);

      for(int num : xPlusY){
          if(num <= p){
              xPlusYLimitedByP.add(num);
          }
      }
      System.out.println("xPlusYLimitedByP= " + xPlusYLimitedByP);

        List<Student> studenti = new ArrayList();

    }


}
