package ru.mai.example;

import ru.mai.function.Function;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;

public class NewInJava8 {

    public static void example() {

        /* Example 1. Default methods in interfaces */
        System.out.println();
        System.out.println("*** Example 1. Default methods in interfaces ***");
        Function formula = new Function() {
            @Override
            public double calculate(int x) {
                return sqrt(x) * 3;
            }
        };

        System.out.println(formula.calculate(100));     // 300.0
        System.out.println(formula.sqrt(16));           // 4.0

        /* Example 2. Lambda */
        System.out.println();
        System.out.println("*** Example 2. Lambda ***");
        List<String> names1 = Arrays.asList("Ivan", "Maria", "Anna", "Andrey", "Sergey");

        // in Java 7
        Collections.sort(names1, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        System.out.println(names1);

        List<String> names2 = Arrays.asList("Ivan", "Maria", "Anna", "Andrey", "Sergey");

        // in Java 8
        Collections.sort(names2,
                (String a, String b) -> {
                    return a.compareTo(b);
                });
        Collections.sort(names2, (String a, String b) -> b.compareTo(a));

        Collections.sort(names2, (a, b) -> b.compareTo(a));

        System.out.println(names2);

        /* Example 3. Methods as lambda */
        System.out.println();
        System.out.println("*** Example 3. Methods as lambda ***");
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        try {
            // in Java 8
            Files.lines(Paths.get("test.txt"), StandardCharsets.UTF_8)
                    .forEach(set1::add);

            // in Java 7
            List<String> words = Files.readAllLines(Paths.get("test.txt"), StandardCharsets.UTF_8);
            for (String word : words) {
                set2.add(word);
            }
        } catch (IOException e) {
            System.out.println("Error of read second file: " + e.getMessage());
        }

//        for(String word: set1){
//            System.out.println(word);
//        }

        set1.stream().forEach(System.out::println);
        set2.stream().forEach(System.out::println);

        /* Example 4. Standard functional interfaces. Predicates */
        System.out.println();
        System.out.println("*** Example 4. Standard functional interfaces. Predicates ***");
        List<String> names3 = new ArrayList<>();
        names3.add("Ivan");
        names3.add("Maria");
        names3.add("Anna");
        names3.add("Andrey");
        names3.add("Sergey");

        // lambda
        names3.removeIf(name -> {
            return name.equals("Ivan");
        });

        // Predicates
        Predicate<String> pred1 = name -> "Maria".equals(name);
        Predicate<String> pred2 = name -> "Ivan".equals(name);
        names3.removeIf(pred1.or(pred2));

        names3.stream().forEach(System.out::println);

        /* Example 5. Optional */
        System.out.println();
        System.out.println("*** Example 5. Optional  ***");
        Optional<String> optional = Optional.of("test");

        System.out.println(optional.isPresent());                       // true
        System.out.println(optional.get());                             // "test"
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "t"
        optional = Optional.empty();
//        System.out.println(optional.get());    // java.util.NoSuchElementException: No value present

        /* Example 6. Streams */
        System.out.println();
        System.out.println("*** Example 6. Streams  ***");
        List<String> names4 = Arrays.asList("Ivan", "Maria", "Anna", "Andrey", "Sergey", "Zorro");

        // Filter
        names4.stream()
                .filter(s -> s.startsWith("A"))
                .forEach(System.out::println);

        // Sorted & Filter
        names4.stream()
                .sorted()
                .filter((s) -> s.startsWith("A"))
                .forEach(System.out::println);

        // Map
        names4.stream()
                .sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // Matches
        boolean notStartsWithZ = names4
                .stream()
                .noneMatch((s) -> s.startsWith("Z"));
        System.out.println(notStartsWithZ);      // true

        boolean startsWithZ = names4
                .stream()
                .anyMatch((s) -> s.startsWith("Z"));
        System.out.println(startsWithZ);        // true

        boolean startsWithA = names4
                .stream()
                .anyMatch((s) -> s.startsWith("A"));
        System.out.println(startsWithA);      // true

        boolean allStartsWithA = names4
                .stream()
                .allMatch((s) -> s.startsWith("A"));
        System.out.println(allStartsWithA);      // true

        // Count
        long count = names4.stream()
                .sorted()
                .filter((s) -> s.startsWith("A"))
                .map(String::toUpperCase)
                .count();

        System.out.println(count);

        // Reduce
        Optional<String> reduced = names4.stream()
                .sorted()
                .map(String::toUpperCase)
                .reduce((s1, s2) ->
                        s1 + " - " + s2);

        reduced.ifPresent(System.out::println);
    }

/*
*** Example 1. Default methods in interfaces ***
300.0
4.0

*** Example 2. Lambda ***
[Andrey, Anna, Ivan, Maria, Sergey]
[Andrey, Anna, Ivan, Maria, Sergey]

*** Example 3. Methods as lambda ***
арбуз
новое слово
слова
диван
арбуз
новое слово
слова
диван

*** Example 4. Standard functional interfaces. Predicates ***
Anna
Andrey
Sergey

*** Example 5. Optional  ***
true
test
t

*** Example 6. Streams  ***
Anna
Andrey
Andrey
Anna
ANDREY
ANNA
IVAN
MARIA
SERGEY
true
false
true
false
2
ANDREY - ANNA - IVAN - MARIA - SERGEY
*/
}
