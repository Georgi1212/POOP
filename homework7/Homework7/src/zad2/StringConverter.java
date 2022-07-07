package zad2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringConverter {
    public static void main(String[] args) {
        List<String> list = Stream.of("aBc", "d", "ef", "123456").
                map(String::toUpperCase).sorted().
                collect(Collectors.toList());

        System.out.println(list);

    }
}
