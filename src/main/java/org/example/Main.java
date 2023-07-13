package org.example;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static char findFirstUniqueChar(String text) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        Set<Character> duplicates = new HashSet<>();

        String[] words = text.split("\\s+");
        for (String word : words) {
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (charCount.containsKey(c)) {
                    duplicates.add(c);
                } else {
                    charCount.put(c, 1);
                }
            }
        }

        return charCount.keySet().stream()
                .filter(c -> !duplicates.contains(c))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No unique character found."));

    }

    public static void main(String[] args) {
        String text = """
                TC makes it easy for you to shoot yourself in the foot.
                 C++ makes that harder, but when you do, it blows away your whole leg.\s
                 (с) Bjarne Stroustrup""";

        char uniqueChar = findFirstUniqueChar(text);
        System.out.println("Unique character: " + uniqueChar);
    }
}