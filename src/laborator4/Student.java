package laborator4;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String nume;
    private String grupa;
    private List<Integer> note;
    public Student(String nume, String grupa){
        this.nume = nume;
        this.grupa = grupa;
        note = new ArrayList();

    }
    public String getNume(){
        return nume;
    }
    public String getGrupa() {
        return grupa;
    }
    public void adaugaNota(int nota){
       note.add(nota);
    }
    public boolean esteIntegralist(){
        return note.stream().anyMatch(n -> n > 5);
    }
    public float getMedie(){
   return (float) note.stream().mapToInt(Integer::intValue).sum() / note.size();
    }
}
