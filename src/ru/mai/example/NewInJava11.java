package ru.mai.example;


import ru.mai.data.Entity;

import java.util.ArrayList;
import java.util.List;

public class NewInJava11 {

    public static void example() {

        // var
        List<Entity> entityList = new ArrayList<>();
        entityList.add(new Entity(1, "first", 111));
        var entity = entityList.get(0);

        System.out.println(entity.getKey() + " :: " + entity.getValue());

        /*  java.lang.String  */

        /*
        boolean isBlank(): возвращает true, если строка пуста или содержит только пробелы, иначе false.
        Stream lines(): возвращает поток строк, извлеченных из этой строки, разделенных терминаторами строк.
        String repeat(int): возвращает строку, значение которой представляет собой конкатенацию этой строки,
                        повторяющуюся int раз.
        String strip(): Возвращает строку, из которой удалены все пробелы, которые находятся до первого символа,
                        не являющегося пробелом, или после последнего.
        String stripLeading(): Возвращает строку, из которой удалены все пробелы,
                        которые находятся до первого символа, не являющегося пробелом.
        String stripTrainling(): Возвращает строку, из которой удалены все пробелы,
                        которые находятся после последнего символа, не являющегося пробелом.
         */

        /* java.lang.Thread  */

        /*
         destroy() и stop(Throwable) удалены.
         Остался deprecated stop()
         */

        /* java.util.regex.Pattern */

        /*
         Predicate asMatchPredicate() - создает предикат, который проверяет,
         соответствует ли строка заданному регулярным выражением шаблону
         */
    }
}
