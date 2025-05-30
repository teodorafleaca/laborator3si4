package laborator9;

import java.util.Arrays;
import java.util.List;

public class Lista {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 9, 13, 14, 19, 6, 11, 8, 7, 10);
        System.out.println("Lista generata este: " + numbers);
        int sum=numbers.stream().reduce(0, Integer::sum);
        System.out.println("Suma este: " + sum);

        int max=numbers.stream().max(Integer::compare).get();
        System.out.println("Maximul este: " + max);
        int min=numbers.stream().min(Integer::compare).get();
        System.out.println("Minimul este: " + min);

        List<Integer>filteredNumbers=numbers.stream()
                .filter(num->num>=10 && num<=20)
                .toList();
        System.out.println("Lista generata este: " + filteredNumbers);

        List<Double> asDoubles = numbers.stream()
                .map(Integer::doubleValue)
                .toList();
        System.out.println("Lista transformată în Double: " + asDoubles);

        boolean contains12 = numbers.contains(12);
        System.out.println("Lista conține valoarea 12? " + contains12);


       //2
        List<Integer> listaOriginala = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        System.out.println("Lista originala: " + listaOriginala);
        List<Integer> patrateDistincte = listaOriginala.stream()
                .distinct()
                .map(n -> n * n)
                .toList();

        System.out.println("Pătratele valorilor distincte: " + patrateDistincte);


        //3
        List<String> cuvinte = Arrays.asList("Acesta", "este", "un", "program", "scris", "cu", "java", "8", "si", "expresii", "lambda");
        System.out.println("Lista cuvinte: " + cuvinte);

        List<String> lungimeCelPutin5 = cuvinte.stream()
                .filter(cuv -> cuv.length() >= 5)
                .toList();
        System.out.println("Cuvinte cu lungime >= 5: " + lungimeCelPutin5);
        System.out.println("Număr cuvinte: " + lungimeCelPutin5.size());

        List<String> ordonate = lungimeCelPutin5.stream()
                .sorted()
                .toList();
        System.out.println("Cuvinte ordonate: " + ordonate);

        cuvinte.stream()
                .filter(cuv -> cuv.startsWith("p"))
                .findFirst()
                .ifPresent(cuv -> System.out.println("Primul cuvânt care începe cu 'p': " + cuv));






    }
}
